package com.example.todo.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ToDoListDto {
    @NotBlank(message = "Nombre no esta presente")
    private String name;
}
