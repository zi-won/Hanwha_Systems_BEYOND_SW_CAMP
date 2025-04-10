<template>
    <div>
        <h1 id="test">MyComponent</h1>
    </div>
</template>

<script setup>
    import { onMounted } from 'vue';

        // export default{
        //     setup() {
             onMounted(() => {
                console.log('MyComponent 부착!');
                let $idEle = document.getElementById('test');
                console.log($idEle);
             })
        //     }
        // }
</script>

<style scoped>
    #test {
        color: blue;
    }
</style>