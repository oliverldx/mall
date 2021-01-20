<template>
    <el-card shadow="never">
        <el-form :model="school"
                 :rules="rules"
                 ref="schoolFrom"
                 label-width="150px">
                        <el-form-item label="机构名称" >
                          <el-input v-model="school.name"></el-input>
                        </el-form-item>
                        <el-form-item label="联系人" >
                          <el-input v-model="school.contactName"></el-input>
                        </el-form-item>
                        <el-form-item label="联系方式" >
                          <el-input v-model="school.contactNo"></el-input>
                        </el-form-item>
                        <el-form-item label="机构logo" >
                          <el-input v-model="school.logo"></el-input>
                        </el-form-item>
                    <el-form-item label="分校名称">
                        <el-input type="textarea" :autosize="true" v-model="school.subSchool"></el-input>
                    </el-form-item>
                        <el-form-item label="机构视频" >
                          <el-input v-model="school.video"></el-input>
                        </el-form-item>
                    <el-form-item label="介绍">
                        <el-input type="textarea" :autosize="true" v-model="school.description"></el-input>
                    </el-form-item>
                        <el-form-item label="地图标注" >
                          <el-input v-model="school.latlongitude"></el-input>
                        </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="school.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="school.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
                <el-form-item label="状态">
                    <el-radio-group v-model="school.status">
                            <el-radio :label="0">禁用</el-radio>
                            <el-radio :label="1">启用</el-radio>
                    </el-radio-group>
                </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('schoolFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('schoolFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/school';

    const defaultSchool = {
    id:'',
    name:'',
    contactName:'',
    contactNo:'',
    logo:'',
    subSchool:'',

    video:'',
    description:'',

    latlongitude:'',
    createDate:'',
    modifyDate:'',
    status:0,
    };
    export default {
        name: "SchoolDetail",
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
            school: Object.assign({}, defaultSchool),
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
                    this.school = response.data;
                    if(this.school == null) {
                        this.isReallyEdit = false;
                        this.school = Object.assign({}, defaultSchool);
                    }
                });
            } else {
                this.school = Object.assign({}, defaultSchool);
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
                                update(this.$route.query.id, this.school).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.school).then(response => {
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
                this.school = Object.assign({}, defaultSchool);
            }
        }
    }
</script>

<style scoped>

</style>
