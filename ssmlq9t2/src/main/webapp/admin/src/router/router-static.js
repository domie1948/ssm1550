import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import bumenxinxi from '@/views/modules/bumenxinxi/list'
    import news from '@/views/modules/news/list'
    import zhiweixinxi from '@/views/modules/zhiweixinxi/list'
    import shujuku from '@/views/modules/shujuku/list'
    import zhengshiyuangong from '@/views/modules/zhengshiyuangong/list'
    import zongguanliyuan from '@/views/modules/zongguanliyuan/list'
    import zhiweidiaodushenqing from '@/views/modules/zhiweidiaodushenqing/list'
    import baoxiaoshenqing from '@/views/modules/baoxiaoshenqing/list'
    import config from '@/views/modules/config/list'
    import linshiyuangong from '@/views/modules/linshiyuangong/list'
    import gongzuojindu from '@/views/modules/gongzuojindu/list'
    import users from '@/views/modules/users/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/bumenxinxi',
        name: '部门信息',
        component: bumenxinxi
      }
          ,{
	path: '/news',
        name: '通知栏',
        component: news
      }
          ,{
	path: '/zhiweixinxi',
        name: '职位信息',
        component: zhiweixinxi
      }
          ,{
	path: '/shujuku',
        name: '数据库',
        component: shujuku
      }
          ,{
	path: '/zhengshiyuangong',
        name: '正式员工',
        component: zhengshiyuangong
      }
          ,{
	path: '/zongguanliyuan',
        name: '总管理员',
        component: zongguanliyuan
      }
          ,{
	path: '/zhiweidiaodushenqing',
        name: '职位调度申请',
        component: zhiweidiaodushenqing
      }
          ,{
	path: '/baoxiaoshenqing',
        name: '报销申请',
        component: baoxiaoshenqing
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
          ,{
	path: '/linshiyuangong',
        name: '临时员工',
        component: linshiyuangong
      }
          ,{
	path: '/gongzuojindu',
        name: '工作进度',
        component: gongzuojindu
      }
          ,{
	path: '/users',
        name: '管理员',
        component: users
      }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
