<template>
    <el-card shadow="never">
        <el-form :model="customerService"
                 :rules="rules"
                 ref="customerServiceFrom"
                 label-width="150px">
                        <el-form-item label="客服名称" >
                          <el-input v-model="customerService.name"></el-input>
                        </el-form-item>
                        <el-form-item label="客服电话" >
                          <el-input v-model="customerService.phone"></el-input>
                        </el-form-item>
                <el-form-item label="客服二维码">
                    <single-upload v-model="customerService.pic"></single-upload>
                </el-form-item>
                <el-form-item label="帮助中心内容">
                    <tinymce :width="595" :height="300" v-model="customerService.description"></tinymce>
                </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="customerService.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="customerService.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('customerServiceFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('customerServiceFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById,getByActivityId} from '@/api/activity/customerService';
        import SingleUpload from '@/components/Upload/singleUpload';
        import Tinymce from '@/components/Tinymce';

    const defaultCustomerService = {
    id:'',
    trsActivityId:'',
    name:'',
    phone:'',
    pic:'',
    description:'',

    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "CustomerServiceDetail",
        components: {
        SingleUpload,
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
            customerService: Object.assign({}, defaultCustomerService),
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
                    this.customerService = response.data;
                    if(this.customerService == null) {
                        this.isReallyEdit = false;
                        this.customerService = Object.assign({}, defaultCustomerService);
                    }
                if(this.customerService.createDate) {
                    this.customerService.createDate = new Date(this.customerService.createDate);
                }
                if(this.customerService.modifyDate) {
                    this.customerService.modifyDate = new Date(this.customerService.modifyDate);
                }
                });
            } else {
                this.customerService = Object.assign({}, defaultCustomerService);
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
                                update(this.activityId, this.customerService).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                this.customerService.trsActivityId=this.activityId
                                create(this.customerService).then(response => {
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
                this.customerService = Object.assign({}, defaultCustomerService);
            }
        }
    }
</script>

<style scoped>

</style>
