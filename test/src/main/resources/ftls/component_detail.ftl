<template>
    <el-card class="form-container" shadow="never">
        <el-form :model="${subName}"
                 :rules="rules"
                 ref="${subName}From"
                 label-width="150px">
            <#list columns as column>
                <#if column.comment??>
                <#switch column.type>
                    <#case "binint">
                        <#if (column.pkFlag)!>
                            <el-form-item label="${column.comment}" >
                                <el-input v-model="${subName}.${column.name}"></el-input>
                            </el-form-item>
                        </#if>
                        <#break>
                    <#case "varchar">
                        <#if column.length == 1>
                        <el-form-item label="${column.comment}">
                            <el-radio-group v-model="${subName}.${column.name}">
                                <#assign json=column.description?eval />
                                <#list json[column.name].vals as item >
                                    <el-radio :label="${item.val!}">${item.name!}</el-radio>
                                </#list>
                            </el-radio-group>
                        </el-form-item>
                        <#else>
                        <el-form-item label="${column.comment}" >
                          <el-input v-model="${subName}.${column.name}"></el-input>
                        </el-form-item>
                        </#if>
                      <#break>
                    <#case "text">
                    <el-form-item label="${column.comment}">
                        <el-input type="textarea" :autosize="true" v-model="${subName}.${column.name}"></el-input>
                    </el-form-item>
                    <#break>
                    <#case "int">
                      <#if column.length == 1>
                      <el-form-item label="${column.comment}">
                      <el-radio-group v-model="${subName}.${column.name}">
                        <#assign json=column.description?eval />
                        <#list json[column.name].vals as item >
                        <el-radio :label="${item.val!}">${item.name!}</el-radio>
                        </#list>
                      </el-radio-group>
                      </el-form-item>
                      <#else>
                      <el-form-item label="${column.comment}" >
                        <el-input v-model="${subName}.${column.name}"></el-input>
                      </el-form-item>
                      </#if>
                      <#break>
                    <#case "char">
                        <#if column.length == 1>
                        <el-form-item label="${column.comment}">
                            <el-radio-group v-model="${subName}.${column.name}">
                                <#assign json=column.description?eval />
                                <#list json[column.name].vals as item >
                                    <el-radio :label="${item.val!}">${item.name!}</el-radio>
                                </#list>
                            </el-radio-group>
                        </el-form-item>
                      <#else>
                      <el-form-item label="${column.comment}" >
                        <el-input v-model="${subName}.${column.name}"></el-input>
                      </el-form-item>
                      </#if>
                      <#break>
                    <#default>
                    <el-form-item label="${column.comment}" >
                        <el-input v-model="${subName}.${column.name}"></el-input>
                    </el-form-item>
                </#switch>
                </#if>
            </#list>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('${subName}From')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('${subName}From')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
    import {fetchList, create, update, getById} from '@/api/${subName}';

    const default${subName?cap_first} = {
    <#list columns as column>
    <#switch column.type>
    <#case "binint">
    ${column.name}:'',
    <#break>
    <#case "varchar">
    ${column.name}:'',
    <#break>
    <#case "text">
    ${column.name}:'',
    <#break>
    <#case "int">
    ${column.name}:0,
    <#break>
    <#case "char">
    ${column.name}:'',
    <#break>
    <#default>
    </#switch>
    </#list>
    };
    export default {
        name: "${subName?cap_first}Detail",
        components: {},
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            ${subName}: Object.assign({}, default${subName?cap_first}),
            rules: {
            }
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.${subName} = response.data;
                });
            } else {
                this.${subName} = Object.assign({}, default${subName?cap_first});
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
                                update(this.$route.query.id, this.${subName}).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                create(this.${subName}).then(response => {
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
                this.${subName} = Object.assign({}, default${subName?cap_first});
            }
        }
    }
</script>

<style scoped>

</style>
