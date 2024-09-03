package io.github.com.respibuzz.EasyTask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    public Task() {}

    public Task(String description, LocalDateTime deadline){
         this.description = description;
         this.deadline = deadline;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Add a description for task")
    private String description;
   // @Column(name = "done")
    private boolean done;
    private LocalDateTime deadline;
    @Embedded
    private Audit audit = new Audit();
    @ManyToOne
    @JoinColumn(name = "task_group_id")
    private TaskGroup taskGroup;

    public LocalDateTime getDeadline() {
        return deadline;
    }
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public TaskGroup getTaskGroup() {
        return taskGroup;
    }
    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    public void updateTask (final Task source){
      done = source.done;
      description = source.description;
      deadline = source.deadline;
      taskGroup = source.taskGroup;
    }
}
