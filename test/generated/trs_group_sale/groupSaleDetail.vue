<template>
    <el-card class="form-container" shadow="never">
        <el-form :model="group_sale"
                 :rules="rules"
                 ref="group_saleFrom"
                 label-width="150px">
                      <el-form-item label="库存" >
                        <el-input v-model="group_sale.groupNum"></el-input>
                      </el-form-item>
                      <el-form-item label="报名数" >
                        <el-input v-model="group_sale.groupHours"></el-input>
                      </el-form-item>
                      <el-form-item label="是否开启拼团">
                      <el-radio-group v-model="group_sale.groupSale">
                        <el-radio :label="0">不开启</el-radio>
                        <el-radio :label="1">开启</el-radio>
                      </el-radio-group>
                      </el-form-item>
                    <el-form-item label="拼团价格" >
                        <el-input v-model="group_sale.price"></el-input>
                    </el-form-item>
                    <el-form-item label="拼团分销奖金" >
                        <el-input v-model="group_sale.bonus"></el-input>
                    </el-form-item>
                    <el-form-item label="教师拼团分销奖金" >
                        <el-input v-model="group_sale.teacherBonus"></el-input>
                    </el-form-item>
                      <el-form-item label="成团及佣金">
                      <el-radio-group v-model="group_sale.groupCommission">
                        <el-radio :label="0">不自动成团，佣金成团后返</el-radio>
                        <el-radio :label="1">自动成团，佣金成团后返</el-radio>
                        <el-radio :label="2">自动成团，付款立即返佣金</el-radio>
                      </el-radio-group>
                      </el-form-item>
                    <el-form-item label="创建时间" >
                        <el-input v-model="group_sale.createDate"></el-input>
                    </el-form-item>
                    <el-form-item label="修改时间" >
                        <el-input v-model="group_sale.modifyDate"></el-input>
                    </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('group_saleFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('group_saleFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/group_sale';

    const defaultGroup_sale = {
    groupNum:0,
    groupHours:0,
    groupSale:0,
    groupCommission:0,
    };
    export default {
        name: "Group_saleDetail",
        components: {},
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            group_sale: Object.assign({}, defaultGroup_sale),
            rules: {
            }
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.group_sale = response.data;
                });
            } else {
                this.group_sale = Object.assign({}, defaultGroup_sale);
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
                                update(this.$route.query.id, this.group_sale).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.group_sale).then(response => {
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
                this.group_sale = Object.assign({}, defaultGroup_sale);
            }
        }
    }
</script>

<style scoped>

</style>
