<template> 
    <group-distribution-detail :is-edit='true'></group-distribution-detail>
</template>
<script>
    import GroupDistributionDetail from './components/groupDistributionDetail'
    export default {
        name: 'addGroupDistribution',
        components: { GroupDistributionDetail }
    }
</script>
<style>
</style>