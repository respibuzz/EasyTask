package io.github.com.respibuzz.EasyTask.model.projection;

import io.github.com.respibuzz.EasyTask.model.Task;

import java.time.LocalDateTime;

public class GroupTaskWriteModel {

    private String description;
    private LocalDateTime deadline;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
    public Task toTask(){
        return new Task(description, deadline);
    }

}
