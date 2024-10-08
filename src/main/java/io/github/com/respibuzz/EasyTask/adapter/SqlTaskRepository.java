package io.github.com.respibuzz.EasyTask.adapter;

import io.github.com.respibuzz.EasyTask.model.Task;
import io.github.com.respibuzz.EasyTask.model.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
 interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
 @Override
 @Query(nativeQuery = true, value = "select count(*) > 0 from TASKS where id=:id ")
 boolean existsById(@Param("id")Integer id);

 @Override
 boolean existsByDoneIsFalseAndTaskGroupId(Integer taskGroupId);
}
