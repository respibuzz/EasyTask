package io.github.com.respibuzz.EasyTask.adapter;

import io.github.com.respibuzz.EasyTask.model.Project;
import io.github.com.respibuzz.EasyTask.model.ProjectRepository;
import io.github.com.respibuzz.EasyTask.model.TaskGroup;
import io.github.com.respibuzz.EasyTask.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query(" select distinct p from Project p join fetch p.steps")
    List<Project> findAllSteps();

}
