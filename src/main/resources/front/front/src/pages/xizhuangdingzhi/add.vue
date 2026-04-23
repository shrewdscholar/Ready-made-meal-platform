<template>
<div :style='{"width":"100%","padding":"30px 7% 40px","margin":"0px auto","position":"relative","background":"#edeff1"}'>
    <el-form
	  :style='{"border":"0px solid #28890b30","width":"100%","padding":"30px","position":"relative","background":"none"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="150px"
    >
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="订单编号" prop="dingdanbianhao">
              <el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" disabled></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="商家" prop="dianpumingcheng">
            <el-input v-model="ruleForm.dianpumingcheng" 
                placeholder="商家" clearable :disabled=" false  ||ro.dianpumingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="预制菜名称" prop="xizhuangmingcheng">
            <el-input v-model="ruleForm.xizhuangmingcheng" 
                placeholder="预制菜名称" clearable :disabled=" false  ||ro.xizhuangmingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="预制菜分类" prop="xizhuangfenlei">
            <el-input v-model="ruleForm.xizhuangfenlei" 
                placeholder="预制菜分类" clearable :disabled=" false  ||ro.xizhuangfenlei"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="定制封面" v-if="type!='cross' || (type=='cross' && !ro.dingzhifengmian)" prop="dingzhifengmian">
            <file-upload
            tip="点击上传定制封面"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.dingzhifengmian?ruleForm.dingzhifengmian:''"
            @change="dingzhifengmianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="定制封面" prop="dingzhifengmian">
                <img v-if="ruleForm.dingzhifengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.dingzhifengmian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.dingzhifengmian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="定制分量" prop="dingzhichima">
            <el-select v-model="ruleForm.dingzhichima" placeholder="请选择定制分量" :disabled=" false  ||ro.dingzhichima" >
              <el-option
                  v-for="(item,index) in dingzhichimaOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="定制价格" prop="dingzhijiage">
			<el-input-number v-model="ruleForm.dingzhijiage" placeholder="定制价格" :readonly="ro.dingzhijiage"></el-input-number>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="定制数量" prop="dingzhishuliang">
            <el-input v-model.number="ruleForm.dingzhishuliang" 
                placeholder="定制数量" clearable :disabled=" false  ||ro.dingzhishuliang"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="总价格" prop="money">
              <el-input v-model="money" placeholder="总价格" disabled></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用户名" prop="yonghuming">
            <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" clearable :disabled="true  ||ro.yonghuming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="姓名" prop="xingming">
            <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" clearable :disabled="true  ||ro.xingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="手机" prop="shouji">
            <el-input v-model="ruleForm.shouji" 
                placeholder="手机" clearable :disabled="true  ||ro.shouji"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="余额" prop="yue">
            <el-input v-model="ruleForm.yue" 
                placeholder="余额" clearable :disabled="true  ||ro.yue"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="收货地址" prop="shouhuodizhi">
            <el-input v-model="ruleForm.shouhuodizhi" 
                placeholder="收货地址" clearable :disabled=" false  ||ro.shouhuodizhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="定制内容" prop="dingzhineirong">
            <editor 
                :style='{"minHeight":"250px","padding":"0","margin":"0","borderColor":"#1abc9e30","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.dingzhineirong" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"10px 0 0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"20px","background":"#3795c4","width":"128px","lineHeight":"44px","fontSize":"16px","height":"44px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #3795c4","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#3795c4","borderRadius":"30px","background":"none","width":"128px","lineHeight":"44px","fontSize":"16px","height":"44px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
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
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
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
          ispay: '',
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
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          dingzhishuliang: [
            { required: true, message: '定制数量不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          money: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          dingzhineirong: [
            { required: true, message: '定制内容不能为空', trigger: 'blur' },
          ],
          yonghuming: [
          ],
          xingming: [
          ],
          shouji: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
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
        },
		centerType: false,
      };
    },
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
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
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
              this.ruleForm.dingzhifengmian = obj[o].split(",")[0];
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
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.yonghuming!=''&&json.yonghuming) || json.yonghuming==0){
                this.ruleForm.yonghuming = json.yonghuming
            }
            if((json.xingming!=''&&json.xingming) || json.xingming==0){
                this.ruleForm.xingming = json.xingming
            }
            if((json.shouji!=''&&json.shouji) || json.shouji==0){
                this.ruleForm.shouji = json.shouji
            }
            if((json.money!=''&&json.money) || json.money==0){
                this.ruleForm.yue = json.money
            }
          }
        });
        this.dingzhichimaOptions = "S,M,L,XL,XXL,XXXL".split(',')

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`xizhuangdingzhi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			if(this.ruleForm.money==0){
				this.$message.error('总价格不能为空')
				return false
			}
			if(this.ruleForm.dingdanbianhao){
				this.ruleForm.dingdanbianhao = String(this.ruleForm.dingdanbianhao)
			}
			if(!this.ruleForm.dingzhishuliang){
				this.$message.error("定制数量不能为空");
				return
			}
			var obj = JSON.parse(localStorage.getItem('crossObj'));
			var table = localStorage.getItem('crossTable');
			obj.dingzhishuliang = obj.dingzhishuliang - this.ruleForm.dingzhishuliang
			if(obj.dingzhishuliang<0){
				this.$message.error("定制数量不足");
				return
			}
      
			//this.$http.post(table+`/update`, obj).then(res => {});
			if(this.ruleForm.money>this.ruleForm.yue){
				this.$message.error("总价格不能超过余额");
				return
			}
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('xizhuangdingzhi/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								var table = localStorage.getItem('crossTable');

								obj.dingzhishuliang = parseFloat(obj.dingzhishuliang) - parseFloat(this.ruleForm.dingzhishuliang)

								this.$http.post(table+`/update`,obj).then(res => {});
								this.$http.post(`xizhuangdingzhi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {
						var obj = JSON.parse(localStorage.getItem('crossObj'));
						var table = localStorage.getItem('crossTable');

						obj.dingzhishuliang = parseFloat(obj.dingzhishuliang) - parseFloat(this.ruleForm.dingzhishuliang)

						this.$http.post(table+`/update`,obj).then(res => {});
						this.$http.post(`xizhuangdingzhi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
			this.$router.go(-1);
		},
      dingzhifengmianUploadChange(fileUrls) {
          this.ruleForm.dingzhifengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 150px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #ddd;
	  border-radius: 4px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #ddd;
	  border-radius: 4px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border-radius: 4px;
	  padding: 0 10px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
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
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 80px;
	  border-radius: 4px;
	  background: #fff;
	  width: 80px;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 80px;
	  border-radius: 4px;
	  background: #fff;
	  width: 80px;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 80px;
	  border-radius: 4px;
	  background: #fff;
	  width: 80px;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  height: 80px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 0px solid #eee;
	  border-radius: 0px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  min-width: 800px;
	  height: 120px;
	}
</style>
