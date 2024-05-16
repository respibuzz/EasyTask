package io.github.com.respibuzz.EasyTask.controller;

import io.github.com.respibuzz.EasyTask.model.Task;
import io.github.com.respibuzz.EasyTask.model.TaskRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;


@Controller
class TaskController {

    private TaskRepository repository;
    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("All tasks exposed");
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable page) {
        logger.info("Pageable implement");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task taskToUpdate){
        logger.info("Put task implementation");
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(task -> {
                        task.updateTask(taskToUpdate);
                    repository.save(task);
                });
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PATCH,value = "/tasks/{id}")
    public ResponseEntity<?> toogleTask(@PathVariable int id){
        logger.info("Patch task implementation");
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(task -> task.setDone(!task.isDone()));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping( method = RequestMethod.POST,value = "/tasks")
    ResponseEntity<Task> addTask (@RequestBody @Valid Task taskToDo){
    Task created = repository.save(taskToDo);
    return ResponseEntity.created(URI.create("/" + created.getId())).build();
    }

    @RequestMapping (method = RequestMethod.GET, value = "/tasks/{id}")
    ResponseEntity<Task> readTask (@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping (method = RequestMethod.GET, value = "/tasks/done")
    ResponseEntity<List<Task>> readByDone(@RequestParam boolean done){
        logger.info("done");
       List<Task> doneTasks = repository.findByDone(done);
        return ResponseEntity.ok(doneTasks);
    }


}

