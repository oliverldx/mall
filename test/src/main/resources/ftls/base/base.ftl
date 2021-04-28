<#macro assignVar>
    <#assign showDateTime = false />
    <#assign showSingleUpload = false />
    <#assign showMultiUpload = false />
    <#assign showTinymce = false />
    <#assign showMapInput = false />
    <#assign formatDateTime = false />
</#macro>

<#macro importJs>
    <#if showSingleUpload>
        import SingleUpload from '@/components/Upload/singleUpload';
    </#if>
    <#if showMultiUpload>
        import MultiUpload from '@/components/Upload/multiUpload';
    </#if>
    <#if showTinymce>
        import Tinymce from '@/components/Tinymce';
    </#if>
    <#if showMapInput>
        import MapInput from '@/components/MapInput/mapInput';
    </#if>
</#macro>

<#macro importVueComponents>
    <#if showSingleUpload>
        SingleUpload,
    </#if>
    <#if showMultiUpload>
        MultiUpload,
    </#if>
    <#if showTinymce>
        Tinymce,
    </#if>
    <#if showMapInput>
        MapInput,
    </#if>
</#macro>

<#macro initObject>
    <#list columns as column>
        <#switch column.type>
            <#case "text">
            <#if column.description??>
                <#assign json=column.description?eval />
                <#switch json[column.name].type>
                    <#case "singleUpload">
                    <#case "multiUpload">
                    if(this.${subName}.${column.name}===undefined||this.${subName}.${column.name}==null||this.${subName}.${column.name}===''){
                        this.${subName}.${column.name}=[]
                    }else {
                        this.${subName}.${column.name} = this.${subName}.${column.name}.split(',');
                    }
                        <#break >
                    <#default >
                </#switch>
            <#else >
            </#if>
            <#break>
            <#case "datetime">
                if(this.${subName}.${column.name}) {
                    this.${subName}.${column.name} = new Date(this.${subName}.${column.name});
                }
                <#break>
            <#default>
        </#switch>
    </#list>
</#macro>

<#macro updateObject>
    <#list columns as column>
        <#switch column.type>
            <#case "text">
                <#if column.description??>
                    <#assign json=column.description?eval />
                    <#switch json[column.name].type>
                        <#case "singleUpload">
                        <#case "multiUpload">
                    if(this.${subName}.${column.name} && this.${subName}.${column.name}.length > 0){
                        this.${subName}.${column.name}=this.${subName}.${column.name}.toString()
                    }
                            <#break >
                        <#default >
                    </#switch>
                <#else >
                </#if>
                <#break>
            <#default>
        </#switch>
    </#list>
</#macro>

<#macro listObject columns>
    <#list columns as column>
    <#--只渲染label不为空的字段-->
        <#if column.label?default("")?trim?length gt 1>
            <#if column.description??>
                <#assign json=column.description?eval />
                <#--驼峰转下划线-->
<#--                <#assign jsonColName=json[column.name?replace("([a-z])([A-Z]+)","$1_$2","r")?lower_case]/>-->
                <#assign jsonColName=json[column.name]/>
                <#if jsonColName??>
                <#switch jsonColName.type>
                    <#case "singleUpload">
                        <el-table-column label="${column.label!'TODO'}" width="180" align="center">
                            <template slot-scope="scope"><img style="height: 80px" :src="scope.row.${column.name}"></template>
                        </el-table-column>
                        <#break >
                    <#case "sql">
                        <#assign vals=jsonColName.vals/>
                        <#list vals as val>
                            <#if val.label == column.label>
                                <#if val.aliasVue??>
                        <el-table-column label="${column.label!'TODO'}" width="180" align="center">
                            <template slot-scope="scope">{{scope.row.${val.aliasVue}}}</template>
                        </el-table-column>
                                </#if>
                                <#else >
                        <el-table-column label="${column.label!'TODO'}" width="180" align="center">
                            <template slot-scope="scope">{{scope.row.${column.name}}}</template>
                        </el-table-column>
                            </#if>
                        </#list>
                        <#break >
                    <#case "radio">
                        <el-table-column label="${column.label!'TODO'}" width="180" align="center">
                            <template slot-scope="scope">{{scope.row.${column.name} | format${column.name?cap_first}}}</template>
                        </el-table-column>
                        <#break >
                    <#default >
                    <el-table-column label="${column.label!'TODO'}" width="180" align="center">
                        <template slot-scope="scope">{{scope.row.${column.name}}}</template>
                    </el-table-column>
                </#switch>
                </#if>
            <#elseif column.type == 'datetime' >
                <#assign formatDateTime = true />
                <el-table-column label="${column.label!'TODO'}" width="180" align="center">
                    <template slot-scope="scope">{{scope.row.${column.name} | formatTime}}</template>
                </el-table-column>
            <#else >
                <el-table-column label="${column.label!'TODO'}" width="180" align="center">
                    <template slot-scope="scope">{{scope.row.${column.name}}}</template>
                </el-table-column>
            </#if>
        </#if>
    </#list>
</#macro>

<#macro genDefaultOptions>
    <#list columns as column>
        <#switch column.type>
            <#case "int">
                 <#if column.length?? && column.length == 1 && column.description??>
                     <#assign json=column.description?eval />
                     <#switch json[column.name].type>
                         <#case "radio">
                             <#assign vals=json[column.name].vals/>
     const default${column.name?cap_first}Options=[
                             <#list vals as val>
         {
         label: '${val.name}',
         value: ${val.val}
         },
                             </#list>
     ];
                             <#break >
                         <#default >
                     </#switch>
                </#if>
                <#break>
            <#default>
        </#switch>
    </#list>
</#macro>

<#macro genFormatMethods>
    <#list columns as column>
        <#switch column.type>
            <#case "int">
                 <#if column.length?? && column.length == 1 && column.description??>
                     <#assign json=column.description?eval />
                     <#switch json[column.name].type>
                         <#case "radio">
         format${column.name?cap_first}(${column.name}){
            for(let i=0;i<default${column.name?cap_first}Options.length;i++){
                 if(status===default${column.name?cap_first}Options[i].value){
                    return default${column.name?cap_first}Options[i].label;
                 }
             }
         },
                             <#break >
                         <#default >
                     </#switch>
                </#if>
                <#break>
            <#case "datetime">
                <#assign formatDateTime = true />
                <#break>
            <#default>
        </#switch>
    </#list>
    <#if formatDateTime>
        formatTime(time) {
            if(time==null||time===''){
                return 'N/A';
            }
            let date = new Date(time);
            return formatDate(date, 'yyyy-MM-dd hh:mm:ss')
        },
    </#if>
</#macro>

<#macro renderFormItem column>
    <#if column.description??>
        <#assign json=column.description?eval />
        <#switch json[column.name].type>
            <#case "radio">
                <el-form-item label="${column.comment}">
                    <el-radio-group v-model="${subName}.${column.name}">
                        <#list json[column.name].vals as item >
                            <el-radio :label="${item.val!}">${item.name!}</el-radio>
                        </#list>
                    </el-radio-group>
                </el-form-item>
                <#break >
            <#case "singleUpload">
                <#assign showSingleUpload = true />
                <el-form-item label="${column.comment}">
                    <single-upload v-model="${subName}.${column.name}"></single-upload>
                </el-form-item>
                <#break >
            <#case "multiUpload">
                <#assign showMultiUpload = true />
                <el-form-item label="${column.comment}">
                    <multi-upload v-model="${subName}.${column.name}"></multi-upload>
                </el-form-item>
                <#break >
            <#case "tinymce">
                <#assign showTinymce = true />
                <el-form-item label="${column.comment}">
                    <tinymce :width="595" :height="300" v-model="${subName}.${column.name}"></tinymce>
                </el-form-item>
                <#break >
            <#case "mapInput">
                <#assign showMapInput = true />
                <el-form-item label="${column.comment}">
                    <map-input v-model="${subName}.${column.name}"></map-input>
                </el-form-item>
                <#break >
            <#default >
                <#switch column.type>
                    <#case "text">
                        <el-form-item label="${column.comment}">
                            <el-input type="textarea" :autosize="true" v-model="${subName}.${column.name}"></el-input>
                        </el-form-item>
                        <#break >
                    <#default >
                        <el-form-item label="${column.comment}" >
                            <el-input v-model="${subName}.${column.name}"></el-input>
                        </el-form-item>
                </#switch>
        </#switch>
    </#if>
</#macro>

