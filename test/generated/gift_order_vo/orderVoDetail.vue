<template>
    <el-card shadow="never">
        <el-form :model="orderVo"
                 :rules="rules"
                 ref="orderVoFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="orderVo.id"></el-input>
                            </el-form-item>
                        <el-form-item label="姓名" >
                          <el-input v-model="orderVo.name"></el-input>
                        </el-form-item>
                        <el-form-item label="手机号" >
                          <el-input v-model="orderVo.mobile"></el-input>
                        </el-form-item>
                    <el-form-item label="商品图片">
                        <el-input type="textarea" :autosize="true" v-model="orderVo.pic"></el-input>
                    </el-form-item>
                        <el-form-item label="名称" >
                          <el-input v-model="orderVo.giftName"></el-input>
                        </el-form-item>
                        <el-form-item label="赞助商名称" >
                          <el-input v-model="orderVo.sponsorName"></el-input>
                        </el-form-item>
                        <el-form-item label="有效期" >
                            <el-date-picker
                                    v-model="orderVo.validateTime"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="有效期">
                            </el-date-picker>
                        </el-form-item>
                <el-form-item label="状态">
                    <el-radio-group v-model="orderVo.status">
                            <el-radio :label="0">禁用</el-radio>
                            <el-radio :label="1">启用</el-radio>
                    </el-radio-group>
                </el-form-item>
                        <el-form-item label="下单时间" >
                            <el-date-picker
                                    v-model="orderVo.orderTime"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="下单时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('orderVoFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('orderVoFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/orderVo';


    const defaultOrderVo = {
    id:'',
    name:'',
    mobile:'',
    pic:'',

    giftName:'',
    sponsorName:'',
    validateTime:'',
    status:0,
    orderTime:'',
    };
    export default {
        name: "OrderVoDetail",
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
            orderVo: Object.assign({}, defaultOrderVo),
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
                    this.orderVo = response.data;
                    if(this.orderVo == null) {
                        this.isReallyEdit = false;
                        this.orderVo = Object.assign({}, defaultOrderVo);
                    }
                if(this.orderVo.validateTime) {
                    this.orderVo.validateTime = new Date(this.orderVo.validateTime);
                }
                if(this.orderVo.orderTime) {
                    this.orderVo.orderTime = new Date(this.orderVo.orderTime);
                }
                });
            } else {
                this.orderVo = Object.assign({}, defaultOrderVo);
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
                                update(this.$route.query.id, this.orderVo).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.orderVo).then(response => {
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
                this.orderVo = Object.assign({}, defaultOrderVo);
            },
        }
    }
</script>

<style scoped>

</style>
