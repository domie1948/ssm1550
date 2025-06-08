<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                              <el-col :span="12">
        <el-form-item   v-if="flag=='linshiyuangong'"  label="工号" prop="gonghao">
          <el-input v-model="ruleForm.gonghao" readonly              placeholder="工号" clearable></el-input>
        </el-form-item>
      </el-col>
                                          <el-col :span="12">
        <el-form-item   v-if="flag=='linshiyuangong'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='linshiyuangong'"  label="当前状态" prop="dangqianzhuangtai">
          <el-select v-model="ruleForm.dangqianzhuangtai" placeholder="请选择当前状态">
            <el-option
                v-for="(item,index) in linshiyuangongdangqianzhuangtaiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='linshiyuangong'"  label="部门名称" prop="bumenmingcheng">
          <el-select v-model="ruleForm.bumenmingcheng" placeholder="请选择部门名称">
            <el-option
                v-for="(item,index) in linshiyuangongbumenmingchengOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='linshiyuangong'"  label="职位" prop="zhiwei">
          <el-select v-model="ruleForm.zhiwei" placeholder="请选择职位">
            <el-option
                v-for="(item,index) in linshiyuangongzhiweiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='linshiyuangong'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in linshiyuangongxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='linshiyuangong'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='linshiyuangong'"  label="邮箱" prop="youxiang">
          <el-input v-model="ruleForm.youxiang"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='linshiyuangong'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='linshiyuangong'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="linshiyuangongtupianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                                                <el-col :span="12">
        <el-form-item   v-if="flag=='zhengshiyuangong'"  label="工号" prop="gonghao">
          <el-input v-model="ruleForm.gonghao" readonly              placeholder="工号" clearable></el-input>
        </el-form-item>
      </el-col>
                                          <el-col :span="12">
        <el-form-item   v-if="flag=='zhengshiyuangong'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='zhengshiyuangong'"  label="当前状态" prop="dangqianzhuangtai">
          <el-select v-model="ruleForm.dangqianzhuangtai" placeholder="请选择当前状态">
            <el-option
                v-for="(item,index) in zhengshiyuangongdangqianzhuangtaiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='zhengshiyuangong'"  label="部门" prop="bumen">
          <el-select v-model="ruleForm.bumen" placeholder="请选择部门">
            <el-option
                v-for="(item,index) in zhengshiyuangongbumenOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='zhengshiyuangong'"  label="职位" prop="zhiwei">
          <el-select v-model="ruleForm.zhiwei" placeholder="请选择职位">
            <el-option
                v-for="(item,index) in zhengshiyuangongzhiweiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='zhengshiyuangong'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in zhengshiyuangongxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='zhengshiyuangong'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='zhengshiyuangong'"  label="邮箱" prop="youxiang">
          <el-input v-model="ruleForm.youxiang"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='zhengshiyuangong'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='zhengshiyuangong'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="zhengshiyuangongtupianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                                                                                                            <el-col :span="12">
        <el-form-item   v-if="flag=='zongguanliyuan'"  label="工号" prop="gonghao">
          <el-input v-model="ruleForm.gonghao" readonly              placeholder="工号" clearable></el-input>
        </el-form-item>
      </el-col>
                                          <el-col :span="12">
        <el-form-item   v-if="flag=='zongguanliyuan'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='zongguanliyuan'"  label="部门" prop="bumen">
          <el-select v-model="ruleForm.bumen" placeholder="请选择部门">
            <el-option
                v-for="(item,index) in zongguanliyuanbumenOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='zongguanliyuan'"  label="职位" prop="zhiwei">
          <el-select v-model="ruleForm.zhiwei" placeholder="请选择职位">
            <el-option
                v-for="(item,index) in zongguanliyuanzhiweiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='zongguanliyuan'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
            <el-option
                v-for="(item,index) in zongguanliyuanxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='zongguanliyuan'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='zongguanliyuan'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='zongguanliyuan'"  label="邮箱" prop="youxiang">
          <el-input v-model="ruleForm.youxiang"               placeholder="邮箱" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="flag=='zongguanliyuan'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="zongguanliyuantupianUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
                                                      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
                                                                  linshiyuangongdangqianzhuangtaiOptions: [],
                        linshiyuangongbumenmingchengOptions: [],
                        linshiyuangongzhiweiOptions: [],
                        linshiyuangongxingbieOptions: [],
                                                                                                                                    zhengshiyuangongdangqianzhuangtaiOptions: [],
                        zhengshiyuangongbumenOptions: [],
                        zhengshiyuangongzhiweiOptions: [],
                        zhengshiyuangongxingbieOptions: [],
                                                                                                                                                                                                zongguanliyuanbumenOptions: [],
                        zongguanliyuanzhiweiOptions: [],
                        zongguanliyuanxingbieOptions: [],
                                                                                                    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                                            this.linshiyuangongdangqianzhuangtaiOptions = "临时员工,正式员工".split(',')
                this.$http({
      url: `option/bumenxinxi/bumenming`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.linshiyuangongbumenmingchengOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                this.$http({
      url: `option/zhiweixinxi/zhiweiming`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.linshiyuangongzhiweiOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                this.linshiyuangongxingbieOptions = "男,女".split(',')
                                                                                        this.zhengshiyuangongdangqianzhuangtaiOptions = "临时员工,正式员工".split(',')
                this.$http({
      url: `option/bumenxinxi/bumenming`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.zhengshiyuangongbumenOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                this.$http({
      url: `option/zhiweixinxi/zhiweiming`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.zhengshiyuangongzhiweiOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                this.zhengshiyuangongxingbieOptions = "男,女".split(',')
                                                                                                                                this.$http({
      url: `option/bumenxinxi/bumenming`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.zongguanliyuanbumenOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                this.$http({
      url: `option/zhiweixinxi/zhiweiming`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.zongguanliyuanzhiweiOptions = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                this.zongguanliyuanxingbieOptions = "男,女".split(',')
                                                                  },
  methods: {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                linshiyuangongtupianUploadChange(fileUrls) {
        this.ruleForm.tupian = fileUrls;
    },
                                                                                                                zhengshiyuangongtupianUploadChange(fileUrls) {
        this.ruleForm.tupian = fileUrls;
    },
                                                                                                                                                zongguanliyuantupianUploadChange(fileUrls) {
        this.ruleForm.tupian = fileUrls;
    },
                                    onUpdateHandler() {
                              if((!this.ruleForm.gonghao)&& 'linshiyuangong'==this.flag){
        this.$message.error('工号不能为空');
        return
      }
                                                                  if((!this.ruleForm.mima)&& 'linshiyuangong'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                                                                                                                                                                                                                                                                                                      if( 'linshiyuangong' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
                                                                                          if( 'linshiyuangong' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
                                                            if( 'linshiyuangong' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
                                                                                                                        if((!this.ruleForm.gonghao)&& 'zhengshiyuangong'==this.flag){
        this.$message.error('工号不能为空');
        return
      }
                                                                  if((!this.ruleForm.mima)&& 'zhengshiyuangong'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                                                                                                                                                                                                                                                                                                      if( 'zhengshiyuangong' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
                                                                                          if( 'zhengshiyuangong' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
                                                            if( 'zhengshiyuangong' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
                                                                                                                                                                                    if((!this.ruleForm.gonghao)&& 'zongguanliyuan'==this.flag){
        this.$message.error('工号不能为空');
        return
      }
                                                                  if((!this.ruleForm.mima)&& 'zongguanliyuan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                                                                                                                                                                                                                                                                if( 'zongguanliyuan' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
                                                                                    if( 'zongguanliyuan' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
                                                                        if( 'zongguanliyuan' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
                                                                                                                        this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
