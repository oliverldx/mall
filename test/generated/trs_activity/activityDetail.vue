<template>
    <el-card shadow="never">
        <el-form :model="activity"
                 :rules="rules"
                 ref="activityFrom"
                 label-width="150px">
                        <el-form-item label="活动名称" >
                          <el-input v-model="activity.name"></el-input>
                        </el-form-item>
                    <el-form-item label="活动价格" >
                        <el-input v-model="activity.price"></el-input>
                    </el-form-item>
                      <el-form-item label="销售数量" >
                        <el-input v-model="activity.salesNum"></el-input>
                      </el-form-item>
                      <el-form-item label="课程数量" >
                        <el-input v-model="activity.courseNum"></el-input>
                      </el-form-item>
                    <el-form-item label="介绍">
                        <el-input type="textarea" :autosize="true" v-model="activity.description"></el-input>
                    </el-form-item>
                        <el-form-item label="访问二维码" >
                          <el-input v-model="activity.qrcode"></el-input>
                        </el-form-item>
                        <el-form-item label="结束时间" >
                            <el-date-picker
                                    v-model="activity.endDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="结束时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="开始时间" >
                            <el-date-picker
                                    v-model="activity.startDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="开始时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="activity.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="activity.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
                <el-form-item label="状态">
                    <el-radio-group v-model="activity.status">
                            <el-radio :label="0">禁用</el-radio>
                            <el-radio :label="1">启用</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="是否需要选足课程">
                    <el-radio-group v-model="activity.chooseAllCourse">
                            <el-radio :label="0">不需要</el-radio>
                            <el-radio :label="1">需要</el-radio>
                    </el-radio-group>
                </el-form-item>
                      <el-form-item label="赠品可选数量限制" >
                        <el-input v-model="activity.giftNum"></el-input>
                      </el-form-item>
                <el-form-item label="是否开启抽奖">
                    <el-radio-group v-model="activity.luckyDraw">
                            <el-radio :label="0">不开启</el-radio>
                            <el-radio :label="1">开启</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="是否开启机构评分">
                    <el-radio-group v-model="activity.schoolMark">
                            <el-radio :label="0">不开启</el-radio>
                            <el-radio :label="1">开启</el-radio>
                    </el-radio-group>
                </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('activityFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('activityFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/activity';


    const defaultActivity = {
    id:'',
    name:'',
    salesNum:0,
    courseNum:0,
    description:'',

    qrcode:'',
    endDate:'',
    startDate:'',
    createDate:'',
    modifyDate:'',
    status:0,
    chooseAllCourse:0,
    giftNum:0,
    luckyDraw:0,
    schoolMark:0,
    };
    export default {
        name: "ActivityDetail",
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
            activity: Object.assign({}, defaultActivity),
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
                    this.activity = response.data;
                    if(this.activity == null) {
                        this.isReallyEdit = false;
                        this.activity = Object.assign({}, defaultActivity);
                    }
                if(this.activity.endDate) {
                    this.activity.endDate = new Date(this.activity.endDate);
                }
                if(this.activity.startDate) {
                    this.activity.startDate = new Date(this.activity.startDate);
                }
                if(this.activity.createDate) {
                    this.activity.createDate = new Date(this.activity.createDate);
                }
                if(this.activity.modifyDate) {
                    this.activity.modifyDate = new Date(this.activity.modifyDate);
                }
                });
            } else {
                this.activity = Object.assign({}, defaultActivity);
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
                                update(this.$route.query.id, this.activity).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.activity).then(response => {
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
                this.activity = Object.assign({}, defaultActivity);
            },
        }
    }
</script>

<style scoped>

</style>
