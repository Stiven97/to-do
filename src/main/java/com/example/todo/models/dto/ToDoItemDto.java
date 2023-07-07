package com.example.todo.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoItemDto {
    @NotBlank(message = "Nombre no esta presente")
    private  String name;
    private  boolean finished;

}
