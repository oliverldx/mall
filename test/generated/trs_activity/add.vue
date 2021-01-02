<template> 
    <activity-detail :is-edit='false'></activity-detail>
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