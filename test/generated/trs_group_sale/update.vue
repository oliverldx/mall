<template> 
    <group_sale-detail :is-edit='true'></group_sale-detail>
</template>
<script>
    import Group_saleDetail from './components/group_saleDetail'
    export default {
        name: 'addGroup_sale',
        components: { Group_saleDetail }
    }
</script>
<style>
</style>