<template>
    <el-card shadow="never">
        <el-form :model="school"
                 :rules="rules"
                 ref="schoolFrom"
                 label-width="150px">
                        <el-form-item label="机构名称" >
                          <el-input v-model="school.name"></el-input>
                        </el-form-item>
                        <el-form-item label="联系人" >
                          <el-input v-model="school.contactName"></el-input>
                        </el-form-item>
                        <el-form-item label="联系方式" >
                          <el-input v-model="school.contactNo"></el-input>
                        </el-form-item>
                <el-form-item label="机构相册">
                    <multi-upload v-model="school.pic"></multi-upload>
                </el-form-item>
                <el-form-item label="机构logo">
                    <single-upload v-model="school.logo"></single-upload>
                </el-form-item>
                    <el-form-item label="分校名称">
                        <el-input type="textarea" :autosize="true" v-model="school.subSchool"></el-input>
                    </el-form-item>
                        <el-form-item label="机构视频" >
                          <el-input v-model="school.video"></el-input>
                        </el-form-item>
                <el-form-item label="介绍">
                    <tinymce :width="595" :height="300" v-model="school.description"></tinymce>
                </el-form-item>
                <el-form-item label="地图标注">
                    <map-input v-model="school.latlongitude"></map-input>
                </el-form-item>
                        <el-form-item label="创建时间" >
                            <el-date-picker
                                    v-model="school.createDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="创建时间">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item label="修改时间" >
                            <el-date-picker
                                    v-model="school.modifyDate"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="修改时间">
                            </el-date-picker>
                        </el-form-item>
                <el-form-item label="状态">
                    <el-radio-group v-model="school.status">
                            <el-radio :label="0">禁用</el-radio>
                            <el-radio :label="1">启用</el-radio>
                    </el-radio-group>
                </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('schoolFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('schoolFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/school';
        import SingleUpload from '@/components/Upload/singleUpload';
        import MultiUpload from '@/components/Upload/multiUpload';
        import Tinymce from '@/components/Tinymce';
        import MapInput from '@/components/MapInput/mapInput';

    const defaultSchool = {
    id:'',
    name:'',
    contactName:'',
    contactNo:'',
    pic:[],

    logo:'',
    subSchool:'',

    video:'',
    description:'',

    latlongitude:'',
    createDate:'',
    modifyDate:'',
    status:0,
    };
    export default {
        name: "SchoolDetail",
        components: {
        SingleUpload,
        MultiUpload,
        Tinymce,
        MapInput,
        },
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            school: Object.assign({}, defaultSchool),
            rules: {
            },
            pickerOptions1: {
                disabledDate(time) {
                    return time.getTime() < Date.now();
                }
            },
                :[],
            isReallyEdit:this.isEdit
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.school = response.data;
                    if(this.school.pic===undefined||this.school.pic==null||this.school.pic===''){
                        this.school.pic=[]
                    }else {
                        this.school.pic = this.school.pic.split(',');
                    }
                if(this.school.createDate) {
                    this.school.createDate = new Date(this.school.createDate);
                }
                if(this.school.modifyDate) {
                    this.school.modifyDate = new Date(this.school.modifyDate);
                }
                    if(this.school == null) {
                        this.isReallyEdit = false;
                        this.school = Object.assign({}, defaultSchool);
                    }
                });
            } else {
                this.school = Object.assign({}, defaultSchool);
            }
                this.()
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
                    if(this.school.pic && this.school.pic.length > 0){
                        this.school.pic=this.school.pic.toString()
                    }
                                update(this.$route.query.id, this.school).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                    if(this.school.pic && this.school.pic.length > 0){
                        this.school.pic=this.school.pic.toString()
                    }
                                create(this.school).then(response => {
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
                this.school = Object.assign({}, defaultSchool);
            },
        }
    }
</script>

<style scoped>

</style>
