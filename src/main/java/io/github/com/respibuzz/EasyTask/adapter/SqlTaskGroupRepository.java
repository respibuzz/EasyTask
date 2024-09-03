package io.github.com.respibuzz.EasyTask.adapter;

import io.github.com.respibuzz.EasyTask.model.TaskGroup;
import io.github.com.respibuzz.EasyTask.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Integer> {

    @Override
    @Query("select distinct g from TaskGroup g join fetch g.tasks")
    List<TaskGroup> findAllGroups();
    @Override
    boolean existsByDoneIsFalseAndAndProject_Id(Integer project_id);
}