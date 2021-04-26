<template> 
    <customer-service-detail :is-edit='false'></customer-service-detail>
</template>
<script>
    import CustomerServiceDetail from './components/customerServiceDetail'
    export default {
        name: 'addCustomerService',
        components: { CustomerServiceDetail }
    }
</script>
<style>
</style>