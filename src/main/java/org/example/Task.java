package org.example;

import java.time.LocalDate;

class Task {
    private int id;
    private String description;
    private String status;
    private String createAt;
    private String updateAt;

    public Task() {

    }

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo";
        this.createAt = LocalDate.now().toString();
        this.updateAt = LocalDate.now().toString();
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }
}
