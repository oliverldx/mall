<template>
    <el-card shadow="never">
        <el-form :model="service"
                 :rules="rules"
                 ref="serviceFrom"
                 label-width="150px">
                        <el-form-item label="活动名称" >
                          <el-input v-model="service.name"></el-input>
                        </el-form-item>
                        <el-form-item label="客服电话" >
                          <el-input v-model="service.phone"></el-input>
                        </el-form-item>
                <el-form-item label="客服二维码">
                    <single-upload v-model="service.pic"></single-upload>
                </el-form-item>
                <el-form-item label="帮助中心内容">
                    <tinymce :width="595" :height="300" v-model="service.description"></tinymce>
                </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="service.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="service.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('serviceFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('serviceFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/service';

        import SingleUpload from '@/components/Upload/singleUpload';
        import Tinymce from '@/components/Tinymce';

    const defaultService = {
    id:'',
    name:'',
    phone:'',
    pic:[],

    description:'',

    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "ServiceDetail",
        components: {
        SingleUpload,
        Tinymce,
        },
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            service: Object.assign({}, defaultService),
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
                getById(this.$route.query.id).then(response => {
                    this.service = response.data;
                    if(this.service == null) {
                        this.isReallyEdit = false;
                        this.service = Object.assign({}, defaultService);
                    }
                    if(this.service.pic===undefined||this.service.pic==null||this.service.pic===''){
                        this.service.pic=[]
                    }else {
                        this.service.pic = this.service.pic.split(',');
                    }
                if(this.service.createDate) {
                    this.service.createDate = new Date(this.service.createDate);
                }
                if(this.service.modifyDate) {
                    this.service.modifyDate = new Date(this.service.modifyDate);
                }
                });
            } else {
                this.service = Object.assign({}, defaultService);
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
                            if (this.isEdit) {
                    if(this.service.pic && this.service.pic.length > 0){
                        this.service.pic=this.service.pic.toString()
                    }
                                update(this.$route.query.id, this.service).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                    if(this.service.pic && this.service.pic.length > 0){
                        this.service.pic=this.service.pic.toString()
                    }
                                create(this.service).then(response => {
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
                this.service = Object.assign({}, defaultService);
            },
        }
    }
</script>

<style scoped>

</style>
