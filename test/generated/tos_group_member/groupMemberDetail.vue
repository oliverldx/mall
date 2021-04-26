<template>
    <el-card shadow="never">
        <el-form :model="groupMember"
                 :rules="rules"
                 ref="groupMemberFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="groupMember.id"></el-input>
                            </el-form-item>


            <el-form-item>
                <el-button type="primary" @click="onSubmit('groupMemberFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('groupMemberFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/groupMember';


    const defaultGroupMember = {
    id:'',
    tosOrderId:'',
    tusUserId:'',
    };
    export default {
        name: "GroupMemberDetail",
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
            groupMember: Object.assign({}, defaultGroupMember),
            rules: {
            },
            isReallyEdit:this.isEdit
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.groupMember = response.data;
                    if(this.groupMember == null) {
                        this.isReallyEdit = false;
                        this.groupMember = Object.assign({}, defaultGroupMember);
                    }
                });
            } else {
                this.groupMember = Object.assign({}, defaultGroupMember);
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
                                update(this.$route.query.id, this.groupMember).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.groupMember).then(response => {
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
                this.groupMember = Object.assign({}, defaultGroupMember);
            },
        }
    }
</script>

<style scoped>

</style>
