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

import java.util.Optional;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    ResultDataDao resultDataDao;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Long[] array) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(name = "param") Optional<Long[]> array) {
        return ResponseEntity.ok().build();
    }
}
