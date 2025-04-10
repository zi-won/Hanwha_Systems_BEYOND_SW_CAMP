<template>
    <div class="parentContainer">
        <child>
            {{ slotData }}
        </child>
    </div>
</template>

<!-- 다른 vue 파일을 import할 때는 내가 원하는 이름으로 쓸 수 있다.(feat. export default이기 때문)
     보통은 이름을 같게 한다.
-->
<script setup>
    import Child from './SlotChild.vue';
    import { ref } from 'vue';

    const slotData = ref('hello data');     // slot은 일반적으로 태그 형태로 전달된다.
                                            // (일반적으로 상태값, 데이터는 뒤에 배울 props를 활용하는 편이다.)
</script>

<style scoped>
    .parentContainer {
        display: felx;
        align-items: center;
        flex-direction: column;
        border: 1px solid black;
    }
</style>