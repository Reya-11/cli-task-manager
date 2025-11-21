package com.example.taskcli;

import java.util.*;

public class Main {

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";

    private static void promptClearScreen(Scanner scanner) {
        System.out.println("\nPress ENTER to continue...");
        scanner.nextLine();
        for (int i = 0; i < 50; i++) System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println(CYAN + "=== Task Manager CLI ===" + RESET);
            System.out.println("[A] Add Task");
            System.out.println("[D] Delete Task");
            System.out.println("[E] Edit Task");
            System.out.println("[L] List Tasks");
            System.out.println("[Q] Quit");
            System.out.print(YELLOW + "Choose an option: " + RESET);

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    manager.addTask(title);
                    System.out.println(GREEN + "Task added!" + RESET);
                    promptClearScreen(scanner);
                    break;

                case "D":
                    System.out.print("Enter task ID to delete: ");
                    int delId = Integer.parseInt(scanner.nextLine());
                    if (manager.deleteTask(delId)) {
                        System.out.println(GREEN + "Deleted!" + RESET);
                    } else {
                        System.out.println("Task not found.");
                    }
                    promptClearScreen(scanner);
                    break;

                case "E":
                    System.out.print("Enter task ID to edit: ");
                    int editId = Integer.parseInt(scanner.nextLine());
                    System.out.print("New title: ");
                    String newTitle = scanner.nextLine();
                    if (manager.editTask(editId, newTitle)) {
                        System.out.println(GREEN + "Updated!" + RESET);
                    } else {
                        System.out.println("Task not found.");
                    }
                    promptClearScreen(scanner);
                    break;

                case "L":
                    System.out.println(CYAN + "-- Tasks --" + RESET);
                    for (Task t : manager.listTasks()) {
                        System.out.println(t);
                    }
                    promptClearScreen(scanner);
                    break;

                case "Q":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
                    promptClearScreen(scanner);
            }
        }
    }
}
