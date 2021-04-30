<#include "./base/base.ftl">
<#assign listParentMethod='' />
<#assign listParentOption='' />
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
                        <#if (column.fkFlag)!>
                            <#if column.description??>
                                <#assign json=column.description?eval />
                                <#switch json[column.name].type>
                                    <#case "sql">
                                        <#assign vals=json[column.name].vals/>
                                        <#list vals as val>
                                            <#if val.label == column.label>
                                                <#if val.aliasVue??>
                                                <#assign listParentMethod='list'+val.aliasVue?cap_first+'Method'/>
                                                <#assign listParentOption='list'+val.aliasVue?cap_first+'Options'/>

                            <el-form-item label="${column.comment}" >
                                <el-select
                                        v-model="${subName}.${column.name}"
                                        filterable
                                        reserve-keyword
                                        placeholder="请选择${column.label}">
                                    <el-option
                                            v-for="item in list${val.aliasVue?cap_first}Options"
                                            :key="item.${column.name}"
                                            :label="item.${val.aliasVue}"
                                            :value="item.${column.name}">
                                        <#-- <span style="float: left">{{ item.productName }}</span>
                                         <span style="float: right; color: #8492a6; font-size: 13px">NO.{{ item.productSn }}</span>-->
                                    </el-option>
                                </el-select>
                            </el-form-item>
                                                </#if>
                                            </#if>
                                        </#list>
                                        <#break >
                                    <#default >
                                </#switch>
                            </#if>

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
    import {fetchList, create, update, getById} from '@/api/${subName}';
    <#if listParentMethod?default("")?trim?length gt 1 && parentTableSubName??>
    import {fetchList as fetchParentTableList} from '@/api/${parentTableSubName}';
    </#if>

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
    <#if column.description??>
    <#assign json=column.description?eval />
    <#switch json[column.name].type>
    <#case "radio">
    <#assign vals=json[column.name].vals/>
    <#assign findRadioDefault=false/>
    <#list vals as v>
    <#if v.default?default("")?trim?length gt 1>
    <#assign findRadioDefault=true/>
    ${column.name}:${v.val},
    </#if>
    </#list>
    <#if findRadioDefault == false>
    ${column.name}:0,
    </#if>
    <#break >
    <#default >
    ${column.name}:0,
    </#switch>
    <#else >
    ${column.name}:0,
    </#if>
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
            <#if listParentOption?default("")?trim?length gt 1>
                ${listParentOption}:[],
            </#if>
            isReallyEdit:this.isEdit
        }
        },
        created() {
            if (this.isEdit) {
                getById(this.$route.query.id).then(response => {
                    this.${subName} = response.data;
                    if(this.${subName} == null) {
                        this.isReallyEdit = false;
                        this.${subName} = Object.assign({}, default${subName?cap_first});
                    }
                    <@initObject/>
                });
            } else {
                this.${subName} = Object.assign({}, default${subName?cap_first});
            }
            <#if listParentMethod?default("")?trim?length gt 1>
                this.${listParentMethod}()
            </#if>
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
                                <@updateObject/>
                                <#if getUpdateObject>
                                update(this.$route.query.id, tmp${subName?cap_first}).then(response => {
                                <#else >
                                update(this.$route.query.id, this.${subName}).then(response => {
                                </#if>
                                    this.$message({
                                        message: '修改成功',
                                        type: 'success',
                                        duration: 1000
                                    });
                                    this.$router.back();
                                });
                            } else {
                                <@updateObject/>
                                <#if getUpdateObject>
                                create(tmp${subName?cap_first}).then(response => {
                                <#else >
                                create(this.${subName}).then(response => {
                                </#if>
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
            },
            <#list columns as column>
            <#switch column.type>
            <#case "bigint">
            <#if (column.fkFlag)!>
                <#if column.description??>
                <#assign json=column.description?eval />
                <#switch json[column.name].type>
                        <#case "sql">
                        <#assign vals=json[column.name].vals/>
                        <#list vals as val>
                            <#if val.label == column.label>
                                <#if val.aliasVue??>
                list${val.aliasVue?cap_first}Method(){
                    fetchParentTableList({pageNum: 1,pageSize: 1000}).then(response=>{
                        let list = response.data.list;
                        this.list${val.aliasVue?cap_first}Options = [];
                        for(let i=0;i<list.length;i++){
                            let item = list[i];
                            this.list${val.aliasVue?cap_first}Options.push({${column.name}:item.${column.fkColumnName},${val.aliasVue}:item.${val.dataName}});
                        }
                    });
                }
                                </#if>
                            </#if>
                        </#list>
                <#break >
                <#default >
                </#switch>
                </#if>
            </#if>
            <#break>
            <#default>
            </#switch>
            </#list>
        }
    }
</script>

<style scoped>

</style>
