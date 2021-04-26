<template> 
    <order-vo-detail :is-edit='true'></order-vo-detail>
</template>
<script>
    import OrderVoDetail from './components/orderVoDetail'
    export default {
        name: 'addOrderVo',
        components: { OrderVoDetail }
    }
</script>
<style>
</style>