package ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.entity.Todo;
import ra.respository.TodoRespository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRespository todoRespository;
    @Override
    public List<Todo> findAll() {
        return (List<Todo>) todoRespository.findAll();
    }

    @Override
    public Todo save(Todo todo) {
        return todoRespository.save(todo);
    }

    @Override
    public Todo findById(Integer id) {
        Optional<Todo> optionalTodo = todoRespository.findById(id);
        return optionalTodo.orElse(null);
    }

    @Override
    public void delete(Integer id) {
        todoRespository.deleteById(id);
    }
}
