<template> 
    <activity-detail :is-edit='true'></activity-detail>
</template>
<script>
    import ActivityDetail from './components/activityDetail'
    export default {
        name: 'addActivity',
        components: { ActivityDetail }
    }
</script>
<style>
</style>