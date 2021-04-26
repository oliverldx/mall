<template>
    <el-card shadow="never">
        <el-form :model="contract"
                 :rules="rules"
                 ref="contractFrom"
                 label-width="150px">
                <el-form-item label="用户购买协议">
                    <tinymce :width="595" :height="300" v-model="contract.description"></tinymce>
                </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="contract.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="contract.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('contractFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('contractFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/contract';

        import Tinymce from '@/components/Tinymce';

    const defaultContract = {
    id:'',
    description:'',

    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "ContractDetail",
        components: {
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
            contract: Object.assign({}, defaultContract),
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
                    this.contract = response.data;
                    if(this.contract == null) {
                        this.isReallyEdit = false;
                        this.contract = Object.assign({}, defaultContract);
                    }
                if(this.contract.createDate) {
                    this.contract.createDate = new Date(this.contract.createDate);
                }
                if(this.contract.modifyDate) {
                    this.contract.modifyDate = new Date(this.contract.modifyDate);
                }
                });
            } else {
                this.contract = Object.assign({}, defaultContract);
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
                                update(this.$route.query.id, this.contract).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.contract).then(response => {
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
                this.contract = Object.assign({}, defaultContract);
            },
        }
    }
</script>

<style scoped>

</style>
