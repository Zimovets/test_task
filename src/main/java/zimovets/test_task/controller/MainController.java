package zimovets.test_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zimovets.test_task.dao.ResultDataDao;
import zimovets.test_task.entity.DataChangeLog;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/main")
public class MainController {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    @Autowired
    ResultDataDao resultDataDao;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Long[] array) {
        Map<Long, DataChangeLog> results = new ConcurrentHashMap<>();
        for (Long num: array){
            //executor.execute();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(name = "param") Optional<Long[]> array) {
        return ResponseEntity.ok().build();
    }
}
