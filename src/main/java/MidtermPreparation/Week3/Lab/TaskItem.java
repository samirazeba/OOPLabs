package MidtermPreparation.Week3.Lab;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum Status {
    TO_DO, IN_PROGRESS, COMPLETED, CANCELLED
}
class TaskItem {
    private int taskId;
    private String taskDescription;
    private Status taskStatus;

    public TaskItem(int taskId, String taskDescription, Status taskStatus) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }
}
class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem (1, "Push lab code to the github", Status.TO_DO),
                new TaskItem (2, "Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem (3, "Go over tasks from lab 2", Status.COMPLETED),
                new TaskItem (4, "Night out", Status.CANCELLED)
        );
    }
    public List<TaskItem> getAllObjects() {
        return this.tasks;
    }
    public void getByStatus(Status status) {
        List<TaskItem> filteredByStatus = tasks.stream()
                .filter(task -> task.getTaskStatus().equals(status))
                .collect(Collectors.toList());
        for (TaskItem task : filteredByStatus) {
            System.out.println(task.getTaskId() + ", " +
                    task.getTaskDescription() + ", " +
                    task.getTaskStatus());
        }
    }
    public void idGreaterThanTwo(List<TaskItem> tasks) {
        List<TaskItem> idGreaterThanTwo = tasks.stream()
                .filter(task -> task.getTaskId() >= 2)
                .collect(Collectors.toList());
        for (TaskItem task : idGreaterThanTwo) {
            System.out.println(task.getTaskId() + ", " +
                    task.getTaskDescription() + ", " +
                    task.getTaskStatus());
        }
    }
    public void printDescription(List<TaskItem> tasks) {
        tasks.stream()
                .map(task -> task.getTaskDescription())
                .forEach(y -> {
                    System.out.println(y);
                });
    }

}
class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "OOPlab3**";

    private Connection connection = null;

    public DbConnect () {
        try {
            connection =
                    DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
class Main {
    public static void main(String[] args) {
        DataStructures ds = new DataStructures();
        List<TaskItem> tasks;

        tasks = ds.getAllObjects();
        for (TaskItem task : tasks) {
            System.out.println(task.getTaskId()
            + ", " + task.getTaskDescription()
            + ", " + task.getTaskStatus());
        }

        //Get by status
        System.out.println();
        ds.getByStatus(Status.CANCELLED);

        //ID greater or equal to 2
        System.out.println();
        ds.idGreaterThanTwo(tasks);

        //Print task descripttion
        System.out.println();
        ds.printDescription(tasks);
    }

}
