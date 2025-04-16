package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            System.out.println("Error to find all: " + findAllExceptionError);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
