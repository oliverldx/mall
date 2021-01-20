<template> 
    <group-distribution-detail :is-edit='false'></group-distribution-detail>
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