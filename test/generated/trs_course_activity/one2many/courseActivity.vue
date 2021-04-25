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
                        <el-table-column label="ID" width="180" align="center">
                            <template slot-scope="scope">
                                <template v-if="scope.row.edit">
                                    <el-input v-model="scope.row.id" class="edit-input" size="small" />
                                    <el-button
                                            class="cancel-btn"
                                            size="small"
                                            icon="el-icon-refresh"
                                            type="warning"
                                            @click="cancelEdit(scope.row)"
                                    >
                                        取消
                                    </el-button>
                                </template>
                                <span v-else>{{scope.row.id}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column label="课程" width="180" align="center">
                            <template slot-scope="scope">
                                <template v-if="scope.row.edit">
                                    <el-input v-model="scope.row.courseName" class="edit-input" size="small" />
                                    <el-button
                                            class="cancel-btn"
                                            size="small"
                                            icon="el-icon-refresh"
                                            type="warning"
                                            @click="cancelEdit(scope.row)"
                                    >
                                        取消
                                    </el-button>
                                </template>
                                <span v-else>{{scope.row.courseName}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column label="库存数" width="180" align="center">
                            <template slot-scope="scope">
                                <template v-if="scope.row.edit">
                                    <el-input v-model="scope.row.courseNum" class="edit-input" size="small" />
                                    <el-button
                                            class="cancel-btn"
                                            size="small"
                                            icon="el-icon-refresh"
                                            type="warning"
                                            @click="cancelEdit(scope.row)"
                                    >
                                        取消
                                    </el-button>
                                </template>
                                <span v-else>{{scope.row.courseNum}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column label="排序" width="180" align="center">
                            <template slot-scope="scope">
                                <template v-if="scope.row.edit">
                                    <el-input v-model="scope.row.sort" class="edit-input" size="small" />
                                    <el-button
                                            class="cancel-btn"
                                            size="small"
                                            icon="el-icon-refresh"
                                            type="warning"
                                            @click="cancelEdit(scope.row)"
                                    >
                                        取消
                                    </el-button>
                                </template>
                                <span v-else>{{scope.row.sort}}</span>
                            </template>
                        </el-table-column>
                        <el-table-column label="报名数" width="180" align="center">
                            <template slot-scope="scope">
                                <template v-if="scope.row.edit">
                                    <el-input v-model="scope.row.applyNum" class="edit-input" size="small" />
                                    <el-button
                                            class="cancel-btn"
                                            size="small"
                                            icon="el-icon-refresh"
                                            type="warning"
                                            @click="cancelEdit(scope.row)"
                                    >
                                        取消
                                    </el-button>
                                </template>
                                <span v-else>{{scope.row.applyNum}}</span>
                            </template>
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
        <el-dialog title="新增" :visible.sync="selectDialogVisible" width="50%">
            <el-input v-model="dialogData.listQuery.keyword"
                      style="width: 250px;margin-bottom: 20px"
                      size="small"
                      placeholder="商品名称搜索">
                <el-button slot="append" icon="el-icon-search" @click="handleSelectSearch()"></el-button>
            </el-input>
            <el-table :data="dialogData.list"
                      @selection-change="handleDialogSelectionChange" border>
                <el-table-column type="selection" width="60" align="center"></el-table-column>
                        <el-table-column label="ID" width="180" align="center">
                            <template slot-scope="scope">{{scope.row.id}}</template>
                        </el-table-column>
                        <el-table-column label="头图" width="180" align="center">
                            <template slot-scope="scope">{{scope.row.pic}}</template>
                        </el-table-column>
                        <el-table-column label="课程名称" width="180" align="center">
                            <template slot-scope="scope">{{scope.row.name}}</template>
                        </el-table-column>
                        <el-table-column label="原价" width="180" align="center">
                            <template slot-scope="scope">{{scope.row.price}}</template>
                        </el-table-column>
            </el-table>
            <div class="pagination-container">
                <el-pagination
                        background
                        @size-change="handleDialogSizeChange"
                        @current-change="handleDialogCurrentChange"
                        layout="prev, pager, next"
                        :current-page.sync="dialogData.listQuery.pageNum"
                        :page-size="dialogData.listQuery.pageSize"
                        :page-sizes="[5,10,15]"
                        :total="dialogData.total">
                </el-pagination>
            </div>
            <div style="clear: both;"></div>
            <div slot="footer">
                <el-button  size="small" @click="selectDialogVisible = false">取 消</el-button>
                <el-button  size="small" type="primary" @click="handleSelectDialogConfirm()">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import {fetchList,create, update,del,fetchCourseList,createCourseList} from '@/api/activity/courseActivity'

    const defaultListQuery = {
        pageNum: 1,
        pageSize: 10
    };

    export default {
        name: 'courseActivity',
        props: {
            activityId: {
                type: [String, Number]
            }
        },
        data() {
            return {
                listQuery: Object.assign({}, defaultListQuery),
                listLoading: true,
                list: null,
                total: null,
                operateType: null,
                courseActivity:null,
                multipleSelection: [],
                selectDialogVisible:false,
                dialogData:{
                    list: null,
                    total: null,
                    multipleSelection:[],
                    listQuery:{
                        keyword: null,
                        pageNum: 1,
                        pageSize: 5
                    }
                }
            }
        },
        created() {
            this.getList();
        },
        mounted() {},
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
                this.selectDialogVisible=true;
                this.getDialogList();
            },
            cancelEdit(row) {
                row.courseName = row.originalCourseName
                row.courseNum = row.originalCourseNum
                row.sort = row.originalSort
                row.applyNum = row.originalApplyNum
                row.edit = false
                this.$message({
                    message: '修改已取消',
                    type: 'warning'
                })
            },
            confirmEdit(row) {
                row.originalCourseName = row.courseName
                row.originalCourseNum = row.courseNum
                row.originalSort = row.sort
                row.originalApplyNum = row.applyNum
                row.edit = false
                this.courseActivity = row
                this.courseActivity.trsActivityId=this.activityId
                update(this.activityId, this.courseActivity).then(response => {
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
                this.listQuery.trsActivityId=this.activityId;
                fetchList(this.listQuery).then(response => {
                    this.listLoading = false;
                    const dataList = response.data.list;
                    this.list = dataList.map(row => {
                        this.$set(row, 'edit', false) // https://vuejs.org/v2/guide/reactivity.html
                row.originalCourseName = row.courseName
                row.originalCourseNum = row.courseNum
                row.originalSort = row.sort
                row.originalApplyNum = row.applyNum
                        return row
                    })
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
            handleSelectSearch(){
                this.getDialogList();
            },
            handleDialogSizeChange(val) {
                this.dialogData.listQuery.pageNum = 1;
                this.dialogData.listQuery.pageSize = val;
                this.getDialogList();
            },
            handleDialogCurrentChange(val) {
                this.dialogData.listQuery.pageNum = val;
                this.getDialogList();
            },
            handleDialogSelectionChange(val){
                this.dialogData.multipleSelection = val;
            },
            handleSelectDialogConfirm(){
                if (this.dialogData.multipleSelection < 1) {
                    this.$message({
                        message: '请选择一条记录',
                        type: 'warning',
                        duration: 1000
                    });
                    return;
                }
                let params = new URLSearchParams();
                let selectCourses = [];
                for (let i = 0; i < this.dialogData.multipleSelection.length; i++) {
                    selectCourses.push(this.dialogData.multipleSelection[i].id);
                }
                this.$confirm('使用要进行添加操作?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    params.append("ids",selectCourses);
                    params.append("activityId",this.activityId);
                    createCourseList(params).then(response=>{
                        this.selectDialogVisible=false;
                        this.dialogData.multipleSelection=[];
                        this.getList();
                        this.$message({
                            type: 'success',
                            message: '添加成功!'
                        });
                    });
                });
            },
            getDialogList(){
                fetchCourseList(this.dialogData.listQuery).then(response=>{
                    this.dialogData.list=response.data.list;
                    this.dialogData.total=response.data.total;
                })
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>

