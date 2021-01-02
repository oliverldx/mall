<template> 
    <pages-detail :is-edit='true'></pages-detail>
</template>
<script>
    import PagesDetail from './components/pagesDetail'
    export default {
        name: 'addPages',
        components: { PagesDetail }
    }
</script>
<style>
</style>