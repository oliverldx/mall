<template> 
    <course-detail :is-edit='true'></course-detail>
</template>
<script>
    import CourseDetail from './components/courseDetail'
    export default {
        name: 'addCourse',
        components: { CourseDetail }
    }
</script>
<style>
</style>