package todolist;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class ToDoApp {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        
        TaskManager taskManager = new TaskManager();

        while (true) {
        	System.out.println("Welcome to ToDoApp");
            System.out.println("1. User Registration\n2 .User Login\n3. Quit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("ENTER USERNAME: ");
                String username = scanner.nextLine();
                System.out.print("ENTER PASSWORD: ");
                String password = scanner.nextLine();
                userManager.registerUser(username, password);
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                boolean loggedIn = userManager.loginUser(username, password);
                if (loggedIn) {
                    // Task management menu
                    while (true) {
                        System.out.println("1. Add Task\n2. Remove Task\n3. Show Tasks Based On Priority\n4. Mark Task as Completed\n5. Show completed tasks\n6. Edit Task\n7. Logout");
                        int taskChoice = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        if (taskChoice == 1) {
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine();
                            System.out.print("Enter task priority: ");
                            int priority = scanner.nextInt();
                            taskManager.addTask(new Task(description, priority));
                        } else if (taskChoice == 2) {
                            // Implement task removal logic
                            System.out.println("Current tasks:");
                            taskManager.showTasks();

                            if (!taskManager.getAllTasks().isEmpty()) {
                                System.out.print("Enter the task number to remove: ");
                                int taskNumber = scanner.nextInt();
                                scanner.nextLine();  // Consume newline

                                if (taskNumber > 0 && taskNumber <= taskManager.getAllTasks().size()) {
                                    Task taskToRemove = taskManager.getAllTasks().get(taskNumber - 1);
                                    taskManager.removeTask(taskToRemove);
                                } else {
                                    System.out.println("Invalid task number.");
                                }
                            } else {
                                System.out.println("No tasks to remove.");
                            }
                        } else if (taskChoice == 3) {
                            List<Task> allTasks = taskManager.getAllTasks();
                            if (!allTasks.isEmpty()) {
                                System.out.println("All tasks (sorted by priority in ascending order):");
                                Collections.sort(allTasks, Comparator.comparingInt(Task::getPriority)); // Sort tasks by priority
                                int taskNumber = 1;
                                for (Task task : allTasks) {
                                    System.out.println(taskNumber + ". " + task.getDescription() + " (Priority: " + task.getPriority() + ")");
                                    taskNumber++;
                                }
                            } else {
                                System.out.println("No tasks available.");
                            }
                        } else if (taskChoice == 4) {
                            // Implement marking task as completed logic
                            System.out.println("Current tasks:");
                            taskManager.showTasks();

                            if (!taskManager.getAllTasks().isEmpty()) {
                                System.out.print("Enter the task number to mark as completed: ");
                                int taskNumber = scanner.nextInt();
                                scanner.nextLine();  // Consume newline

                                if (taskNumber > 0 && taskNumber <= taskManager.getAllTasks().size()) {
                                    Task taskToMarkCompleted = taskManager.getAllTasks().get(taskNumber - 1);
                                    taskManager.markTaskAsCompleted(taskToMarkCompleted);
                                } else {
                                    System.out.println("Invalid task number.");
                                }
                            } else {
                                System.out.println("No tasks to mark as completed.");
                            }
                        }
                        else if (taskChoice == 5) {
                            List<Task> completedTasks = taskManager.getCompletedTasks();
                            if (!completedTasks.isEmpty()) {
                                System.out.println("Completed tasks:");
                                int taskNumber = 1;
                                for (Task task : completedTasks) {
                                    System.out.println(taskNumber + ". " + task.getDescription() + " (Priority: " + task.getPriority() + ")");
                                    taskNumber++;
                                }
                            } else {
                                System.out.println("No completed tasks.");
                            }
                        }else if (taskChoice == 6) {
                            System.out.println("Current tasks:");
                            taskManager.showTasks();

                            if (!taskManager.getAllTasks().isEmpty()) {
                                System.out.print("Enter the task number to edit: ");
                                int taskNumber = scanner.nextInt();
                                scanner.nextLine();  // Consume newline

                                if (taskNumber > 0 && taskNumber <= taskManager.getAllTasks().size()) {
                                    Task taskToEdit = taskManager.getAllTasks().get(taskNumber - 1);
                                    System.out.print("Enter new description: ");
                                    String newDescription = scanner.nextLine();
                                    System.out.print("Enter new priority: ");
                                    int newPriority = scanner.nextInt();
                                    taskManager.editTask(taskToEdit, newDescription, newPriority);
                                } else {
                                    System.out.println("Invalid task number.");
                                }
                            } else {
                                System.out.println("No tasks to edit.");
                            }
                        }
                        else if (taskChoice == 7) {
                            System.out.println("Logged out.");
                            break;
                        }
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting the application.");
                break;
            }
        }
    }
}
