<template>
    <div class="container">
        <div class="well well-sm" style="margin: 3rem 0;">
            <h1 class="text-center">Todo</h1>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th @click="sortTodo('task')">Task</th>
                <th @click="sortTodo('priority')">Priority</th>
                <th>Action<span class="todo-closed">완료 : <span v-text="getClosedTodo"></span></span></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <input v-model="task" type="text" class="form-control" placeholder="할일을 입력해주세요.">
                </td>
                <td>
                    <select v-model="priority" class="form-control" >
                        <option v-for="priority in priorities" :key="priority" :value="priority">{{ priority }}</option>
                    </select>
                </td>
                <td>
                    <button @click="addTodo()" type="button" class="btn btn-primary">추가</button>
                </td>
            </tr>
            <tr v-for="(todo, index) in todos" :key="index">
                <td>
                    <span v-show="!todo.edit" @click="editTask(index)" class="task">{{ todo.task }}</span>
                    <input v-show="todo.edit" type="text" class="form-control" placeholder="할일을 입력해주세요"
                           v-model="todo.task" @keyup.enter="closeEditing(index)" @keyup.esc="closeEditing(index)"
                           @blur="closeEditing(index)" ref="taskEdit">
                </td>
                <td>
                    <select class="form-control" :disabled="todo.closed">
                        <option v-for="priority in priorities" :key="priority" :selected="priority === todo.priority" :value="priority" class="text-capitalize">{{ priority }}</option>
                    </select>
                </td>
                <td>
                    <button v-show="!todo.closed" @click="finishTodo(index)" type="button" class="btn btn-success">완료</button>
                    <button v-show="todo.closed" @click="rollbackTodo(index)" type="button" class="btn btn-warning">원복</button>
                    <button @click="deleteTodo(index)" type="button" class="btn btn-danger">삭제</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import Vue from "vue";
    import Component from 'vue-class-component';

    @Component
    export default class Todo extends Vue {
        priorities = ["low", "medium", "high", "critical"];
        task = "";
        priority = "low";
        asc = 1;
        todos = [
            {task:"뷰 스터디", edit: false, priority: "medium", closed: false},
            {task:"롤 하기", edit: false, priority: "high", closed: true}
        ];

        get getClosedTodo() {
            return this.todos.filter(todo => todo.closed).length;
        }

        addTodo() {
            this.todos.push({task: this.task, edit: false, priority: this.priority, closed: false});
        }

        sortTodo(standard) {
            this.todos.forEach((todo, index) => {
                this.todos[index].edit = false;
            });

            this.asc = this.asc * -1;
            this.todos.sort((a, b) => {
                const BEFORE = -1 * this.asc;
                const EQUAL = 0;
                const AFTER = this.asc;

                if (a[standard] < b[standard]) {
                    return BEFORE;
                }

                if (a[standard] > b[standard]) {
                    return AFTER;
                }

                return EQUAL;
            });
        }

        editTask(index) {
            if(!this.todos[index].closed) {
                this.todos[index].edit = true;
                this.$nextTick(() => this.$refs.taskEdit[index].focus());
            }
        }

        closeEditing(index) {
            this.todos[index].edit = false;
        }

        finishTodo(index) {
            this.todos[index].closed = true;
        }

        rollbackTodo(index) {
            this.todos[index].closed = false;
        }

        deleteTodo(index) {
            this.todos.splice(index, 1);
        }
    }
</script>
<style scoped>
    .task {
        height: auto;
        padding: 7px 13px;
        display: block;
        width: auto;
    }

    .todo-closed {
        float: right;
    }
</style>