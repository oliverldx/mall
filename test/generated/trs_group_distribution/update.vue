<template> 
    <group_distribution-detail :is-edit='true'></group_distribution-detail>
</template>
<script>
    import Group_distributionDetail from './components/group_distributionDetail'
    export default {
        name: 'addGroup_distribution',
        components: { Group_distributionDetail }
    }
</script>
<style>
</style>