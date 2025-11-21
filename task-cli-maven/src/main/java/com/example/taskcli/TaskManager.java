package com.example.taskcli;

import java.util.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String title) {
        tasks.add(new Task(nextId++, title));
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    public boolean editTask(int id, String newTitle) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setTitle(newTitle);
                return true;
            }
        }
        return false;
    }

    public List<Task> listTasks() {
        return tasks;
    }
}
