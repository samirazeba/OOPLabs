package Week11.StudentManagementSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String name;
    private String university;
    private String department;
    private double gpa;

    public Student(int id, String name, String university, String department, double gpa) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.gpa = gpa;
    }

    public int id() {
        return this.id;
    }
    public String name() {
        return this.name;
    }
    public String university() {
        return this.university;
    }
    public String department() {
        return this.department;
    }
    public double gpa() {
        return this.gpa;
    }

    @Override
    public String toString() {
        return "ID: " + this.id +
                "\nName: " + this.name +
                "\nUniversity: " + this.university +
                "\nDepartment: " + this.department +
                "\nGPA: " + this.gpa;
    }
}
class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }
}
class StudentNotFountException extends Exception {
    public StudentNotFountException(String message) {
        super(message);
    }
}
class StudentSystem {
    private List<Student> students;

    public static List<Student> readStudents (String filename) throws IOException {
        List<Student> students = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader (filename)
        );
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        for (String line : lines) {
            String[] studentParts = line.split(",");
            Student s = new Student(studentParts[0] == "" ? 0 : Integer.parseInt(studentParts[0]),
                                    studentParts[1], studentParts[2], studentParts[3],
                                    studentParts[4] == "" ? 0 : Double.parseDouble(studentParts[4]));
            students.add(s);
        }
        bufferedReader.close();
        return students;
    }
    public StudentSystem(String filename) {
        try {
            students = readStudents(filename);
        } catch (IOException e) {
            System.out.println("Unable to read the file.");
        }
    }

    public Optional<Student> getStudentById (int id) {
        for (Student student : students) {
            if (student.id() == id) {
                return Optional.of(student);
            }
        } return Optional.empty();
    }

    public Student getHighestGPAStudent () {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }
        Student highestGPA = students.get(0);
        for (Student student : students) {
            if (student.gpa() > highestGPA.gpa()) {
                highestGPA = student;
            }
        } return highestGPA;
    }

    public Student getLongestNameStudent () {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of empty students.");
        }

        Student longestName = students.get(0);
        for (Student student : students) {
            if (student.name().length() > longestName.name().length()) {
                longestName = student;
            }
        } return longestName;
    }
}
class RunStudentSystem {
    public static void main(String[] args) {
        StudentSystem studentSystem = new StudentSystem("students.csv");
        try {
            int id = 10;
            System.out.println("Student with id " + id);
            Optional<Student> studentById = studentSystem.getStudentById(id);
            if (studentById.isPresent()) {
                System.out.println("Student found: " + studentById.get());
            } else {
                throw new StudentNotFountException("Student with ID " + id + " not found.");
            }
        } catch (StudentNotFountException e) {
            System.out.println(e.getMessage());
        }

    }
}

