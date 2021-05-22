package com.day.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private static String charSet = "utf-8";
    private static CloseableHttpClient httpClient = null;
    private static CloseableHttpResponse response = null;

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);


    /*
    http post 表单格式
     */
    public static String postRemote(String url, Map<String, String> param) throws IOException {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            createForm(httpPost, param);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), charSet);
            return resultString;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

    public static String getRemote(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), charSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    // 创建参数列表
    private static void createForm(HttpPost httpPost, Map<String, String> param) throws UnsupportedEncodingException {
        if (param != null) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : param.keySet()) {
                paramList.add(new BasicNameValuePair(key, param.get(key)));
            }
            // 模拟表单
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, charSet);
            httpPost.setEntity(entity);
        }
    }

    /*
    http post json格式
     */
    public static String jsonPost(String url, Map<String, Object> map) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        try {
            StringEntity s = new StringEntity(JSONObject.parseObject(JSON.toJSONString(map)).toString(), charSet);
            s.setContentEncoding(charSet);
            //发送json数据需要设置contentType
            s.setContentType("application/json");
            post.addHeader("Content-Type", "application/json;charset=utf-8");
            post.setEntity(s);
            HttpResponse res = httpClient.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 返回json格式：
                return EntityUtils.toString(res.getEntity());
            }
        } catch (Exception e) {
            logger.info("post,json格式提交问题，{}", e.getMessage());
        }
        return "";
    }

    public static String jsonPut(String url, Map<String, Object> map) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut put = new HttpPut(url);
        try {
            StringEntity s = new StringEntity(JSONObject.parseObject(JSON.toJSONString(map)).toString(), charSet);
            s.setContentEncoding(charSet);
            //发送json数据需要设置contentType
            s.setContentType("application/json");
            put.addHeader("Content-Type", "application/json;charset=utf-8");
            put.setEntity(s);
            HttpResponse res = httpClient.execute(put);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 返回json格式：
                return EntityUtils.toString(res.getEntity(), charSet);
            }
        } catch (Exception e) {
            logger.info("put,json格式提交问题，{}", e.getMessage());
        }
        return "";
    }

    public static CloseableHttpClient createSSLClientDefault() {
        try {
            //使用 loadTrustMaterial() 方法实现一个信任策略，信任所有证书
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            //NoopHostnameVerifier类:  作为主机名验证工具，实质上关闭了主机名验证，它接受任何
            //有效的SSL会话并匹配到目标主机。
            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

    public static String httpClientGet(String url) throws IOException {
        // 获取http客户端
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {

            // 通过httpget方式来实现我们的get请求
            HttpGet httpGet = new HttpGet(url);
            // 通过client调用execute方法，得到我们的执行结果就是一个response，所有的数据都封装在response里面了
            response = client.execute(httpGet);
            // HttpEntity
            // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
            // 所有的响应的数据，也全部都是封装在HttpEntity里面
            HttpEntity entity = response.getEntity();
            // 通过EntityUtils 来将我们的数据转换成字符串
            return EntityUtils.toString(entity, charSet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭
            if (response != null) {
                response.close();
            }
            client.close();
        }
        return "";
    }
}
