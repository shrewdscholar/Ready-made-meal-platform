<template>
	<div class="addEdit-block" :style='{"padding":"30px"}'>
		<el-form
			:style='{"borderRadius":"6px","padding":"30px"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="200px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="订单编号" prop="dingdanbianhao">
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.dingdanbianhao" label="订单编号" prop="dingdanbianhao">
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="商家" prop="dianpumingcheng">
					<el-input v-model="ruleForm.dianpumingcheng" placeholder="商家" clearable  :readonly="ro.dianpumingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="商家" prop="dianpumingcheng">
					<el-input v-model="ruleForm.dianpumingcheng" placeholder="商家" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="预制菜名称" prop="xizhuangmingcheng">
					<el-input v-model="ruleForm.xizhuangmingcheng" placeholder="预制菜名称" clearable  :readonly="ro.xizhuangmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="预制菜名称" prop="xizhuangmingcheng">
					<el-input v-model="ruleForm.xizhuangmingcheng" placeholder="预制菜名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="预制菜分类" prop="xizhuangfenlei">
					<el-input v-model="ruleForm.xizhuangfenlei" placeholder="预制菜分类" clearable  :readonly="ro.xizhuangfenlei"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="预制菜分类" prop="xizhuangfenlei">
					<el-input v-model="ruleForm.xizhuangfenlei" placeholder="预制菜分类" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.dingzhifengmian" label="定制封面" prop="dingzhifengmian">
					<file-upload
						tip="点击上传定制封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.dingzhifengmian?ruleForm.dingzhifengmian:''"
						@change="dingzhifengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.dingzhifengmian" label="定制封面" prop="dingzhifengmian">
					<img v-if="ruleForm.dingzhifengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.dingzhifengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.dingzhifengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="定制分量" prop="dingzhichima">
					<el-select :disabled="ro.dingzhichima" v-model="ruleForm.dingzhichima" placeholder="请选择定制分量" >
						<el-option
							v-for="(item,index) in dingzhichimaOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="定制分量" prop="dingzhichima">
					<el-input v-model="ruleForm.dingzhichima"
						placeholder="定制分量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="定制价格" prop="dingzhijiage">
					<el-input-number v-model="ruleForm.dingzhijiage" placeholder="定制价格" :readonly="ro.dingzhijiage"></el-input-number>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="定制价格" prop="dingzhijiage">
					<el-input v-model="ruleForm.dingzhijiage" placeholder="定制价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="定制数量" prop="dingzhishuliang">
					<el-input v-model.number="ruleForm.dingzhishuliang" placeholder="定制数量" clearable  :readonly="ro.dingzhishuliang"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="定制数量" prop="dingzhishuliang">
					<el-input v-model="ruleForm.dingzhishuliang" placeholder="定制数量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="总价格" prop="money">
					<el-input v-model="money" placeholder="总价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.money" label="总价格" prop="money">
					<el-input v-model="ruleForm.money" placeholder="总价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="用户名" prop="yonghuming">
					<el-input v-model="ruleForm.yonghuming" placeholder="用户名" clearable  :readonly="ro.yonghuming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="用户名" prop="yonghuming">
					<el-input v-model="ruleForm.yonghuming" placeholder="用户名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="余额" prop="yue">
					<el-input v-model="ruleForm.yue" placeholder="余额" clearable  :readonly="ro.yue"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="余额" prop="yue">
					<el-input v-model="ruleForm.yue" placeholder="余额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="收货地址" prop="shouhuodizhi">
					<el-input v-model="ruleForm.shouhuodizhi" placeholder="收货地址" clearable  :readonly="ro.shouhuodizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="收货地址" prop="shouhuodizhi">
					<el-input v-model="ruleForm.shouhuodizhi" placeholder="收货地址" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="定制内容" prop="dingzhineirong">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.dingzhineirong" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.dingzhineirong" label="定制内容" prop="dingzhineirong">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.dingzhineirong"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				dingdanbianhao : false,
				dianpumingcheng : false,
				xizhuangmingcheng : false,
				xizhuangfenlei : false,
				dingzhifengmian : false,
				dingzhichima : false,
				dingzhijiage : false,
				dingzhishuliang : false,
				money : false,
				dingzhineirong : false,
				yonghuming : false,
				xingming : false,
				shouji : false,
				yue : false,
				shouhuodizhi : false,
				sfsh : false,
				shhf : false,
				ispay : false,
			},
			
			
			ruleForm: {
				dingdanbianhao: this.getUUID(),
				dianpumingcheng: '',
				xizhuangmingcheng: '',
				xizhuangfenlei: '',
				dingzhifengmian: '',
				dingzhichima: '',
				dingzhijiage: '',
				dingzhishuliang: '',
				money: '',
				dingzhineirong: '',
				yonghuming: '',
				xingming: '',
				shouji: '',
				yue: '',
				shouhuodizhi: '',
				shhf: '',
			},
		
			dingzhichimaOptions: [],

			
			rules: {
				dingdanbianhao: [
				],
				dianpumingcheng: [
				],
				xizhuangmingcheng: [
				],
				xizhuangfenlei: [
				],
				dingzhifengmian: [
				],
				dingzhichima: [
					{ required: true, message: '定制分量不能为空', trigger: 'blur' },
				],
				dingzhijiage: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				dingzhishuliang: [
					{ required: true, message: '定制数量不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				money: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				dingzhineirong: [
					{ required: true, message: '定制内容不能为空', trigger: 'blur' },
				],
				yonghuming: [
				],
				xingming: [
				],
				shouji: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				yue: [
				],
				shouhuodizhi: [
					{ required: true, message: '收货地址不能为空', trigger: 'blur' },
				],
				sfsh: [
				],
				shhf: [
				],
				ispay: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {
		money : {
			get: function () {
				let c = this.ruleForm
				let a = c.dingzhijiage*c.dingzhishuliang
				this.ruleForm.money = a?Number(a).toFixed(2):0
				return a?Number(a).toFixed(2):0
			}
			
		},



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='dingdanbianhao'){
							this.ruleForm.dingdanbianhao = obj[o];
							this.ro.dingdanbianhao = true;
							continue;
						}
						if(o=='dianpumingcheng'){
							this.ruleForm.dianpumingcheng = obj[o];
							this.ro.dianpumingcheng = true;
							continue;
						}
						if(o=='xizhuangmingcheng'){
							this.ruleForm.xizhuangmingcheng = obj[o];
							this.ro.xizhuangmingcheng = true;
							continue;
						}
						if(o=='xizhuangfenlei'){
							this.ruleForm.xizhuangfenlei = obj[o];
							this.ro.xizhuangfenlei = true;
							continue;
						}
						if(o=='dingzhifengmian'){
							this.ruleForm.dingzhifengmian = obj[o];
							this.ro.dingzhifengmian = true;
							continue;
						}
						if(o=='dingzhichima'){
							this.ruleForm.dingzhichima = obj[o];
							this.ro.dingzhichima = true;
							continue;
						}
						if(o=='dingzhijiage'){
							this.ruleForm.dingzhijiage = obj[o];
							this.ro.dingzhijiage = true;
							continue;
						}
						if(o=='dingzhishuliang'){
							this.ruleForm.dingzhishuliang = obj[o];
							this.ro.dingzhishuliang = true;
							continue;
						}
						if(o=='money'){
							this.ruleForm.money = obj[o];
							this.ro.money = true;
							continue;
						}
						if(o=='dingzhineirong'){
							this.ruleForm.dingzhineirong = obj[o];
							this.ro.dingzhineirong = true;
							continue;
						}
						if(o=='yonghuming'){
							this.ruleForm.yonghuming = obj[o];
							this.ro.yonghuming = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='shouji'){
							this.ruleForm.shouji = obj[o];
							this.ro.shouji = true;
							continue;
						}
						if(o=='yue'){
							this.ruleForm.yue = obj[o];
							this.ro.yue = true;
							continue;
						}
						if(o=='shouhuodizhi'){
							this.ruleForm.shouhuodizhi = obj[o];
							this.ro.shouhuodizhi = true;
							continue;
						}
				}
				







				this.ruleForm.dingzhishuliang = 0
				this.ro.dingzhishuliang = false;











			}
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(this.$storage.get("role")!="管理员") {
						this.ro.dingzhijiage = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.money = true;
					}
					if(((json.yonghuming!=''&&json.yonghuming) || json.yonghuming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuming = json.yonghuming
						this.ro.yonghuming = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.yonghuming = true;
					}
					if(((json.xingming!=''&&json.xingming) || json.xingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xingming = json.xingming
						this.ro.xingming = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.xingming = true;
					}
					if(((json.shouji!=''&&json.shouji) || json.shouji==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shouji = json.shouji
						this.ro.shouji = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.shouji = true;
					}
					if(((json.money!=''&&json.money) || json.money==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yue = json.money
						this.ro.yue = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.yue = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.dingzhichimaOptions = "S,M,L,XL,XXL,XXXL".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `xizhuangdingzhi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.dingzhineirong = this.ruleForm.dingzhineirong.replace(reg,'../../../springboot01u2zqkf/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
		if(this.ruleForm.money==0){
			this.$message.error('总价格不能为空')
			return false
		}
		if(this.ruleForm.dingdanbianhao) {
			this.ruleForm.dingdanbianhao = String(this.ruleForm.dingdanbianhao)
		}





	if(this.ruleForm.dingzhifengmian!=null) {
		this.ruleForm.dingzhifengmian = this.ruleForm.dingzhifengmian.replace(new RegExp(this.$base.url,"g"),"");
	}














var objcross = this.$storage.getObj('crossObj');
      var table = this.$storage.getObj('crossTable');
      if(objcross!=null) {
		  if(!this.ruleForm.dingzhishuliang){
			  this.$message.error("定制数量不能为空");
			  return
		  }
	      objcross.dingzhishuliang = objcross.dingzhishuliang - this.ruleForm.dingzhishuliang
	      if(objcross.dingzhishuliang<0){
				this.$message.error("定制数量不足");
				return
	      }
                }
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                              this.$http({
                                  url: `${table}/update`,
                                  method: "post",
                                  data: objcross
                                }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "xizhuangdingzhi/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `xizhuangdingzhi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.xizhuangdingzhiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
									this.$http({
										url: `${table}/update`,
										method: "post",
										data: objcross
									}).then(({ data }) => {});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `xizhuangdingzhi/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$http({
						url: `${table}/update`,
						method: "post",
						data: objcross
					}).then(({ data }) => {});
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.xizhuangdingzhiCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.xizhuangdingzhiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    dingzhifengmianUploadChange(fileUrls) {
	    this.ruleForm.dingzhifengmian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 200px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #eee;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #333;
	  	  object-fit: cover;
	  	  width: 140px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #eee;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #333;
	  	  object-fit: cover;
	  	  width: 140px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #eee;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #333;
	  	  object-fit: cover;
	  	  width: 140px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
