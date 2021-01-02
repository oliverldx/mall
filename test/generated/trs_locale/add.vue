<template> 
    <locale-detail :is-edit='false'></locale-detail>
</template>
<script>
    import LocaleDetail from './components/localeDetail'
    export default {
        name: 'addLocale',
        components: { LocaleDetail }
    }
</script>
<style>
</style>