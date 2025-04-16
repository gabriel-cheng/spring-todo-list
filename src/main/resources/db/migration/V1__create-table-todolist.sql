CREATE TABLE todoList(
    task_id TEXT PRIMARY KEY UNIQUE NOT NULL,
    task_name TEXT NOT NULL,
    task_description TEXT NOT NULL
);