<template> 
    <school-activity-detail :is-edit='false'></school-activity-detail>
</template>
<script>
    import SchoolActivityDetail from './components/schoolActivityDetail'
    export default {
        name: 'addSchoolActivity',
        components: { SchoolActivityDetail }
    }
</script>
<style>
</style>