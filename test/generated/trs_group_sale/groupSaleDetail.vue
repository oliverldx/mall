<template>
    <el-card shadow="never">
        <el-form :model="groupSale"
                 :rules="rules"
                 ref="groupSaleFrom"
                 label-width="150px">
                      <el-form-item label="库存" >
                        <el-input v-model="groupSale.groupNum"></el-input>
                      </el-form-item>
                      <el-form-item label="报名数" >
                        <el-input v-model="groupSale.groupHours"></el-input>
                      </el-form-item>
                <el-form-item label="是否开启拼团">
                    <el-radio-group v-model="groupSale.groupSale">
                            <el-radio :label="0">不开启</el-radio>
                            <el-radio :label="1">开启</el-radio>
                    </el-radio-group>
                </el-form-item>
                    <el-form-item label="拼团价格" >
                        <el-input v-model="groupSale.price"></el-input>
                    </el-form-item>
                    <el-form-item label="拼团分销奖金" >
                        <el-input v-model="groupSale.bonus"></el-input>
                    </el-form-item>
                    <el-form-item label="教师拼团分销奖金" >
                        <el-input v-model="groupSale.teacherBonus"></el-input>
                    </el-form-item>
                <el-form-item label="成团及佣金">
                    <el-radio-group v-model="groupSale.groupCommission">
                            <el-radio :label="0">不自动成团，佣金成团后返</el-radio>
                            <el-radio :label="1">自动成团，佣金成团后返</el-radio>
                            <el-radio :label="2">自动成团，付款立即返佣金</el-radio>
                    </el-radio-group>
                </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="groupSale.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="groupSale.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('groupSaleFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('groupSaleFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/groupSale';

    const defaultGroupSale = {
    id:'',
    trsActivityId:'',
    groupNum:0,
    groupHours:0,
    groupSale:0,
    groupCommission:0,
    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "GroupSaleDetail",
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
            groupSale: Object.assign({}, defaultGroupSale),
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
                    this.groupSale = response.data;
                    if(this.groupSale == null) {
                        this.isReallyEdit = false;
                        this.groupSale = Object.assign({}, defaultGroupSale);
                    }
                });
            } else {
                this.groupSale = Object.assign({}, defaultGroupSale);
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
                                update(this.$route.query.id, this.groupSale).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.groupSale).then(response => {
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
                this.groupSale = Object.assign({}, defaultGroupSale);
            }
        }
    }
</script>

<style scoped>

</style>
