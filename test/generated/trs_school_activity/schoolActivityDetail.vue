<template>
    <el-card shadow="never">
        <el-form :model="schoolActivity"
                 :rules="rules"
                 ref="schoolActivityFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="schoolActivity.id"></el-input>
                            </el-form-item>


                      <el-form-item label="可选课程数量" >
                        <el-input v-model="schoolActivity.courseNum"></el-input>
                      </el-form-item>
                      <el-form-item label="排序" >
                        <el-input v-model="schoolActivity.sort"></el-input>
                      </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="schoolActivity.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="schoolActivity.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('schoolActivityFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('schoolActivityFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/schoolActivity';

    const defaultSchoolActivity = {
    id:'',
    trsSchoolId:'',
    trsActivityId:'',
    courseNum:0,
    sort:0,
    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "SchoolActivityDetail",
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
            schoolActivity: Object.assign({}, defaultSchoolActivity),
            rules: {
            },
            pickerOptions1: {
                disabledDate(time) {
                    return time.getTime() < Date.now();
                }
            },
                :[],
            isReallyEdit:this.isEdit
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.schoolActivity = response.data;
                if(this.schoolActivity.createDate) {
                    this.schoolActivity.createDate = new Date(this.schoolActivity.createDate);
                }
                if(this.schoolActivity.modifyDate) {
                    this.schoolActivity.modifyDate = new Date(this.schoolActivity.modifyDate);
                }
                    if(this.schoolActivity == null) {
                        this.isReallyEdit = false;
                        this.schoolActivity = Object.assign({}, defaultSchoolActivity);
                    }
                });
            } else {
                this.schoolActivity = Object.assign({}, defaultSchoolActivity);
            }
                this.()
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
                                update(this.$route.query.id, this.schoolActivity).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.schoolActivity).then(response => {
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
                this.schoolActivity = Object.assign({}, defaultSchoolActivity);
            },
        }
    }
</script>

<style scoped>

</style>
