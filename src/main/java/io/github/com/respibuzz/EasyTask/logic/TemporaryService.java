package io.github.com.respibuzz.EasyTask.logic;

import io.github.com.respibuzz.EasyTask.model.Task;
import io.github.com.respibuzz.EasyTask.model.TaskGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemporaryService {
     List<String> tempGetGrDesc(TaskGroupRepository repository) {
        return repository.findAllGroups().stream()
                .flatMap(taskGroup -> taskGroup.getTasks().stream())
                .map(Task::getDescription)
                .collect(Collectors.toUnmodifiableList());
    }
}
