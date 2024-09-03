package io.github.com.respibuzz.EasyTask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "task_groups")
public class TaskGroup {
    public TaskGroup() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Add a description for task group")
    private String description;
   // @Column(name = "done")
    private boolean done;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskGroup")
    private Set<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    Project getProject() {
        return project;
    }
    void setProject(Project project) {
        this.project = project;
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
    public Set<Task> getTasks() {
        return tasks;
    }
    private void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

}
