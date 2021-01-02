<template> 
    <school_activity-detail :is-edit='true'></school_activity-detail>
</template>
<script>
    import School_activityDetail from './components/school_activityDetail'
    export default {
        name: 'addSchool_activity',
        components: { School_activityDetail }
    }
</script>
<style>
</style>