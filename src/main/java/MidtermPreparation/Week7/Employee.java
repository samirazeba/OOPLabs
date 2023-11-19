package MidtermPreparation.Week7;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

record Employee(int id, String name, double salary) {
}
class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem(List<Employee> employees) {
        this.employees = employees;
    }
    public EmployeeManagementSystem(){}

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> filterEmployeesBySalary (List<Employee> employees, double minSalary) {
        return employees.stream()
                .filter(employee -> employee.salary() >= minSalary)
                .collect(Collectors.toList());
    }
    public double calculateTotalSalary (List<Employee> employees) {
        //double totalSalary = 0;
        return employees.stream()
                .mapToDouble(employee -> employee.salary())
                .sum();
    }
    public void displayEmployeeDetails (List<Employee> employees) {
        employees.forEach(employee -> System.out.println(employee.toString()));
    }

}
class RunEmployee {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        List<Employee> employees = List.of(
                new Employee(1, "Samira", 50000.0),
                new Employee(2, "Emina", 60000.0),
                new Employee(3, "Sadzida", 7500.0)
        );
        List<Employee> filteredEmployees = ems.filterEmployeesBySalary(employees, 50000.0);
        System.out.println("Employees with minimum salary:");
        ems.displayEmployeeDetails(filteredEmployees);

        double totalSalary = ems.calculateTotalSalary(employees);
        System.out.println("Total salary: " + totalSalary);

        System.out.println("Employee details;");
        ems.displayEmployeeDetails(employees);
    }
}
