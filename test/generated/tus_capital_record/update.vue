<template> 
    <capital-record-detail :is-edit='true'></capital-record-detail>
</template>
<script>
    import CapitalRecordDetail from './components/capitalRecordDetail'
    export default {
        name: 'addCapitalRecord',
        components: { CapitalRecordDetail }
    }
</script>
<style>
</style>