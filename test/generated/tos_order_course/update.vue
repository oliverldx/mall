<template> 
    <order-course-detail :is-edit='true'></order-course-detail>
</template>
<script>
    import OrderCourseDetail from './components/orderCourseDetail'
    export default {
        name: 'addOrderCourse',
        components: { OrderCourseDetail }
    }
</script>
<style>
</style>