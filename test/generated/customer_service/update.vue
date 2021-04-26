<template> 
    <service-detail :is-edit='true'></service-detail>
</template>
<script>
    import ServiceDetail from './components/serviceDetail'
    export default {
        name: 'addService',
        components: { ServiceDetail }
    }
</script>
<style>
</style>