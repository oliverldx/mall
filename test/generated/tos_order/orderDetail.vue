<template>
    <el-card shadow="never">
        <el-form :model="order"
                 :rules="rules"
                 ref="orderFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="order.id"></el-input>
                            </el-form-item>


                        <el-form-item label="订单号" >
                          <el-input v-model="order.orderNo"></el-input>
                        </el-form-item>
                <el-form-item label="订单状态">
                    <el-radio-group v-model="order.status">
                            <el-radio :label="0">未支付</el-radio>
                            <el-radio :label="1">已支付</el-radio>
                            <el-radio :label="2">已取消</el-radio>
                    </el-radio-group>
                </el-form-item>
                        <el-form-item label="下单时间" >
                            <el-date-picker
                                    v-model="order.orderTime"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="下单时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="支付时间" >
                            <el-date-picker
                                    v-model="order.payTime"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="支付时间">
                            </el-date-picker>
                        </el-form-item>
                    <el-form-item label="总金额" >
                        <el-input v-model="order.totalMoney"></el-input>
                    </el-form-item>
                    <el-form-item label="分销金额" >
                        <el-input v-model="order.distributionMoney"></el-input>
                    </el-form-item>
                        <el-form-item label="成团时间" >
                            <el-date-picker
                                    v-model="order.groupTime"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="成团时间">
                            </el-date-picker>
                        </el-form-item>
                      <el-form-item label="成团订单数量" >
                        <el-input v-model="order.groupOrderNo"></el-input>
                      </el-form-item>
                <el-form-item label="订单类型">
                    <el-radio-group v-model="order.type">
                            <el-radio :label="0">普通订单</el-radio>
                            <el-radio :label="1">开团订单</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="团类型">
                    <el-radio-group v-model="order.groupType">
                            <el-radio :label="0">待成团</el-radio>
                            <el-radio :label="1">已成团</el-radio>
                    </el-radio-group>
                </el-form-item>
                        <el-form-item label="注册时间" >
                            <el-date-picker
                                    v-model="order.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="注册时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="order.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('orderFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('orderFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/order';


    const defaultOrder = {
    id:'',
    tusUserId:'',
    trsActivityId:'',
    orderNo:'',
    status:0,
    orderTime:'',
    payTime:'',
    groupTime:'',
    groupOrderNo:0,
    type:0,
    groupType:0,
    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "OrderDetail",
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
            order: Object.assign({}, defaultOrder),
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
                    this.order = response.data;
                    if(this.order == null) {
                        this.isReallyEdit = false;
                        this.order = Object.assign({}, defaultOrder);
                    }
                if(this.order.orderTime) {
                    this.order.orderTime = new Date(this.order.orderTime);
                }
                if(this.order.payTime) {
                    this.order.payTime = new Date(this.order.payTime);
                }
                if(this.order.groupTime) {
                    this.order.groupTime = new Date(this.order.groupTime);
                }
                if(this.order.createDate) {
                    this.order.createDate = new Date(this.order.createDate);
                }
                if(this.order.modifyDate) {
                    this.order.modifyDate = new Date(this.order.modifyDate);
                }
                });
            } else {
                this.order = Object.assign({}, defaultOrder);
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
                                update(this.$route.query.id, this.order).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.order).then(response => {
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
                this.order = Object.assign({}, defaultOrder);
            },
        }
    }
</script>

<style scoped>

</style>
