// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import axios from 'axios'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false;
Vue.prototype.$axios = axios; //将axios挂载在Vue实例原型上
// 设置axios请求的token
axios.defaults.headers.common['token'] = 'f4c902c9ae5a2a9d8f84868ad064e706';
//设置请求头
axios.defaults.headers.post["Content-type"] = "application/json";
Vue.use(ElementUI);
/* eslint-disable no-new */
new Vue({
  router,
  render: h => h(App)
}).$mount('#app');
