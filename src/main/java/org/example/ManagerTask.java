package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

class ManagerTask {
    private ArrayList<Task> tasks = null;

    public ManagerTask(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // Adiciona novas tarefas
    public void add(String description) {
        this.getTasks().add(new Task(this.getTasks().size() + 1, description));
    }

    // Atualiza a descricao da tarefa
    public void update(int id, String description) {
        this.getTasks().get(id - 1).setDescription(description);
        this.getTasks().get(id - 1).setUpdateAt(LocalDate.now().toString());
    }

    // Remove uma tarefa
    public void delete(int id) {
        this.getTasks().remove(this.getTasks().get(id - 1));

        // ajusta os ids para corresponderem ao ArrayList
        for (int i=id;i<this.getTasks().size()+1;i++) {
            this.getTasks().get(id - 1).setId(this.getTasks().get(id - 1).getId() - 1);
        }
    }

    /* Atualiza o status */
    public void mark_todo(int id) {
        this.getTasks().get(id - 1).setStatus("todo");
    }

    public void mark_in_progress(int id) {
        this.getTasks().get(id - 1).setStatus("in-progress");
    }

    public void mark_done(int id) {
        this.getTasks().get(id - 1).setStatus("done");
    }

    // Busca tarefas por id
    public Task searchID(int id) {
        Iterator<Task> iterator = this.getTasks().iterator();

        Task currentTask;
        while (iterator.hasNext()) {
            currentTask = iterator.next();
            if (currentTask.getId() == id) {
                return currentTask;
            }
        }

        System.out.println("Nenhuma correspondencia encontrada");

        return null;
    }

    // Lista as tarefas
    public String list_all() {
        StringBuilder list = new StringBuilder();
        Iterator<Task> iterator = this.getTasks().iterator();;
        Task task = null;

        while (iterator.hasNext()) {
            task = iterator.next();
            list.append(task.getId() + " " + task.getDescription() + "\n");
        }

        return list.toString();
    }

    public String list_in_progress() {
        StringBuilder list = new StringBuilder();
        Iterator<Task> iterator = this.getTasks().iterator();;
        Task task = null;

        while (iterator.hasNext()) {
            task = iterator.next();
            if (task.getStatus().equals("in-progress")) {
                list.append(task.getId() + " " + task.getDescription() + "\n");
            }
        }

        return list.toString();
    }

    public String list_todo() {
        StringBuilder list = new StringBuilder();
        Iterator<Task> iterator = this.getTasks().iterator();;
        Task task = null;

        while (iterator.hasNext()) {
            task = iterator.next();
            if (task.getStatus().equals("todo")) {
                list.append(task.getId() + " " + task.getDescription() + "\n");
            }
        }

        return list.toString();
    }

    public String list_done() {
        StringBuilder list = new StringBuilder();
        Iterator<Task> iterator = this.getTasks().iterator();;
        Task task = null;

        while (iterator.hasNext()) {
            task = iterator.next();
            if (task.getStatus().equals("done")) {
                list.append(task.getId() + " " + task.getDescription() + "\n");
            }
        }

        return list.toString();
    }

    // Getters
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Setters
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
