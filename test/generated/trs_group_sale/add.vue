<template> 
    <group-sale-detail :is-edit='false'></group-sale-detail>
</template>
<script>
    import GroupSaleDetail from './components/groupSaleDetail'
    export default {
        name: 'addGroupSale',
        components: { GroupSaleDetail }
    }
</script>
<style>
</style>