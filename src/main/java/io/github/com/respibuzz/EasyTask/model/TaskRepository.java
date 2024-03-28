package io.github.com.respibuzz.EasyTask.model;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(Integer id);
    List<Task> findAll();
    Task save(Task entity);
    List<Task> findByDone(@Valid boolean done);
    boolean existsById(Integer id);
    Page<Task> findAll(Pageable pageable);
}
