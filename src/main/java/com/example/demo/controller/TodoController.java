package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.RequestTodo;
import com.example.demo.domain.TodoList;
import com.example.demo.domain.TodoRepository;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<List<TodoList>> getAllTodos() {
        try {
            List<TodoList> allTasks = todoRepository.findAll();

            return ResponseEntity.status(HttpStatus.OK).body(allTasks);
        } catch(Exception findAllExceptionError) {
            System.out.println("Failed to find all tasks: " + findAllExceptionError);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> registerNewTask(@RequestBody @Validated RequestTodo task) {
        try {
            TodoList newTask = new TodoList(task);

            todoRepository.save(newTask);

            return ResponseEntity.status(HttpStatus.OK).body("New task created successfully!");
        } catch(Exception registerNewTaskExceptionE rror) {
            System.out.println("Failed while register a new task: " + registerNewTaskExceptionError);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error, please try again latter!");
        }


    }

    public ResponseEntity<String> changeTask(@RequestBody @Validated TodoRepository todoRepository, @PathVariable String task_id) {

    }

}
