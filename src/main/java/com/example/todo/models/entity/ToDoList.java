package com.example.todo.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "to_do_list")
public class ToDoList {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column (name =  "uid", nullable = false)
    private  Integer id;
    private  String name;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "toDoList")
    @ToString.Exclude
    private List<ToDoItem> tasks = new LinkedList<>();

    public List<ToDoItem> getTasks() {
        return tasks;
    }

    public void setTasks(List<ToDoItem> tasks) {
        this.tasks = tasks;
    }
}
