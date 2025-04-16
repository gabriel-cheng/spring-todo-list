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

@Table(name="todo")
@Entity(name="todo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="taskId")
public class TodoList {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="taskid")
    private String taskId;
    
    private String taskName;

    private String taskDescription;

    public TodoList(RequestTodo requestTodo) {
        this.taskName = requestTodo.taskName();
        this.taskDescription = requestTodo.taskDescription();
    }

}
