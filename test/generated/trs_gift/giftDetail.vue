<template>
    <el-card class="form-container" shadow="never">
        <el-form :model="gift"
                 :rules="rules"
                 ref="giftFrom"
                 label-width="150px">
                        <el-form-item label="名称" >
                          <el-input v-model="gift.name"></el-input>
                        </el-form-item>
                        <el-form-item label="赞助商名称" >
                          <el-input v-model="gift.sponsorName"></el-input>
                        </el-form-item>
                    <el-form-item label="商品图片">
                        <el-input type="textarea" :autosize="true" v-model="gift.pic"></el-input>
                    </el-form-item>
                      <el-form-item label="数量" >
                        <el-input v-model="gift.num"></el-input>
                      </el-form-item>
                    <el-form-item label="价值" >
                        <el-input v-model="gift.price"></el-input>
                    </el-form-item>
                    <el-form-item label="商家地址">
                        <el-input type="textarea" :autosize="true" v-model="gift.sponsorAddress"></el-input>
                    </el-form-item>
                    <el-form-item label="有效期" >
                        <el-input v-model="gift.validateTime"></el-input>
                    </el-form-item>
                    <el-form-item label="介绍">
                        <el-input type="textarea" :autosize="true" v-model="gift.description"></el-input>
                    </el-form-item>
                      <el-form-item label="状态">
                      <el-radio-group v-model="gift.status">
                        <el-radio :label="0">禁用</el-radio>
                        <el-radio :label="1">启用</el-radio>
                      </el-radio-group>
                      </el-form-item>
                      <el-form-item label="排序" >
                        <el-input v-model="gift.sort"></el-input>
                      </el-form-item>
                    <el-form-item label="创建时间" >
                        <el-input v-model="gift.createDate"></el-input>
                    </el-form-item>
                    <el-form-item label="修改时间" >
                        <el-input v-model="gift.modifyDate"></el-input>
                    </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('giftFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('giftFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/gift';

    const defaultGift = {
    name:'',
    sponsorName:'',
    pic:'',
    num:0,
    sponsorAddress:'',
    description:'',
    status:0,
    sort:0,
    };
    export default {
        name: "GiftDetail",
        components: {},
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            gift: Object.assign({}, defaultGift),
            rules: {
            }
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.gift = response.data;
                });
            } else {
                this.gift = Object.assign({}, defaultGift);
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
                                update(this.$route.query.id, this.gift).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.gift).then(response => {
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
                this.gift = Object.assign({}, defaultGift);
            }
        }
    }
</script>

<style scoped>

</style>
