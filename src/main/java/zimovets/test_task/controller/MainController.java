package zimovets.test_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zimovets.test_task.dao.ResultDataDao;
import zimovets.test_task.entity.DataChangeLog;
import zimovets.test_task.entity.ResultData;
import zimovets.test_task.services.DataHandler;
import zimovets.test_task.services.RunnableFirst;
import zimovets.test_task.services.RunnableSecond;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/main")
public class MainController {


    @Autowired
    ResultDataDao resultDataDao;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Long[] array) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Map<Long, DataChangeLog> results = DataHandler.createLogMap(array);
        for (Long num : array) {
            executor.execute(new RunnableFirst(results, num));
            System.out.println("add task first");
            executor.execute(new RunnableSecond(results, num));
            System.out.println("add task second");
        }
        System.out.println("no tasks ----------------------");
        executor.shutdown();

        while (!executor.isTerminated()) {
            try {
                System.out.println("Termination!!!");
                executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ArrayList<ResultData> res = DataHandler.convertToResult(results);
        for (ResultData data : res) {
            resultDataDao.save(data);
        }
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(name = "param") Optional<Long[]> array) {

        if (!array.isPresent()) {
            return ResponseEntity.ok(Arrays.asList(resultDataDao.findAll()));
        }
        ArrayList<ResultData> toResponse = new ArrayList<>();
        for (Long l : array.get()) {
            toResponse.add(resultDataDao.findByNum(l));
        }
        return ResponseEntity.ok(toResponse.toArray());
    }
}
