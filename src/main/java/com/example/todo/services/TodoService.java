package com.example.todo.services;

import com.example.todo.models.dto.ToDoItemDto;
import com.example.todo.models.dto.ToDoListDto;

import java.util.List;

public interface TodoService {

    ToDoItemDto addTask(ToDoItemDto todo, Integer id);

    ToDoListDto createList(ToDoListDto todoList);

    List<ToDoItemDto> getTodoList(Integer id ) throws Exception;

}
