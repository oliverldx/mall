<template> 
    <contract-detail :is-edit='false'></contract-detail>
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