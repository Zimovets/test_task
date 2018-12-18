package zimovets.test_task.controller;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> getAll() {
        Long[] a = {10L, 100L,1000L};
        return ResponseEntity.ok(a);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        Map<Long, Integer> a = new HashMap<>();
        a.put(1L,10);
        a.put(2L,100);
        a.put(3L,1000);
        System.out.println(a.get(id));
        return ResponseEntity.ok("Hello");
    }
}
