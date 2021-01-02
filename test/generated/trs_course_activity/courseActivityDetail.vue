<template>
    <el-card class="form-container" shadow="never">
        <el-form :model="course_activity"
                 :rules="rules"
                 ref="course_activityFrom"
                 label-width="150px">
                    <el-form-item label="课程" >
                        <el-input v-model="course_activity.trsCourseId"></el-input>
                    </el-form-item>
                    <el-form-item label="活动" >
                        <el-input v-model="course_activity.trsActivityId"></el-input>
                    </el-form-item>
                      <el-form-item label="库存" >
                        <el-input v-model="course_activity.courseNum"></el-input>
                      </el-form-item>
                      <el-form-item label="报名数" >
                        <el-input v-model="course_activity.applyNum"></el-input>
                      </el-form-item>
                      <el-form-item label="排序" >
                        <el-input v-model="course_activity.sort"></el-input>
                      </el-form-item>
                    <el-form-item label="创建时间" >
                        <el-input v-model="course_activity.createDate"></el-input>
                    </el-form-item>
                    <el-form-item label="修改时间" >
                        <el-input v-model="course_activity.modifyDate"></el-input>
                    </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('course_activityFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('course_activityFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/course_activity';

    const defaultCourse_activity = {
    courseNum:0,
    applyNum:0,
    sort:0,
    };
    export default {
        name: "Course_activityDetail",
        components: {},
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            course_activity: Object.assign({}, defaultCourse_activity),
            rules: {
            }
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.course_activity = response.data;
                });
            } else {
                this.course_activity = Object.assign({}, defaultCourse_activity);
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
                                update(this.$route.query.id, this.course_activity).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.course_activity).then(response => {
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
                this.course_activity = Object.assign({}, defaultCourse_activity);
            }
        }
    }
</script>

<style scoped>

</style>
