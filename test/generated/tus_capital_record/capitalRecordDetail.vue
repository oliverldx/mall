<template>
    <el-card shadow="never">
        <el-form :model="capitalRecord"
                 :rules="rules"
                 ref="capitalRecordFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="capitalRecord.id"></el-input>
                            </el-form-item>

                    <el-form-item label="金额" >
                        <el-input v-model="capitalRecord.money"></el-input>
                    </el-form-item>
                    <el-form-item label="备注">
                        <el-input type="textarea" :autosize="true" v-model="capitalRecord.description"></el-input>
                    </el-form-item>
                        <el-form-item label="注册时间" >
                            <el-date-picker
                                    v-model="capitalRecord.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="注册时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="capitalRecord.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('capitalRecordFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('capitalRecordFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/capitalRecord';


    const defaultCapitalRecord = {
    id:'',
    tusUserId:'',
    description:'',

    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "CapitalRecordDetail",
        components: {
        },
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            capitalRecord: Object.assign({}, defaultCapitalRecord),
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
                    this.capitalRecord = response.data;
                    if(this.capitalRecord == null) {
                        this.isReallyEdit = false;
                        this.capitalRecord = Object.assign({}, defaultCapitalRecord);
                    }
                if(this.capitalRecord.createDate) {
                    this.capitalRecord.createDate = new Date(this.capitalRecord.createDate);
                }
                if(this.capitalRecord.modifyDate) {
                    this.capitalRecord.modifyDate = new Date(this.capitalRecord.modifyDate);
                }
                });
            } else {
                this.capitalRecord = Object.assign({}, defaultCapitalRecord);
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
                                update(this.$route.query.id, this.capitalRecord).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.capitalRecord).then(response => {
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
                this.capitalRecord = Object.assign({}, defaultCapitalRecord);
            },
        }
    }
</script>

<style scoped>

</style>
