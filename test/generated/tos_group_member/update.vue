<template> 
    <group-member-detail :is-edit='true'></group-member-detail>
</template>
<script>
    import GroupMemberDetail from './components/groupMemberDetail'
    export default {
        name: 'addGroupMember',
        components: { GroupMemberDetail }
    }
</script>
<style>
</style>