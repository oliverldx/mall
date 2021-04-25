<template> 
    <order-gift-detail :is-edit='false'></order-gift-detail>
</template>
<script>
    import OrderGiftDetail from './components/orderGiftDetail'
    export default {
        name: 'addOrderGift',
        components: { OrderGiftDetail }
    }
</script>
<style>
</style>