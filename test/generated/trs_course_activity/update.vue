<template> 
    <course_activity-detail :is-edit='true'></course_activity-detail>
</template>
<script>
    import Course_activityDetail from './components/course_activityDetail'
    export default {
        name: 'addCourse_activity',
        components: { Course_activityDetail }
    }
</script>
<style>
</style>