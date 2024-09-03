package io.github.com.respibuzz.EasyTask.model;

import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {

    List<TaskGroup> findAllGroups();
    Optional<TaskGroup> findGroupById(Integer id);
    TaskGroup save(TaskGroup entity);
    boolean existsByDoneIsFalseAndAndProject_Id(Integer project_id);

}
