CREATE TABLE todoList(
    taskId TEXT PRIMARY KEY UNIQUE NOT NULL,
    taskName TEXT NOT NULL,
    taskDescription TEXT NOT NULL
);