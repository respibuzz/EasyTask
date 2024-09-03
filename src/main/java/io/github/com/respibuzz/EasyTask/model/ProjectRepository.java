package io.github.com.respibuzz.EasyTask.model;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    List<Project> findAllSteps();
    Optional<Project> findStepById(Integer id);
    Project save(Project entity);

}
