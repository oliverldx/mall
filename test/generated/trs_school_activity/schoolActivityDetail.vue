<template>
    <el-card class="form-container" shadow="never">
        <el-form :model="school_activity"
                 :rules="rules"
                 ref="school_activityFrom"
                 label-width="150px">
                    <el-form-item label="培训机构" >
                        <el-input v-model="school_activity.schoolId"></el-input>
                    </el-form-item>
                    <el-form-item label="活动" >
                        <el-input v-model="school_activity.trsActivityId"></el-input>
                    </el-form-item>
                      <el-form-item label="可选课程数量" >
                        <el-input v-model="school_activity.courseNum"></el-input>
                      </el-form-item>
                      <el-form-item label="排序" >
                        <el-input v-model="school_activity.sort"></el-input>
                      </el-form-item>
                    <el-form-item label="创建时间" >
                        <el-input v-model="school_activity.createDate"></el-input>
                    </el-form-item>
                    <el-form-item label="修改时间" >
                        <el-input v-model="school_activity.modifyDate"></el-input>
                    </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('school_activityFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('school_activityFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/school_activity';

    const defaultSchool_activity = {
    courseNum:0,
    sort:0,
    };
    export default {
        name: "School_activityDetail",
        components: {},
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            school_activity: Object.assign({}, defaultSchool_activity),
            rules: {
            }
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.school_activity = response.data;
                });
            } else {
                this.school_activity = Object.assign({}, defaultSchool_activity);
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
                                update(this.$route.query.id, this.school_activity).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.school_activity).then(response => {
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
                this.school_activity = Object.assign({}, defaultSchool_activity);
            }
        }
    }
</script>

<style scoped>

</style>
