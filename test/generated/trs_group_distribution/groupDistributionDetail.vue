<template>
    <el-card shadow="never">
        <el-form :model="groupDistribution"
                 :rules="rules"
                 ref="groupDistributionFrom"
                 label-width="150px">
                    <el-form-item label="一级返利" >
                        <el-input v-model="groupDistribution.levelOneBonus"></el-input>
                    </el-form-item>
                    <el-form-item label="二级返利" >
                        <el-input v-model="groupDistribution.levelTwoBonus"></el-input>
                    </el-form-item>
                <el-form-item label="分销">
                    <el-radio-group v-model="groupDistribution.groupDistribution">
                            <el-radio :label="0">不开启</el-radio>
                            <el-radio :label="1">开启</el-radio>
                    </el-radio-group>
                </el-form-item>
                    <el-form-item label="教师一级返利" >
                        <el-input v-model="groupDistribution.teacherLoneBonus"></el-input>
                    </el-form-item>
                    <el-form-item label="教师二级返利" >
                        <el-input v-model="groupDistribution.teacherLtwoBonus"></el-input>
                    </el-form-item>
                <el-form-item label="上下级绑定时间">
                    <el-radio-group v-model="groupDistribution.bindLevelTime">
                            <el-radio :label="0">初次进入</el-radio>
                            <el-radio :label="1">下单时</el-radio>
                            <el-radio :label="2">全民模式，不固定上级</el-radio>
                    </el-radio-group>
                </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="groupDistribution.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="groupDistribution.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
                <el-form-item label="是否购买才可以分销">
                    <el-radio-group v-model="groupDistribution.distributionAfterBuy">
                            <el-radio :label="0">不需要购买</el-radio>
                            <el-radio :label="1">需要购买</el-radio>
                    </el-radio-group>
                </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('groupDistributionFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('groupDistributionFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/groupDistribution';


    const defaultGroupDistribution = {
    id:'',
    trsActivityId:'',
    groupDistribution:0,
    bindLevelTime:0,
    createDate:'',
    modifyDate:'',
    distributionAfterBuy:0,
    };
    export default {
        name: "GroupDistributionDetail",
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
            groupDistribution: Object.assign({}, defaultGroupDistribution),
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
                    this.groupDistribution = response.data;
                    if(this.groupDistribution == null) {
                        this.isReallyEdit = false;
                        this.groupDistribution = Object.assign({}, defaultGroupDistribution);
                    }
                if(this.groupDistribution.createDate) {
                    this.groupDistribution.createDate = new Date(this.groupDistribution.createDate);
                }
                if(this.groupDistribution.modifyDate) {
                    this.groupDistribution.modifyDate = new Date(this.groupDistribution.modifyDate);
                }
                });
            } else {
                this.groupDistribution = Object.assign({}, defaultGroupDistribution);
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
                                update(this.$route.query.id, this.groupDistribution).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.groupDistribution).then(response => {
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
                this.groupDistribution = Object.assign({}, defaultGroupDistribution);
            },
        }
    }
</script>

<style scoped>

</style>
