<template>
    <el-card shadow="never">
        <el-form :model="orderGift"
                 :rules="rules"
                 ref="orderGiftFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="orderGift.id"></el-input>
                            </el-form-item>


                <el-form-item label="状态">
                    <el-radio-group v-model="orderGift.status">
                            <el-radio :label="0">未使用</el-radio>
                            <el-radio :label="1">已使用</el-radio>
                    </el-radio-group>
                </el-form-item>
                        <el-form-item label="注册时间" >
                            <el-date-picker
                                    v-model="orderGift.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="注册时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="orderGift.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('orderGiftFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('orderGiftFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/orderGift';


    const defaultOrderGift = {
    id:'',
    tosOrderId:'',
    trsGiftId:'',
    status:0,
    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "OrderGiftDetail",
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
            orderGift: Object.assign({}, defaultOrderGift),
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
                    this.orderGift = response.data;
                    if(this.orderGift == null) {
                        this.isReallyEdit = false;
                        this.orderGift = Object.assign({}, defaultOrderGift);
                    }
                if(this.orderGift.createDate) {
                    this.orderGift.createDate = new Date(this.orderGift.createDate);
                }
                if(this.orderGift.modifyDate) {
                    this.orderGift.modifyDate = new Date(this.orderGift.modifyDate);
                }
                });
            } else {
                this.orderGift = Object.assign({}, defaultOrderGift);
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
                                update(this.$route.query.id, this.orderGift).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.orderGift).then(response => {
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
                this.orderGift = Object.assign({}, defaultOrderGift);
            },
        }
    }
</script>

<style scoped>

</style>
