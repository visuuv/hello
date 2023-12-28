// Import necessary packages
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class to represent a single task
class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getters and setters for task properties
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

// ToDoList class to manage the list of tasks
class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    // Add a new task to the list
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Edit an existing task
    public void editTask(int index, String title, String description) {
        Task task = tasks.get(index);
        task.setTitle(title);
        task.setDescription(description);
    }

    // Mark a task as completed
    public void markTaskAsCompleted(int index) {
        Task task = tasks.get(index);
        task.setCompleted(true);
    }

    // Delete a task from the list
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    // Display the list of tasks
    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getTitle() + " - " + (task.isCompleted() ? "Completed" : "Active"));
        }
    }
}

// Main class to run the to-do list app
public class ToDoListApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Display Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    Task task = new Task(title, description);
                    toDoList.addTask(task);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    System.out.print("Enter task index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new task title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new task description: ");
                    String newDescription = scanner.nextLine();
                    toDoList.editTask(index - 1, newTitle, newDescription);
                    System.out.println("Task edited successfully!");
                    break;
                case 3:
                    System.out.print("Enter task index: ");
                    int completedIndex = scanner.nextInt();
                    scanner.nextLine();
                    toDoList.markTaskAsCompleted(completedIndex - 1);
                    System.out.println("Task marked as completed!");
                    break;
                case 4:
                    System.out.print("Enter task index: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();
                    toDoList.deleteTask(deleteIndex - 1);
                    System.out.println("Task deleted successfully!");
                    break;
                case 5:
                    toDoList.displayTasks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
