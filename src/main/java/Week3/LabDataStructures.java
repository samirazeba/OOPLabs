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
        System.out.println("Get all:");
        return this.tasks;
    }
    public void getByStatus (Status status) {
        System.out.println("\nGet by status:");
        List<TaskItem> filteredTasks = tasks.stream()
                .filter(task -> task.getTaskStatus().equals(status))
                .collect(Collectors.toList());
        for (TaskItem taskItem : filteredTasks) {
            System.out.println(taskItem.getTaskId() + "  " + taskItem.getTaskDescription() + "  " + taskItem.getTaskStatus());
        }
    }
    public List<TaskItem> idGreaterThanTwo() {
        System.out.println("\nTask ID greater than or equal to 2:");
        return tasks
                .stream()
                .filter(task -> task.getTaskId() >= 2)
                .collect(Collectors.toList());
    }
    public void printTaskDescription() {
        System.out.println("\nPrint task description:");
        tasks
                .stream()
                .map(task -> task.getTaskDescription())
                .forEach(y -> {
                    System.out.println(y);;
                });
    }

    public static void main(String[] args) {
        LabDataStructures labDataStructures = new LabDataStructures();
        System.out.println(labDataStructures.getAll());
        labDataStructures.getByStatus(Status.CANCELLED);

        List<TaskItem> filteredTasks = labDataStructures.idGreaterThanTwo();
        for (TaskItem taskItem : filteredTasks){
            System.out.println(taskItem);
        }
        labDataStructures.printTaskDescription();
    }
}
