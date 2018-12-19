package zimovets.test_task.controller;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/main")
public class MainController {

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Long[] array) {
        for (long a: array){
            System.out.println(a);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(name = "param") Optional<Long[]> array){
        System.out.println(array.isPresent());
        return ResponseEntity.ok("Hello");
    }
}
