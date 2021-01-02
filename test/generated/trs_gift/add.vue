<template> 
    <gift-detail :is-edit='false'></gift-detail>
</template>
<script>
    import GiftDetail from './components/giftDetail'
    export default {
        name: 'addGift',
        components: { GiftDetail }
    }
</script>
<style>
</style>