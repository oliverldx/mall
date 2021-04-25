<template>
    <el-card shadow="never">
        <el-form :model="pages"
                 :rules="rules"
                 ref="pagesFrom"
                 label-width="150px">
                        <el-form-item label="分享页商品标题" >
                          <el-input v-model="pages.name"></el-input>
                        </el-form-item>
                        <el-form-item label="分享标题" >
                          <el-input v-model="pages.subName"></el-input>
                        </el-form-item>
                      <el-form-item label="排序" >
                        <el-input v-model="pages.sort"></el-input>
                      </el-form-item>
                <el-form-item label="分享页顶部轮播图片">
                    <multi-upload v-model="pages.swipePic"></multi-upload>
                </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="pages.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="pages.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
                      <el-form-item label="首页学校显示数量" >
                        <el-input v-model="pages.showSchNum"></el-input>
                      </el-form-item>
                    <el-form-item label="主页面顶部图片">
                        <el-input type="textarea" :autosize="true" v-model="pages.topPic"></el-input>
                    </el-form-item>
                    <el-form-item label="分享图片">
                        <el-input type="textarea" :autosize="true" v-model="pages.sharePic"></el-input>
                    </el-form-item>
                <el-form-item label="分享描述">
                    <tinymce :width="595" :height="300" v-model="pages.description"></tinymce>
                </el-form-item>
                      <el-form-item label="首页课程显示数量" >
                        <el-input v-model="pages.showCrsNum"></el-input>
                      </el-form-item>
                    <el-form-item label="背景颜色">
                        <el-input type="textarea" :autosize="true" v-model="pages.backgroundColor"></el-input>
                    </el-form-item>
                <el-form-item label="收入排行榜">
                    <el-radio-group v-model="pages.incomeRanking">
                            <el-radio :label="0">不显示</el-radio>
                            <el-radio :label="1">显示</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="是否显示报名数">
                    <el-radio-group v-model="pages.showBooking">
                            <el-radio :label="0">不显示</el-radio>
                            <el-radio :label="1">显示</el-radio>
                    </el-radio-group>
                </el-form-item>
                    <el-form-item label="音频文件">
                        <el-input type="textarea" :autosize="true" v-model="pages.audio"></el-input>
                    </el-form-item>
                    <el-form-item label="分享海报底部文字">
                        <el-input type="textarea" :autosize="true" v-model="pages.buttomText"></el-input>
                    </el-form-item>
                <el-form-item label="分享页显示我的收入">
                    <el-radio-group v-model="pages.showMyIncome">
                            <el-radio :label="0">不显示</el-radio>
                            <el-radio :label="1">显示</el-radio>
                    </el-radio-group>
                </el-form-item>
                      <el-form-item label="倒计时天数" >
                        <el-input v-model="pages.dayLimit"></el-input>
                      </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('pagesFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('pagesFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById,getByActivityId} from '@/api/activity/pages';
        import MultiUpload from '@/components/Upload/multiUpload';
        import Tinymce from '@/components/Tinymce';

    const defaultPages = {
    id:'',
    trsActivityId:'',
    name:'',
    subName:'',
    sort:0,
    swipePic:[],

    createDate:'',
    modifyDate:'',
    showSchNum:0,
    topPic:'',

    sharePic:'',

    description:'',

    showCrsNum:0,
    backgroundColor:'',

    incomeRanking:0,
    showBooking:0,
    audio:'',

    buttomText:'',

    showMyIncome:0,
    dayLimit:0,
    };
    export default {
        name: "PagesDetail",
        components: {
        MultiUpload,
        Tinymce,
        },
        props: {
            isEdit: {
                type: Boolean,
                default: false
            },
            activityId: {
                type: [String, Number]
            }
        },
        data() {
            return {
            pages: Object.assign({}, defaultPages),
            rules: {
            },
            pickerOptions1: {
                disabledDate(time) {
                    return time.getTime() < Date.now();
                }
            },
            isReallyEdit:this.isEdit
        }
        },
        created() {
            if (this.isEdit) {
                getByActivityId(this.activityId).then(response => {
                    this.pages = response.data;
                    if(this.pages.swipePic===undefined||this.pages.swipePic==null||this.pages.swipePic===''){
                        this.pages.swipePic=[]
                    }else {
                        this.pages.swipePic = this.pages.swipePic.split(',');
                    }
                if(this.pages.createDate) {
                    this.pages.createDate = new Date(this.pages.createDate);
                }
                if(this.pages.modifyDate) {
                    this.pages.modifyDate = new Date(this.pages.modifyDate);
                }
                    if(this.pages == null) {
                        this.isReallyEdit = false;
                        this.pages = Object.assign({}, defaultPages);
                    }
                });
            } else {
                this.pages = Object.assign({}, defaultPages);
            }
        },
        methods: {
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$confirm('是否提交数据', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            if (this.isEdit && this.isReallyEdit) {
                    if(this.pages.swipePic && this.pages.swipePic.length > 0){
                        this.pages.swipePic=this.pages.swipePic.toString()
                    }
                                update(this.activityId, this.pages).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                    if(this.pages.swipePic && this.pages.swipePic.length > 0){
                        this.pages.swipePic=this.pages.swipePic.toString()
                    }
                                this.pages.trsActivityId=this.activityId
                                create(this.pages).then(response => {
                                    this.$refs[formName].resetFields();
                                    this.resetForm(formName);
                                    this.$message({
                                        message: '提交成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                });
                            }
                        });

                    } else {
                        this.$message({
                            message: '验证失败',
                            type: 'error',
                            duration: 1000
                        });
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
                this.pages = Object.assign({}, defaultPages);
            }
        }
    }
</script>

<style scoped>

</style>
