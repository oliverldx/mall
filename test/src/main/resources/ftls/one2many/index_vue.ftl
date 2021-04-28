<#include "../base/base.ftl">
<#if template>
<template>
    <div class="app-container">
        <el-card class="operate-container" shadow="never">
            <i class="el-icon-tickets"></i>
            <span>数据列表</span>
            <el-button
                    class="btn-add"
                    @click="handleAdd()"
                    size="mini">
                添加
            </el-button>
        </el-card>
        <div class="table-container">
            <el-table ref="orderTable"
                      :data="list"
                      style="width: 100%;"
                      @selection-change="handleSelectionChange"
                      v-loading="listLoading" border>
                <el-table-column type="selection" width="60" align="center"></el-table-column>
                <@listObject columns=columns/>
                <el-table-column label="操作" width="200" align="center">
                    <template slot-scope="scope">
                        <el-button
                                v-if="scope.row.edit"
                                type="success"
                                size="mini"
                                icon="el-icon-circle-check-outline"
                                @click="confirmEdit(scope.row)"
                        >
                            确认
                        </el-button>
                        <el-button
                                v-else
                                type="primary"
                                size="mini"
                                icon="el-icon-edit"
                                @click="scope.row.edit=!scope.row.edit"
                        >
                            编辑
                        </el-button>
                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <div class="pagination-container">
            <el-pagination
                    background
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    layout="total, sizes,prev, pager, next,jumper"
                    :current-page.sync="listQuery.pageNum"
                    :page-size="listQuery.pageSize"
                    :page-sizes="[5,10,15]"
                    :total="total">
            </el-pagination>
        </div>
        <el-dialog title="添加" :visible.sync="dialogFormVisible">
            <el-form ref="${subName}From" :rules="rules" :model="${subName}" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
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
                                <#if column.length == 1>
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
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">
                    取消
                </el-button>
                <el-button type="primary" @click="onSubmit('${subName}From')">
                    提交
                </el-button>
            </div>
        </el-dialog>
    </div>
</template>
</#if>

<#if script>
<script>
    import {fetchList,create, update,del} from '@/api/${parentTableSubName}/${subName}'
    <@importJs/>
    <#if formatDateTime >
    import {formatDate} from '@/utils/date'
    </#if>

    <@genDefaultOptions/>

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

    const defaultListQuery = {
        ${fkId}: this.${fkId},
        pageNum: 1,
        pageSize: 10
    };

    export default {
        name: '${subName}',
        props: {
            ${fkId}: {
                type: [String, Number]
            }
        },
        data() {
            return {
                ${subName}: Object.assign({}, default${subName?cap_first}),
                rules: {
                },
                listQuery: Object.assign({}, defaultListQuery),
                listLoading: true,
                list: null,
                total: null,
                operateType: null,
                dialogFormVisible: false,
                multipleSelection: [],
                pickerOptions1: {
                    disabledDate(time) {
                        return time.getTime() < Date.now();
                    }
                }
            }
        },
        created() {
            this.getList();
        },
        mounted() {},
    filters:{
        <@genFormatMethods/>
    },
        methods: {
            handleResetSearch() {
                this.listQuery = Object.assign({}, defaultListQuery);
            },
            handleSearchList() {
                this.listQuery.pageNum = 1;
                this.getList();
            },
            handleSelectionChange(val){
                this.multipleSelection = val;
            },
            handleSizeChange(val){
                this.listQuery.pageNum = 1;
                this.listQuery.pageSize = val;
                this.getList();
            },
            handleCurrentChange(val){
                this.listQuery.pageNum = val;
                this.getList();
            },
            handleAdd() {
                this.dialogFormVisible = true
                this.$nextTick(() => {
                    this.$refs['${subName}From'].clearValidate()
                })
            },
            cancelEdit(row) {
                <@addOrignCol columns=columns/>
                row.edit = false
                this.$message({
                    message: '修改已取消',
                    type: 'warning'
                })
            },
            confirmEdit(row) {
                <@addOrignCol columns=columns/>
                row.edit = false
                this.${subName}.${one2manyColName}=this.${fkId}
                update(this.${fkId}, this.${subName}).then(response => {
                    this.$message({
                        message: '修改成功',
                        type: 'success',
                        duration: 1000
                    });
                });
            },
            handleDelete(index, row){
                let ids=[];
                ids.push(row.id);
                this.del(ids);
            },
            getList() {
                this.listLoading = true;
                fetchList(this.listQuery).then(response => {
                    this.listLoading = false;
                    this.list = response.data.list;
                    this.total = response.data.total;
                });
            },
            del(ids){
                this.$confirm('是否要进行该删除操作?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let params = new URLSearchParams();
                    params.append("ids",ids);
                    del(params).then(response=>{
                        this.$message({
                            message: '删除成功！',
                            type: 'success',
                            duration: 1000
                        });
                        this.getList();
                    });
                })
            },
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$confirm('是否提交数据', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            this.${subName}.${one2manyColName}=this.${fkId}
                            create(this.${subName}).then(response => {
                                this.$refs[formName].resetFields();
                                this.resetForm(formName);
                                this.$message({
                                    message: '提交成功',
                                    type: 'success',
                                    duration: 1000
                                });
                            });
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
</#if>

<#if style>
<style lang="scss" scoped>

</style>
</#if>

<#macro addOrignCol columns>
    <#list columns as column>
    <#--只渲染label不为空的字段-->
        <#if column.label?default("")?trim?length gt 1 && !column.pkFlag && !column.fkFlag>
                row.original${column.name?cap_first} = row.${column.name}
        </#if>
    </#list>
</#macro>

<#macro resetCol columns>
    <#list columns as column>
    <#--只渲染label不为空的字段-->
        <#if column.label?default("")?trim?length gt 1 && !column.pkFlag && !column.fkFlag>
                row.${column.name} = row.original${column.name?cap_first}
        </#if>
    </#list>
</#macro>