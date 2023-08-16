package todolist;
public class Task {

    private String description;
    private int priority;
    private boolean completed;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    // Getters and setters
}