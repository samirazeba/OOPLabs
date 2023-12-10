package Week10.StudentGradeAnalysisSystem;

import java.util.List;

public class Student {
    private String name;
    private int id;
    private List<Integer> grades;

    public Student(String name, int id, List<Integer> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public String printInfo() {
        return ("Name: " + this.name + "\nID: " + this.id + "\nGrades: " + this.grades);
    }
}
