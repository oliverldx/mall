<template>
    <div class="app-container">
        <el-card class="filter-container" shadow="never">
            <div>
                <i class="el-icon-search"></i>
                <span>筛选搜索</span>
                <el-button
                        style="float:right"
                        type="primary"
                        @click="handleSearchList()"
                        size="small">
                    查询搜索
                </el-button>
                <el-button
                        style="float:right;margin-right: 15px"
                        @click="handleResetSearch()"
                        size="small">
                    重置
                </el-button>
            </div>
            <div style="margin-top: 15px">
                <el-form :inline="true" :model="listQuery" size="small" label-width="140px">
                    <el-form-item label="TODO-字段1：">
                        <el-input v-model="listQuery.TODOtmp1" class="input-width" placeholder="TODO-字段1"></el-input>
                    </el-form-item>
                    <el-form-item label="TODO-字段1：">
                        <el-input v-model="listQuery.TODOtmp2" class="input-width" placeholder="TODO-字段2"></el-input>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
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
                    <template slot-scope="scope">{{scope.row.id}}</template>
                </el-table-column>
                        <el-table-column label="标志" width="180" align="center">
                            <template slot-scope="scope"><img style="height: 80px" :src="scope.row.logo"></template>
                        </el-table-column>
                <el-table-column label="名称" width="180" align="center">
                    <template slot-scope="scope">{{scope.row.name}}</template>
                </el-table-column>
                <el-table-column label="联系人" width="180" align="center">
                    <template slot-scope="scope">{{scope.row.contactName}}</template>
                </el-table-column>
                <el-table-column label="联系方式" width="180" align="center">
                    <template slot-scope="scope">{{scope.row.contactNo}}</template>
                </el-table-column>
                        <el-table-column label="状态" width="180" align="center">
                            <template slot-scope="scope">{{scope.row.status | formatStatus}}</template>
                        </el-table-column>
                <el-table-column label="操作" width="200" align="center">
                    <template slot-scope="scope">
                        <el-button
                                size="mini"
                                @click="handleUpdate(scope.$index, scope.row)"
                        >编辑</el-button>
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
    </div>
</template>

<script>
    import {fetchList,del} from '@/api/school'

    const defaultListQuery = {
        pageNum: 1,
        pageSize: 10
    };

     const defaultStatusOptions=[
         {
         label: '禁用',
         value: 0
         },
         {
         label: '启用',
         value: 1
         },
     ];

    export default {
        name: 'school',
        props: {},
        data() {
            return {
                listQuery: Object.assign({}, defaultListQuery),
                listLoading: true,
                list: null,
                total: null,
                operateType: null,
                multipleSelection: []
            }
        },
        created() {
            this.getList();
        },
        mounted() {},
        filters:{
         formatStatus(status){
            for(let i=0;i<defaultStatusOptions.length;i++){
                 if(status===defaultStatusOptions[i].value){
                    return defaultStatusOptions[i].label;
                 }
             }
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
                this.$router.push({path:'/trs/addSchool'});
            },
            handleUpdate(index, row){
                this.$router.push({path:'/trs/updateSchool',query:{id:row.id}});
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
        }
    }
</script>

<style lang="scss" scoped>

</style>
