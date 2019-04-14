import Vue from "vue";
import todo from "./component/Todo.vue";

export default new Vue({
    components: {
        todo: todo
    }
}).$mount("#app");