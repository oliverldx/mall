<template> 
    <relationship-config-detail :is-edit='true'></relationship-config-detail>
</template>
<script>
    import RelationshipConfigDetail from './components/relationshipConfigDetail'
    export default {
        name: 'addRelationshipConfig',
        components: { RelationshipConfigDetail }
    }
</script>
<style>
</style>