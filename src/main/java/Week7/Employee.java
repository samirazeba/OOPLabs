package Week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

record Employee (int id, String name, double salary) {
}
class EmployeeManagementSystem {
    protected List<Employee> employees;

    public EmployeeManagementSystem (List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

   /*public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }*/

    public List<Employee> filterEmployeeBySalary (List<Employee> employees, int minSalary) {
        employees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.salary() >= (double) minSalary) {
                employees.add(employee);
            }
        }
        return employees;
    }
    public int calculateTotalSalary(List<Employee> employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.salary();
        }
        return sum;
    }
    public void displayEmployeeDetails(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("Id - " + employee.id() + "; Name - " + employee.name() + "; Salary - " + employee.salary());
        }
    }

    //Using Optionals

    public List<Employee> filterEmployeeBySalaryOptional(List<Employee> employees, double minSalary) {
        return employees.stream()
                .filter(employee -> employee.salary() >= minSalary)
                .collect(Collectors.toList());
    }
    public double calculateTotalSalaryOptional(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(employee -> employee.salary())
                .sum();
    }
    public void displayEmployeeDetailsOptional(List<Employee> employees) {
        employees.forEach(employee -> System.out.println(employee.toString()));
    }
}
class StartEmployee {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Samira", 2541.2),
                new Employee(2, "Emina", 1235.8),
                new Employee(3, "Sadzida", 5647.0)
        );
        EmployeeManagementSystem ems = new EmployeeManagementSystem(employees);

        System.out.println("filterBySalary: " + ems.filterEmployeeBySalary(employees, 2500));
        System.out.println("Employees with minimum salary: ");
        ems.displayEmployeeDetails(employees);

        System.out.println("calculateTotalSalary: " + ems.calculateTotalSalary(employees));

        System.out.println("displayEmployeeDetails: ");
        ems.displayEmployeeDetails(employees);

    }

}
class StartUsingOptionals {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Samira", 2541.2),
                new Employee(2, "Emina", 1235.8),
                new Employee(3, "Sadzida", 5647.0)
        );
        EmployeeManagementSystem ems = new EmployeeManagementSystem(employees);

        System.out.println("Using Optionals\nfilterBySalary: " + ems.filterEmployeeBySalaryOptional(employees, 2500));
        System.out.println("Employees with minimum salary: ");
        ems.displayEmployeeDetailsOptional(employees);

        System.out.println("calculateTotalSalary: " + ems.calculateTotalSalaryOptional(employees));

        System.out.println("displayEmployeeDetails: ");
        ems.displayEmployeeDetailsOptional(employees);
    }
}