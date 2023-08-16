package todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class TaskManager {
	private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        System.out.println("Task removed successfully.");
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks); // Return a copy of the tasks list
    }

    public void showTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println(i + 1 + ". " + task.getDescription() + " (Priority: " + task.getPriority() + ")");
        }
    }
    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }
    public void editTask(Task task, String newDescription, int newPriority) {
        task.setDescription(newDescription);
        task.setPriority(newPriority);
        System.out.println("Task edited successfully.");
    }

    public void markTaskAsCompleted(Task task) {
        task.setCompleted(true);
        System.out.println("Task marked as completed.");
    }
}