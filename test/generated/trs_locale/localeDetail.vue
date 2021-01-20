<template>
    <el-card shadow="never">
        <el-form :model="locale"
                 :rules="rules"
                 ref="localeFrom"
                 label-width="150px">
                        <el-form-item label="活动名称" >
                          <el-input v-model="locale.name"></el-input>
                        </el-form-item>
                        <el-form-item label="3D图形文字" >
                          <el-input v-model="locale.text3d"></el-input>
                        </el-form-item>
                    <el-form-item label="活动连接">
                        <el-input type="textarea" :autosize="true" v-model="locale.link"></el-input>
                    </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="locale.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="locale.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
                <el-form-item label="是否开启">
                    <el-radio-group v-model="locale.enable">
                            <el-radio :label="0">关闭</el-radio>
                            <el-radio :label="1">开启</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="开启二维码自动注册老师">
                    <el-radio-group v-model="locale.autoRegTeacher">
                            <el-radio :label="0">关闭</el-radio>
                            <el-radio :label="1">开启</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="开启家长组二维码">
                    <el-radio-group v-model="locale.qrcodeParents">
                            <el-radio :label="0">关闭</el-radio>
                            <el-radio :label="1">开启</el-radio>
                    </el-radio-group>
                </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('localeFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('localeFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/locale';

    const defaultLocale = {
    id:'',
    trsActivityId:'',
    name:'',
    text3d:'',
    link:'',

    createDate:'',
    modifyDate:'',
    enable:0,
    autoRegTeacher:0,
    qrcodeParents:0,
    };
    export default {
        name: "LocaleDetail",
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
            locale: Object.assign({}, defaultLocale),
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
                    this.locale = response.data;
                    if(this.locale == null) {
                        this.isReallyEdit = false;
                        this.locale = Object.assign({}, defaultLocale);
                    }
                });
            } else {
                this.locale = Object.assign({}, defaultLocale);
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
                                update(this.$route.query.id, this.locale).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.locale).then(response => {
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
                this.locale = Object.assign({}, defaultLocale);
            }
        }
    }
</script>

<style scoped>

</style>
