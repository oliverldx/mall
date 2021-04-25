<template> 
    <promotion-poster-detail :is-edit='true'></promotion-poster-detail>
</template>
<script>
    import PromotionPosterDetail from './components/promotionPosterDetail'
    export default {
        name: 'addPromotionPoster',
        components: { PromotionPosterDetail }
    }
</script>
<style>
</style>