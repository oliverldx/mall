<template> 
    <course-detail :is-edit='false'></course-detail>
</template>
<script>
    import CourseDetail from './components/CourseDetail'
    export default {
        name: 'addCourse'
        components: { CourseDetail }
    }
</script>
<style>
</style>