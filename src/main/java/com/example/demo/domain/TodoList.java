package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="todolist")
@Entity(name="todolist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="task_id")
public class TodoList {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="task_id")
    private String task_id;
    
    private String task_name;

    private String task_description;

    public TodoList(RequestTodo requestTodo) {
        this.task_name = requestTodo.task_name();
        this.task_description = requestTodo.task_description();
    }

}
