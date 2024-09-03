package io.github.com.respibuzz.EasyTask.model.projection;

import io.github.com.respibuzz.EasyTask.model.Task;

public class GroupTaskReadModel {

    public GroupTaskReadModel(Task soruce){
        description = soruce.getDescription();
        done = soruce.isDone();
    }

    private String description;
    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
