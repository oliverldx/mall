<template> 
    <order-detail :is-edit='true'></order-detail>
</template>
<script>
    import OrderDetail from './components/orderDetail'
    export default {
        name: 'addOrder',
        components: { OrderDetail }
    }
</script>
<style>
</style>