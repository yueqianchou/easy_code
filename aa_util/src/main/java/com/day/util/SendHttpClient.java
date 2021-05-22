package com.day.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import static org.apache.commons.codec.Charsets.UTF_8;


/**
 * @description: http请求工具类
 */

public class SendHttpClient {
    private final static Logger log = LoggerFactory.getLogger(SendHttpClient.class);
    /**
     * http get请求
     *
     * @param httpUrl 链接
     * @return 响应数据
     */
    public static String doGet(String httpUrl) {
        //链接
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuffer result = new StringBuffer();
        try {
            //创建连接
            URL url = new URL(httpUrl);
            connection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            connection.setRequestMethod("GET");
            //设置连接超时时间
            connection.setConnectTimeout(15000);
            //设置读取超时时间
            connection.setReadTimeout(15000);
            //开始连接
            connection.connect();
            //获取响应数据
            if (connection.getResponseCode() == 200) {
                //获取返回的数据
                is = connection.getInputStream();
                if (is != null) {
                    br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String temp = null;
                    while ((temp = br.readLine()) != null) {
                        result.append(temp);
                    }
                }
            }
        } catch (MalformedURLException e) {
            log.error("SendHttpClient method doGet error={}",e);
        } catch (IOException e) {
            log.error("SendHttpClient method doGet error={}",e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("SendHttpClient method doGet error={}",e);
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("SendHttpClient method doGet error={}",e);
                }
            }
            connection.disconnect();// 关闭远程连接
        }
        return result.toString();
    }

    /**
     * post请求
     *
     * @param httpUrl 链接
     * @param param   参数
     * @return
     */
    public static String doPost(String httpUrl, String param) {
        StringBuffer result = new StringBuffer();
        //连接
        HttpURLConnection connection = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            //创建连接对象
            URL url = new URL(httpUrl);
            //创建连接
            connection = (HttpURLConnection) url.openConnection();
            //设置请求方法
            connection.setRequestMethod("POST");
            //设置连接超时时间
            connection.setConnectTimeout(15000);
            //设置读取超时时间
            connection.setReadTimeout(15000);
            //设置是否可读取
            connection.setDoOutput(true);
            //设置响应是否可读取
            connection.setDoInput(true);
            //设置参数类型
            connection.setRequestProperty("Content-Type", "application/json");
            //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //拼装参数
            if (param != null && !param.equals("")) {
                //设置参数
                os = connection.getOutputStream();
                //拼装参数
                os.write(param.getBytes("UTF-8"));
            }
            //设置权限
            //设置请求头等
            //开启连接
            //connection.connect();
            //读取响应
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                if (is != null) {
                    br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String temp = null;
                    if ((temp = br.readLine()) != null) {
                        result.append(temp);
                    }
                }
            }
            //关闭连接
        } catch (MalformedURLException e) {
            log.error("SendHttpClient method doPost error={}",e);
        } catch (IOException e) {
            log.error("SendHttpClient method doPost error={}",e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("SendHttpClient method doPost error={}",e);
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("SendHttpClient method doPost error={}",e);
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("SendHttpClient method doPost error={}",e);
                }
            }
            //关闭连接
            connection.disconnect();
        }
        return result.toString();
    }

    /**
     * post请求
     *
     * @param httpUrl 链接
     * @param jsonParam json参数
     * @return
     */
    public static String doPost(String httpUrl, JSONObject jsonParam) {
        StringBuffer result = new StringBuffer();
        //连接
        HttpURLConnection connection = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            //创建连接对象
            URL url = new URL(httpUrl);
            //创建连接
            connection = (HttpURLConnection) url.openConnection();
            //设置请求方法
            connection.setRequestMethod("POST");
            //设置连接超时时间
            connection.setConnectTimeout(15000);
            //设置读取超时时间
            connection.setReadTimeout(15000);
            //设置是否可读取
            connection.setDoOutput(true);
            //设置响应是否可读取
            connection.setDoInput(true);
            //设置参数类型
            connection.setRequestProperty("Content-Type", "application/json");
            Object authorization = jsonParam.get("Authorization");
            if (authorization != null) {
                connection.setRequestProperty("Authorization", String.valueOf(authorization));
            }
            //拼装参数
            if (jsonParam != null && !jsonParam.toJSONString().equals("")) {
                //设置参数
                os = connection.getOutputStream();
                //拼装参数
                os.write(jsonParam.toJSONString().getBytes("UTF-8"));
            }
            //设置权限
            //设置请求头等
            //开启连接
            //connection.connect();
            //读取响应
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                if (is != null) {
                    br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String temp = null;
                    if ((temp = br.readLine()) != null) {
                        result.append(temp);
                    }
                }
            }
            //关闭连接
        } catch (MalformedURLException e) {
            log.error("SendHttpClient method doPost error={}",e);
        } catch (IOException e) {
            log.error("SendHttpClient method doPost error={}",e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("SendHttpClient method doPost error={}",e);
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("SendHttpClient method doPost error={}",e);
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("SendHttpClient method doPost error={}",e);
                }
            }
            //关闭连接
            connection.disconnect();
        }
        return result.toString();
    }

    /**
     *@Description: 返回一个Basic认证的Client
     *@Param: username, password
     *@return: CloseableHttpClient
     *@Author: noahw
     *@Date: 2020/03/09
     *@Version: 1.0
     */
    public static CloseableHttpClient getBasicHttpClient(String username, String password) {
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // 设置BasicAuth
        CredentialsProvider provider = new BasicCredentialsProvider();
        // Create the authentication scope
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM);
        // Create credential pair，在此处填写用户名和密码
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username,password);
        // Inject the credentials
        provider.setCredentials(scope, credentials);
        // Set the default credentials provider
        httpClientBuilder.setDefaultCredentialsProvider(provider);
        // HttpClient
        return httpClientBuilder.build();
    }

    public static String doPut(String url, List<NameValuePair> params) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        HttpPut put = new HttpPut(url);
        put.addHeader("Content-Type", "application/json");
        put.setEntity(new UrlEncodedFormEntity(params, UTF_8));
        CloseableHttpResponse response = client.execute(put);
        return EntityUtils.toString(response.getEntity(), UTF_8);
    }

    public static String doPut(String url, List<NameValuePair> params, List<NameValuePair> headers) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        HttpPut put = new HttpPut(url);
        put.addHeader("Content-Type", "application/json");
        for (NameValuePair header : headers) {
            put.addHeader(header.getName(),header.getValue());
        }
        put.setEntity(new UrlEncodedFormEntity(params, UTF_8));
        CloseableHttpResponse response = client.execute(put);
        return EntityUtils.toString(response.getEntity(), UTF_8);
    }

    public static String doDelete(String url) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        HttpDelete delete = new HttpDelete(url);
        delete.addHeader("Content-Type", "application/json");
        CloseableHttpResponse response = client.execute(delete);
        return EntityUtils.toString(response.getEntity(), UTF_8);
    }

    public static String doDelete(String url, List<NameValuePair> params) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        HttpDeleteWithBody delete = new HttpDeleteWithBody(url);
        delete.addHeader("Content-Type", "application/json");
        delete.setEntity(new UrlEncodedFormEntity(params, UTF_8));
        CloseableHttpResponse response = client.execute(delete);
        return EntityUtils.toString(response.getEntity(), UTF_8);
    }

    static class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "DELETE";
        @Override
        public String getMethod() { return METHOD_NAME; }

        public HttpDeleteWithBody(final String uri) {
            super();
            setURI(URI.create(uri));
        }
        public HttpDeleteWithBody(final URI uri) {
            super();
            setURI(uri);
        }
        public HttpDeleteWithBody() { super(); }
    }
}