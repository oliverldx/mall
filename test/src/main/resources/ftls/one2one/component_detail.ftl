<#include "../base/base.ftl">
<template>
    <el-card shadow="never">
        <el-form :model="${subName}"
                 :rules="rules"
                 ref="${subName}From"
                 label-width="150px">
            <@assignVar />
            <#list columns as column>
                <#if column.comment??>
                <#switch column.type>
                    <#case "bigint">
                        <#if (column.pkFlag)!>
                            <el-form-item label="${column.comment}" >
                                <el-input v-model="${subName}.${column.name}"></el-input>
                            </el-form-item>
                        </#if>
                        <#break>
                    <#case "varchar">
                        <#if column.description??>
                            <@renderFormItem column=column></@renderFormItem>
                        <#else>
                        <el-form-item label="${column.comment}" >
                          <el-input v-model="${subName}.${column.name}"></el-input>
                        </el-form-item>
                        </#if>
                      <#break>
                    <#case "text">
                    <#if column.description??>
                        <@renderFormItem column=column></@renderFormItem>
                    <#else >
                    <el-form-item label="${column.comment}">
                        <el-input type="textarea" :autosize="true" v-model="${subName}.${column.name}"></el-input>
                    </el-form-item>
                    </#if>
                    <#break>
                    <#case "int">
                      <#if column.length?? && column.length == 1 && column.description??>
                          <@renderFormItem column=column></@renderFormItem>
                      <#else>
                      <el-form-item label="${column.comment}" >
                        <el-input v-model="${subName}.${column.name}"></el-input>
                      </el-form-item>
                      </#if>
                      <#break>
                    <#case "char">
                        <#if column.length == 1>
                            <@renderFormItem column=column></@renderFormItem>
                      <#else>
                      <el-form-item label="${column.comment}" >
                        <el-input v-model="${subName}.${column.name}"></el-input>
                      </el-form-item>
                      </#if>
                      <#break>
                    <#case "datetime">
                    <#assign showDateTime = true />
                        <el-form-item label="${column.comment}" >
                            <el-date-picker
                                    v-model="${subName}.${column.name}"
                                    value-format="timestamp"
                                    type="datetime"
                                    :picker-options="pickerOptions1"
                                    placeholder="${column.comment}">
                            </el-date-picker>
                        </el-form-item>
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
    import {fetchList, create, update, getById,getBy${fkId?cap_first}} from '@/api/${parentTableSubName}/${subName}';
    <@importJs/>

    const default${subName?cap_first} = {
    <#list columns as column>
    <#switch column.type>
    <#case "bigint">
    ${column.name}:'',
    <#break>
    <#case "varchar">
    ${column.name}:'',
    <#break>
    <#case "text">
    <#if column.description??>
        <#assign json=column.description?eval />
        <#switch json[column.name].type>
        <#case "singleUpload">
        <#case "multiUpload">
    ${column.name}:[],
        <#break >
        <#default >
    ${column.name}:'',
        </#switch>
        <#else >
    ${column.name}:'',
    </#if>

    <#break>
    <#case "int">
    ${column.name}:0,
    <#break>
    <#case "char">
    ${column.name}:'',
    <#break>
    <#case "datetime">
    ${column.name}:'',
    <#break>
    <#default>
    </#switch>
    </#list>
    };
    export default {
        name: "${subName?cap_first}Detail",
        components: {
           <@importVueComponents/>
        },
        props: {
            isEdit: {
                type: Boolean,
                default: false
            },
            ${fkId}: {
                type: [String, Number]
            }
        },
        data() {
            return {
            ${subName}: Object.assign({}, default${subName?cap_first}),
            rules: {
            },
            <#if showDateTime>
            pickerOptions1: {
                disabledDate(time) {
                    return time.getTime() < Date.now();
                }
            },
            </#if>
            isReallyEdit:this.isEdit
        }
        },
        created() {
            if (this.isEdit) {
                getBy${fkId?cap_first}(this.${fkId}).then(response => {
                    this.${subName} = response.data;
                    <@initObject/>
                    if(this.${subName} == null) {
                        this.isReallyEdit = false;
                        this.${subName} = Object.assign({}, default${subName?cap_first});
                    }
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
                            if (this.isEdit && this.isReallyEdit) {
				                <@updateObject/>
                                update(this.${fkId}, this.${subName}).then(response => {
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                <@updateObject/>
                                this.${subName}.${one2oneColName}=this.${fkId}
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
