<template> 
    <contract-detail :is-edit='true'></contract-detail>
</template>
<script>
    import ContractDetail from './components/contractDetail'
    export default {
        name: 'addContract',
        components: { ContractDetail }
    }
</script>
<style>
</style>