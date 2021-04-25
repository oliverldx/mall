<template>
    <el-card shadow="never">
        <el-form :model="user"
                 :rules="rules"
                 ref="userFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="user.id"></el-input>
                            </el-form-item>
                        <el-form-item label="用户ID" >
                          <el-input v-model="user.userId"></el-input>
                        </el-form-item>
                    <el-form-item label="头像">
                        <el-input type="textarea" :autosize="true" v-model="user.pic"></el-input>
                    </el-form-item>
                        <el-form-item label="昵称" >
                          <el-input v-model="user.nickName"></el-input>
                        </el-form-item>
                <el-form-item label="等级">
                    <el-radio-group v-model="user.level">
                            <el-radio :label="0">普通</el-radio>
                            <el-radio :label="1">教师</el-radio>
                    </el-radio-group>
                </el-form-item>
                    <el-form-item label="余额" >
                        <el-input v-model="user.balance"></el-input>
                    </el-form-item>
                <el-form-item label="性别">
                    <el-radio-group v-model="user.sex">
                            <el-radio :label="0">男</el-radio>
                            <el-radio :label="1">女</el-radio>
                            <el-radio :label="2">保密</el-radio>
                    </el-radio-group>
                </el-form-item>
                        <el-form-item label="姓名" >
                          <el-input v-model="user.name"></el-input>
                        </el-form-item>
                        <el-form-item label="手机号" >
                          <el-input v-model="user.mobile"></el-input>
                        </el-form-item>
                <el-form-item label="是否下单">
                    <el-radio-group v-model="user.takeOrder">
                            <el-radio :label="0">未下单</el-radio>
                            <el-radio :label="1">已下单</el-radio>
                    </el-radio-group>
                </el-form-item>
                      <el-form-item label="邀请人数" >
                        <el-input v-model="user.invitePeopleCount"></el-input>
                      </el-form-item>
                        <el-form-item label="注册时间" >
                            <el-date-picker
                                    v-model="user.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="注册时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="user.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="省" >
                          <el-input v-model="user.province"></el-input>
                        </el-form-item>
                        <el-form-item label="市" >
                          <el-input v-model="user.city"></el-input>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('userFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('userFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/user';


    const defaultUser = {
    id:'',
    userId:'',
    pic:'',

    nickName:'',
    level:0,
    sex:0,
    name:'',
    mobile:'',
    takeOrder:0,
    invitePeopleCount:0,
    createDate:'',
    modifyDate:'',
    parentLevelOne:'',
    parentLevelTwo:'',
    province:'',
    city:'',
    };
    export default {
        name: "UserDetail",
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
            user: Object.assign({}, defaultUser),
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
                    this.user = response.data;
                    if(this.user == null) {
                        this.isReallyEdit = false;
                        this.user = Object.assign({}, defaultUser);
                    }
                if(this.user.createDate) {
                    this.user.createDate = new Date(this.user.createDate);
                }
                if(this.user.modifyDate) {
                    this.user.modifyDate = new Date(this.user.modifyDate);
                }
                });
            } else {
                this.user = Object.assign({}, defaultUser);
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
                                update(this.$route.query.id, this.user).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.user).then(response => {
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
                this.user = Object.assign({}, defaultUser);
            },
        }
    }
</script>

<style scoped>

</style>
