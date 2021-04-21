<#macro assignVar>
    <#assign showDateTime = false />
    <#assign showSingleUpload = false />
    <#assign showMultiUpload = false />
    <#assign showTinymce = false />
    <#assign showMapInput = false />
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