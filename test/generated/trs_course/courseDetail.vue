<template>
    <el-card shadow="never">
        <el-form :model="course"
                 :rules="rules"
                 ref="courseFrom"
                 label-width="150px">
                        <el-form-item label="名称" >
                          <el-input v-model="course.name"></el-input>
                        </el-form-item>
                    <el-form-item label="原价" >
                        <el-input v-model="course.price"></el-input>
                    </el-form-item>
                    <el-form-item label="介绍">
                        <el-input type="textarea" :autosize="true" v-model="course.description"></el-input>
                    </el-form-item>
                        <el-form-item label="图片" >
                          <el-input v-model="course.pic"></el-input>
                        </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="course.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="course.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
                <el-form-item label="状态">
                    <el-radio-group v-model="course.status">
                            <el-radio :label="0">禁用</el-radio>
                            <el-radio :label="1">启用</el-radio>
                    </el-radio-group>
                </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('courseFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('courseFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/course';

    const defaultCourse = {
    id:'',
    trsSchoolId:'',
    name:'',
    description:'',

    pic:'',
    createDate:'',
    modifyDate:'',
    status:0,
    };
    export default {
        name: "CourseDetail",
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
            course: Object.assign({}, defaultCourse),
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
                    this.course = response.data;
                    if(this.course == null) {
                        this.isReallyEdit = false;
                        this.course = Object.assign({}, defaultCourse);
                    }
                });
            } else {
                this.course = Object.assign({}, defaultCourse);
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
                                update(this.$route.query.id, this.course).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.course).then(response => {
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
                this.course = Object.assign({}, defaultCourse);
            }
        }
    }
</script>

<style scoped>

</style>
