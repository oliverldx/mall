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
                <map-input v-model="pages.buttomText"></map-input>
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