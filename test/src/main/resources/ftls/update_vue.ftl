<template> 
    <${subNameDetailHyphen} :is-edit='true'></${subNameDetailHyphen}>
</template>
<script>
    import ${subName?cap_first}Detail from './components/${subName}Detail'
    export default {
        name: 'add${subName?cap_first}',
        components: { ${subName?cap_first}Detail }
    }
</script>
<style>
</style>