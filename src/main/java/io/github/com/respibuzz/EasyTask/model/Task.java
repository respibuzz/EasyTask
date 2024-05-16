package io.github.com.respibuzz.EasyTask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {
    public Task() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "id")
    private int id;
   // @Column(name = "dsc")
    @NotBlank(message = "Add a description")
    private String description;
   // @Column(name = "done")
    private boolean done;
    private LocalDateTime deadline;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;





    @PrePersist
    protected void onCreate() {createdOn = LocalDateTime.now();}
    @PreUpdate
    protected void onMerge() {updatedOn = LocalDateTime.now();}

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


    public void updateTask(final Task source){
        this.done = done;
        this.description = description;
        this.deadline = deadline;
    }
}
