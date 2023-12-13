package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.entity.Todo;
import ra.service.TodoService;

import java.util.List;

@RestController
// Chuyển dữ liệu cho html dùng
@CrossOrigin("*")

@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getAll() {
        List<Todo> list = todoService.findAll();
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id") Integer id) {
        Todo todo = todoService.findById(id);
        if (todo == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        Todo todoNew = todoService.save(todo);
        if (todoNew != null) {
            return new ResponseEntity<>(todoNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable("id") Integer id, @RequestBody Todo todo) {
        if (todoService.findById(id) != null) {
            Todo todoNew = todoService.save(todo);
            return new ResponseEntity<>(todoNew, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> delete(@PathVariable("id") Integer id) {
        if (todoService.findById(id) != null) {
            todoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
