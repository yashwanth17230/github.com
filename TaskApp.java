import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Task {
    private String name;
    private boolean completed;
    private Date date;

    public Task(String name, Date date) {
        this.name = name;
        this.completed = false;
        this.date = date;
    }

    public Task(String name, boolean completed, Date date) {
        this.name = name;
        this.completed = completed;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return name + " - " + (completed ? "Completed" : "Not Completed") + " - " + dateFormat.format(date);
    }
}

class TaskManager {
    private List<Task> tasks;
    private String fileName;

    public TaskManager(String fileName) {
        this.fileName = fileName;
        tasks = loadTasksFromFile();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
            saveTasksToFile();
        }
    }

    public void removeCompletedTasks() {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.isCompleted()) {
                iterator.remove();
            }
        }
        saveTasksToFile();
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private List<Task> loadTasksFromFile() {
        List<Task> loadedTasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                boolean completed = Boolean.parseBoolean(parts[1]);
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(parts[2]);
                loadedTasks.add(new Task(name, completed, date));
            }
        } catch (Exception e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
        return loadedTasks;
    }

    private void saveTasksToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                writer.println(task.getName() + "," + task.isCompleted() + "," + dateFormat.format(task.getDate()));
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }
}

public class TaskApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager("tasks.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task(s)");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Remove Completed Tasks");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task name(s) separated by commas: ");
                    String taskNamesInput = scanner.nextLine();
                    String[] taskNames = taskNamesInput.split(",");
                    for (String taskName : taskNames) {
                        taskName = taskName.trim();
                        if (!taskName.isEmpty()) {
                            Task newTask = new Task(taskName, new Date());
                            taskManager.addTask(newTask);
                            System.out.println("Task added: " + newTask);
                        }
                    }
                    break;

                case 2:
                    taskManager.displayTasks();
                    System.out.print("Enter the task number to mark as completed: ");
                    int taskIndex = scanner.nextInt() - 1;
                    taskManager.markTaskAsCompleted(taskIndex);
                    System.out.println("Task marked as completed.");
                    break;

                case 3:
                    taskManager.removeCompletedTasks();
                    System.out.println("Completed tasks removed.");
                    break;

                case 4:
                    taskManager.displayTasks();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
