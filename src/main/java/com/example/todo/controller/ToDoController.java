package com.example.todo.controller;

import com.example.todo.models.dto.ToDoItemDto;
import com.example.todo.models.dto.ToDoListDto;
import com.example.todo.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v0/todo")
public class ToDoController {
    private final TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<ToDoItemDto>> getTasKByListId(@PathVariable(value = "id") Integer uidList) throws Exception {
        var response = todoService.getTodoList(uidList);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("/{id}")
    public ResponseEntity<ToDoItemDto> addTask(@PathVariable(value = "id") Integer uidList,
                                               @Valid
                                               @RequestBody ToDoItemDto task) {
        var response = todoService.addTask(task, uidList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ToDoListDto> createList(@Valid @RequestBody ToDoListDto list) {
        var response = todoService.createList(list);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
