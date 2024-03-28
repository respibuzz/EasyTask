package io.github.com.respibuzz.EasyTask.controller;

import io.github.com.respibuzz.EasyTask.TaskConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    private DataSourceProperties dataSource;
    private TaskConfigurationProperties prop;

    public InfoController(DataSourceProperties dataSource, TaskConfigurationProperties prop) {
        this.dataSource = dataSource;
        this.prop = prop;
    }

    @GetMapping("/dburl")
    String getDBUrl () {
        return dataSource.getUrl();
    }

    @GetMapping("/getprop")
    boolean getProp (){
        return prop.getTemplate().isAllowMultipleTasks();
    }
}
