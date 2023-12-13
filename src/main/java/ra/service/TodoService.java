package ra.service;

import ra.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo save(Todo todo);
    Todo findById(Integer id);
    void delete(Integer id);

}
