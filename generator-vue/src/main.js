// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// 引入Element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)
Vue.config.productionTip = false

// 弹窗提示
import { success, info, warning, error } from '@/utils/alertUtils';


// 请求
import {
  deleteRequest,
  postRequest,
  putRequest,
  getRequest,
  uploadRequest
} from '@/http/HttpRequest'

// 注册请求全局属性
Vue.prototype.$put = putRequest
Vue.prototype.$post = postRequest
Vue.prototype.$get = getRequest
Vue.prototype.$remove = deleteRequest
Vue.prototype.$filePost = uploadRequest

//注册提示全局属性
Vue.prototype.$error = error
Vue.prototype.$success = success
Vue.prototype.$info = info
Vue.prototype.$warning = warning

var glob = {
  server: 'http://www.memoryoverflow.cn/',
  // server: 'http://localhost:8190/',
}

Vue.prototype.$glob = glob

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
