<template>
    <el-card shadow="never">
        <el-form :model="courseActivity"
                 :rules="rules"
                 ref="courseActivityFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="courseActivity.id"></el-input>
                            </el-form-item>


                      <el-form-item label="库存" >
                        <el-input v-model="courseActivity.courseNum"></el-input>
                      </el-form-item>
                      <el-form-item label="报名数" >
                        <el-input v-model="courseActivity.applyNum"></el-input>
                      </el-form-item>
                      <el-form-item label="排序" >
                        <el-input v-model="courseActivity.sort"></el-input>
                      </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="courseActivity.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="courseActivity.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('courseActivityFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('courseActivityFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/courseActivity';


    const defaultCourseActivity = {
    id:'',
    trsCourseId:'',
    trsActivityId:'',
    courseNum:0,
    applyNum:0,
    sort:0,
    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "CourseActivityDetail",
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
            courseActivity: Object.assign({}, defaultCourseActivity),
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
                    this.courseActivity = response.data;
                    if(this.courseActivity == null) {
                        this.isReallyEdit = false;
                        this.courseActivity = Object.assign({}, defaultCourseActivity);
                    }
                if(this.courseActivity.createDate) {
                    this.courseActivity.createDate = new Date(this.courseActivity.createDate);
                }
                if(this.courseActivity.modifyDate) {
                    this.courseActivity.modifyDate = new Date(this.courseActivity.modifyDate);
                }
                });
            } else {
                this.courseActivity = Object.assign({}, defaultCourseActivity);
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
                                update(this.$route.query.id, this.courseActivity).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.courseActivity).then(response => {
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
                this.courseActivity = Object.assign({}, defaultCourseActivity);
            },
        }
    }
</script>

<style scoped>

</style>
