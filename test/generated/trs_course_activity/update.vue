<template> 
    <course-activity-detail :is-edit='true'></course-activity-detail>
</template>
<script>
    import CourseActivityDetail from './components/courseActivityDetail'
    export default {
        name: 'addCourseActivity',
        components: { CourseActivityDetail }
    }
</script>
<style>
</style>