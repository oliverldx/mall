<template> 
    <user-detail :is-edit='true'></user-detail>
</template>
<script>
    import UserDetail from './components/userDetail'
    export default {
        name: 'addUser',
        components: { UserDetail }
    }
</script>
<style>
</style>