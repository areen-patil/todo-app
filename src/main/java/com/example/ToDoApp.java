package com.example;

import java.util.ArrayList;
import java.util.List;

public class ToDoApp {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public static void main(String[] args) {
        ToDoApp app = new ToDoApp();
        System.out.println("To-Do List Application Started...");
        app.addTask("Buy Milk");
        app.addTask("Complete Assignment");
    }
}