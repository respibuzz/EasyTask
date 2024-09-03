package io.github.com.respibuzz.EasyTask.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table (name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Add a description for project")
    private String description;

    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> groups;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectSteps> steps;

    public Set<ProjectSteps> getSteps() {
        return steps;
    }

    private void setSteps(Set<ProjectSteps> steps) {
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private Set<TaskGroup> getGroups() {
        return groups;
    }

    private void setGroups(Set<TaskGroup> groups) {
        this.groups = groups;
    }
}
