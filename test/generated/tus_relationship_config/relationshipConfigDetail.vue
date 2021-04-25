<template>
    <el-card shadow="never">
        <el-form :model="relationshipConfig"
                 :rules="rules"
                 ref="relationshipConfigFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="relationshipConfig.id"></el-input>
                            </el-form-item>

                <el-form-item label="是否下单">
                    <el-radio-group v-model="relationshipConfig.takeOrder">
                            <el-radio :label="0">未下订单</el-radio>
                            <el-radio :label="1">已下单</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="等级">
                    <el-radio-group v-model="relationshipConfig.level">
                            <el-radio :label="0">普通</el-radio>
                            <el-radio :label="1">教师</el-radio>
                    </el-radio-group>
                </el-form-item>
                        <el-form-item label="注册时间" >
                            <el-date-picker
                                    v-model="relationshipConfig.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="注册时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="relationshipConfig.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('relationshipConfigFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('relationshipConfigFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/relationshipConfig';


    const defaultRelationshipConfig = {
    id:'',
    tusUserId:'',
    levelOne:'',
    levelTwo:'',
    takeOrder:0,
    level:0,
    team:'',
    school:'',
    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "RelationshipConfigDetail",
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
            relationshipConfig: Object.assign({}, defaultRelationshipConfig),
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
                    this.relationshipConfig = response.data;
                    if(this.relationshipConfig == null) {
                        this.isReallyEdit = false;
                        this.relationshipConfig = Object.assign({}, defaultRelationshipConfig);
                    }
                if(this.relationshipConfig.createDate) {
                    this.relationshipConfig.createDate = new Date(this.relationshipConfig.createDate);
                }
                if(this.relationshipConfig.modifyDate) {
                    this.relationshipConfig.modifyDate = new Date(this.relationshipConfig.modifyDate);
                }
                });
            } else {
                this.relationshipConfig = Object.assign({}, defaultRelationshipConfig);
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
                                update(this.$route.query.id, this.relationshipConfig).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.relationshipConfig).then(response => {
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
                this.relationshipConfig = Object.assign({}, defaultRelationshipConfig);
            },
        }
    }
</script>

<style scoped>

</style>
