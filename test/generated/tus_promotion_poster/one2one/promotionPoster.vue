<template>
    <el-card shadow="never">
        <el-form :model="promotionPoster"
                 :rules="rules"
                 ref="promotionPosterFrom"
                 label-width="150px">
                            <el-form-item label="ID" >
                                <el-input v-model="promotionPoster.id"></el-input>
                            </el-form-item>
                    <el-form-item label="海报">
                        <el-input type="textarea" :autosize="true" v-model="promotionPoster.poster"></el-input>
                    </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="promotionPoster.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="promotionPoster.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('promotionPosterFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('promotionPosterFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById,getByUserId} from '@/api/user/promotionPoster';

    const defaultPromotionPoster = {
    id:'',
    tusUserId:'',
    poster:'',

    createDate:'',
    modifyDate:'',
    };
    export default {
        name: "PromotionPosterDetail",
        components: {
        },
        props: {
            isEdit: {
                type: Boolean,
                default: false
            },
            userId: {
                type: [String, Number]
            }
        },
        data() {
            return {
            promotionPoster: Object.assign({}, defaultPromotionPoster),
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
                getByUserId(this.userId).then(response => {
                    this.promotionPoster = response.data;
                    if(this.promotionPoster == null) {
                        this.isReallyEdit = false;
                        this.promotionPoster = Object.assign({}, defaultPromotionPoster);
                    }
                });
            } else {
                this.promotionPoster = Object.assign({}, defaultPromotionPoster);
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
                            if (this.isEdit && this.isReallyEdit) {
                                update(this.userId, this.promotionPoster).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                this.promotionPoster.tusUserId=this.userId
                                create(this.promotionPoster).then(response => {
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
                this.promotionPoster = Object.assign({}, defaultPromotionPoster);
            }
        }
    }
</script>

<style scoped>

</style>
