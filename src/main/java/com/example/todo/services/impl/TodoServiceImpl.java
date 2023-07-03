package com.example.todo.services.impl;

import com.example.todo.models.dto.ToDoItemDto;
import com.example.todo.models.dto.ToDoListDto;
import com.example.todo.models.entity.ToDoItem;
import com.example.todo.models.entity.ToDoList;
import com.example.todo.repository.ToDoItemRepository;
import com.example.todo.repository.ToDoListRepository;
import com.example.todo.services.TodoService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private  final ToDoListRepository toDoListRepository;

    private  final  ToDoItemRepository toDoItemReposotory;

    public  TodoServiceImpl(ToDoListRepository toDoListRepository, ToDoItemRepository toDoItemRepository) {
        this.toDoListRepository = toDoListRepository;
        this.toDoItemReposotory = toDoItemRepository;

    }


    @SneakyThrows
    @Override
    public ToDoItemDto addTask(ToDoItemDto todo, Integer id) {
        var  list = toDoListRepository.findById(id). orElseThrow(Exception::new);

        var item = ToDoItem.builder()
                .finished(todo.isFinished())
                .name(todo.getName())
                .toDoList(list)
                .build();
        toDoItemReposotory.save(item);

        return  todo;
    }

    @Override
    public ToDoListDto createList(ToDoListDto todoList) {
        var list = ToDoList.builder()
                .name(todoList.getName())
                .build();
        toDoListRepository.save(list);
        return todoList;
    }
    @SneakyThrows
    @Override
    public List<ToDoItemDto> getTodoList(Integer id) throws Exception {
        var list = toDoListRepository.findById(id).orElseThrow(Exception ::new);

        return list.getTasks()
                .stream()
                .map( task ->  new ToDoItemDto(task.getName(), task.isFinished()))
                .toList();



    }
}
