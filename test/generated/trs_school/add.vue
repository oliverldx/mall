<template> 
    <school-detail :is-edit='false'></school-detail>
</template>
<script>
    import SchoolDetail from './components/schoolDetail'
    export default {
        name: 'addSchool',
        components: { SchoolDetail }
    }
</script>
<style>
</style>