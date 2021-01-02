<template>
    <el-card class="form-container" shadow="never">
        <el-form :model="group_distribution"
                 :rules="rules"
                 ref="group_distributionFrom"
                 label-width="150px">
                    <el-form-item label="一级返利" >
                        <el-input v-model="group_distribution.levelOneBonus"></el-input>
                    </el-form-item>
                    <el-form-item label="二级返利" >
                        <el-input v-model="group_distribution.levelTwoBonus"></el-input>
                    </el-form-item>
                      <el-form-item label="分销">
                      <el-radio-group v-model="group_distribution.groupDistribution">
                        <el-radio :label="0">不开启</el-radio>
                        <el-radio :label="1">开启</el-radio>
                      </el-radio-group>
                      </el-form-item>
                    <el-form-item label="教师一级返利" >
                        <el-input v-model="group_distribution.teacherLoneBonus"></el-input>
                    </el-form-item>
                    <el-form-item label="教师二级返利" >
                        <el-input v-model="group_distribution.teacherLtwoBonus"></el-input>
                    </el-form-item>
                      <el-form-item label="上下级绑定时间">
                      <el-radio-group v-model="group_distribution.bindLevelTime">
                        <el-radio :label="0">初次进入</el-radio>
                        <el-radio :label="1">下单时</el-radio>
                        <el-radio :label="2">全民模式，不固定上级</el-radio>
                      </el-radio-group>
                      </el-form-item>
                    <el-form-item label="创建时间" >
                        <el-input v-model="group_distribution.createDate"></el-input>
                    </el-form-item>
                    <el-form-item label="修改时间" >
                        <el-input v-model="group_distribution.modifyDate"></el-input>
                    </el-form-item>
                      <el-form-item label="是否购买才可以分销">
                      <el-radio-group v-model="group_distribution.distributionAfterBuy">
                        <el-radio :label="0">不需要购买</el-radio>
                        <el-radio :label="1">需要购买</el-radio>
                      </el-radio-group>
                      </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('group_distributionFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('group_distributionFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/group_distribution';

    const defaultGroup_distribution = {
    groupDistribution:0,
    bindLevelTime:0,
    distributionAfterBuy:0,
    };
    export default {
        name: "Group_distributionDetail",
        components: {},
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            group_distribution: Object.assign({}, defaultGroup_distribution),
            rules: {
            }
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.group_distribution = response.data;
                });
            } else {
                this.group_distribution = Object.assign({}, defaultGroup_distribution);
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
                                update(this.$route.query.id, this.group_distribution).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.group_distribution).then(response => {
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
                this.group_distribution = Object.assign({}, defaultGroup_distribution);
            }
        }
    }
</script>

<style scoped>

</style>
