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
                <el-table-column label="金额" width="180" align="center">
                    <template slot-scope="scope">{{scope.row.money}}</template>
                </el-table-column>
                <el-table-column label="备注" width="180" align="center">
                    <template slot-scope="scope">{{scope.row.description}}</template>
                </el-table-column>
                <el-table-column label="时间" width="180" align="center">
                    <template slot-scope="scope">{{scope.row.modifyDate | formatTime}}</template>
                </el-table-column>
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
            <el-form ref="capitalRecordFrom" :rules="rules" :model="capitalRecord" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
                                <el-form-item label="金额" >
                                    <el-input v-model="capitalRecord.money"></el-input>
                                </el-form-item>
                                    <el-form-item label="备注">
                                        <el-input type="textarea" :autosize="true" v-model="capitalRecord.description"></el-input>
                                    </el-form-item>
                                <el-form-item label="修改时间" >
                                    <el-date-picker
                                            v-model="capitalRecord.modifyDate"
                                            value-format="timestamp"
                                            type="datetime"
                                            :picker-options="pickerOptions1"
                                            placeholder="修改时间">
                                    </el-date-picker>
                                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">
                    取消
                </el-button>
                <el-button type="primary" @click="onSubmit('capitalRecordFrom')">
                    提交
                </el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import {fetchList,create, update,del} from '@/api/user/capitalRecord'


    const defaultCapitalRecord = {
        description:'',

        modifyDate:'',
    };

    const defaultListQuery = {
        userId: this.userId,
        pageNum: 1,
        pageSize: 10
    };

    export default {
        name: 'capitalRecord',
        props: {
            userId: {
                type: [String, Number]
            }
        },
        data() {
            return {
                capitalRecord: Object.assign({}, defaultCapitalRecord),
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
        formatTime(time) {
            if(time==null||time===''){
                return 'N/A';
            }
            let date = new Date(time);
            return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
        },
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
                    this.$refs['capitalRecordFrom'].clearValidate()
                })
            },
            cancelEdit(row) {
                row.originalMoney = row.money
                row.originalDescription = row.description
                row.originalModifyDate = row.modifyDate
                row.edit = false
                this.$message({
                    message: '修改已取消',
                    type: 'warning'
                })
            },
            confirmEdit(row) {
                row.originalMoney = row.money
                row.originalDescription = row.description
                row.originalModifyDate = row.modifyDate
                row.edit = false
                this.capitalRecord.tusUserId=this.userId
                update(this.userId, this.capitalRecord).then(response => {
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
                            this.capitalRecord.tusUserId=this.userId
                            create(this.capitalRecord).then(response => {
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
                this.capitalRecord = Object.assign({}, defaultCapitalRecord);
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>

