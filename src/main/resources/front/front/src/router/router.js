import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import shangjiaList from '../pages/shangjia/list'
import shangjiaDetail from '../pages/shangjia/detail'
import shangjiaAdd from '../pages/shangjia/add'
import xizhuangfenleiList from '../pages/xizhuangfenlei/list'
import xizhuangfenleiDetail from '../pages/xizhuangfenlei/detail'
import xizhuangfenleiAdd from '../pages/xizhuangfenlei/add'
import xizhuangxinxiList from '../pages/xizhuangxinxi/list'
import xizhuangxinxiDetail from '../pages/xizhuangxinxi/detail'
import xizhuangxinxiAdd from '../pages/xizhuangxinxi/add'
import xizhuangdingzhiList from '../pages/xizhuangdingzhi/list'
import xizhuangdingzhiDetail from '../pages/xizhuangdingzhi/detail'
import xizhuangdingzhiAdd from '../pages/xizhuangdingzhi/add'
import zaixiangoutongList from '../pages/zaixiangoutong/list'
import zaixiangoutongDetail from '../pages/zaixiangoutong/detail'
import zaixiangoutongAdd from '../pages/zaixiangoutong/add'
import huifuxinxiList from '../pages/huifuxinxi/list'
import huifuxinxiDetail from '../pages/huifuxinxi/detail'
import huifuxinxiAdd from '../pages/huifuxinxi/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import friendlinkList from '../pages/friendlink/list'
import friendlinkDetail from '../pages/friendlink/detail'
import friendlinkAdd from '../pages/friendlink/add'
import discussxizhuangxinxiList from '../pages/discussxizhuangxinxi/list'
import discussxizhuangxinxiDetail from '../pages/discussxizhuangxinxi/detail'
import discussxizhuangxinxiAdd from '../pages/discussxizhuangxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'shangjia',
					component: shangjiaList
				},
				{
					path: 'shangjiaDetail',
					component: shangjiaDetail
				},
				{
					path: 'shangjiaAdd',
					component: shangjiaAdd
				},
				{
					path: 'xizhuangfenlei',
					component: xizhuangfenleiList
				},
				{
					path: 'xizhuangfenleiDetail',
					component: xizhuangfenleiDetail
				},
				{
					path: 'xizhuangfenleiAdd',
					component: xizhuangfenleiAdd
				},
				{
					path: 'xizhuangxinxi',
					component: xizhuangxinxiList
				},
				{
					path: 'xizhuangxinxiDetail',
					component: xizhuangxinxiDetail
				},
				{
					path: 'xizhuangxinxiAdd',
					component: xizhuangxinxiAdd
				},
				{
					path: 'xizhuangdingzhi',
					component: xizhuangdingzhiList
				},
				{
					path: 'xizhuangdingzhiDetail',
					component: xizhuangdingzhiDetail
				},
				{
					path: 'xizhuangdingzhiAdd',
					component: xizhuangdingzhiAdd
				},
				{
					path: 'zaixiangoutong',
					component: zaixiangoutongList
				},
				{
					path: 'zaixiangoutongDetail',
					component: zaixiangoutongDetail
				},
				{
					path: 'zaixiangoutongAdd',
					component: zaixiangoutongAdd
				},
				{
					path: 'huifuxinxi',
					component: huifuxinxiList
				},
				{
					path: 'huifuxinxiDetail',
					component: huifuxinxiDetail
				},
				{
					path: 'huifuxinxiAdd',
					component: huifuxinxiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'friendlink',
					component: friendlinkList
				},
				{
					path: 'friendlinkDetail',
					component: friendlinkDetail
				},
				{
					path: 'friendlinkAdd',
					component: friendlinkAdd
				},
				{
					path: 'discussxizhuangxinxi',
					component: discussxizhuangxinxiList
				},
				{
					path: 'discussxizhuangxinxiDetail',
					component: discussxizhuangxinxiDetail
				},
				{
					path: 'discussxizhuangxinxiAdd',
					component: discussxizhuangxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
