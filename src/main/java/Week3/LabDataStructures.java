package Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LabDataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public LabDataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1, "Push lab code to the github", Status.TO_DO),
                new TaskItem(2, "Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3, "Go over tasks from lab2", Status.COMPLETED),
                new TaskItem(4, "Night out", Status.CANCELLED)
        );
    }
    public List<TaskItem> getAll() {
        return this.tasks;
    }
    public void getByStatus (Status status) {
        List<TaskItem> filteredTasks = tasks.stream()
                .filter(task -> task.getTaskStatus().equals(status))
                .collect(Collectors.toList());
        for (TaskItem taskItem : filteredTasks) {
            System.out.println(taskItem.getTaskId() + "  " + taskItem.getTaskDescription() + "  " + taskItem.getTaskStatus());
        }
    }
    public List<TaskItem> idGreaterThanTwo() {
        return tasks
                .stream()
                .filter(task -> task.getTaskId() >= 2)
                .collect(Collectors.toList());
    }
    public void printTaskDescription() {
        tasks
                .stream()
                .map(task -> task.getTaskDescription())
                .forEach(y -> {
                    System.out.println(y);;
                });
    }
    // ****** MAIN *******

    public static void main(String[] args) {
        LabDataStructures labDataStructures = new LabDataStructures();
        List<TaskItem> tasks;

        System.out.println("Get all:");
        tasks = labDataStructures.getAll();
        for (TaskItem task : tasks){
            System.out.println(task.getTaskId() + "  " + task.getTaskDescription() + "  " + task.getTaskStatus());
        }

        System.out.println("\nGet by status:");
        labDataStructures.getByStatus(Status.CANCELLED);

        System.out.println("\nId greater than two:");
        tasks = labDataStructures.idGreaterThanTwo();
        for (TaskItem task : tasks){
            System.out.println(task.getTaskId() + "  " + task.getTaskDescription() + "  " + task.getTaskStatus());
        }

        System.out.println("\nPrint task description:");
        labDataStructures.printTaskDescription();
    }
}
