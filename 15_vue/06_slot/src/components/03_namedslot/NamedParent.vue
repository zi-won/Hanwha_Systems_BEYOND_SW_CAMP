<template>
    <div class="container">
        <h1>NamedSlot</h1>

        <!-- v-slot은 부모가 가진 데이터(또는 태그)를 자식 컴포넌트에 다양한 이름으로 전달할 수 있다. -->
        <!-- v-bind: => :, v-on: => @, v-slot: => # -->
        <NamedChild>
            <template v-slot:name>
                <h2>
                    name: {{ obj.name }}
                </h2>
            </template>
            <template v-slot:founder>
                <p>founder: {{ obj.founder }}</p>
            </template>
            <template #img>
                <img :src="obj.img" :alt="'evan you 이미지'">
            </template>
        </NamedChild>
    </div>
</template>

<script setup>
    import NamedChild from './NamedChild.vue';
    import {reactive} from 'vue';

    const obj = reactive({
        name: "vue",
        founder: "Evan You",
        img: "https://images.ctfassets.net/s5uo95nf6njh/2fEr6ctL9FxPtOPhUcM4FA/773007e573bfa16aebdb736f767b45fa/evan-you-hero.jpg"
    });
</script>

<style scoped>
    .container {
        display: flex;
        flex-direction: column;
        align-items: center;
        border: 1px solid black;
    }
    img {
        width: 200px;
        height: 200px;
    }
</style>