<template>
    <el-card shadow="never">
        <el-form :model="orderCourse"
                 :rules="rules"
                 ref="orderCourseFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="orderCourse.id"></el-input>
                            </el-form-item>


                        <el-form-item label="分校" >
                          <el-input v-model="orderCourse.school"></el-input>
                        </el-form-item>
                        <el-form-item label="注册时间" >
                            <el-date-picker
                                    v-model="orderCourse.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="注册时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="orderCourse.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('orderCourseFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('orderCourseFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/orderCourse';


    const defaultOrderCourse = {
    id:'',
    tosOrderId:'',
    trsCourseId:'',
    school:'',
    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "OrderCourseDetail",
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
            orderCourse: Object.assign({}, defaultOrderCourse),
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
                    this.orderCourse = response.data;
                    if(this.orderCourse == null) {
                        this.isReallyEdit = false;
                        this.orderCourse = Object.assign({}, defaultOrderCourse);
                    }
                if(this.orderCourse.createDate) {
                    this.orderCourse.createDate = new Date(this.orderCourse.createDate);
                }
                if(this.orderCourse.modifyDate) {
                    this.orderCourse.modifyDate = new Date(this.orderCourse.modifyDate);
                }
                });
            } else {
                this.orderCourse = Object.assign({}, defaultOrderCourse);
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
                                update(this.$route.query.id, this.orderCourse).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.orderCourse).then(response => {
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
                this.orderCourse = Object.assign({}, defaultOrderCourse);
            },
        }
    }
</script>

<style scoped>

</style>
