package Week4.People;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int credits;
    private int studentId;
    private ArrayList<Integer> grade = new ArrayList<>();

    public Student (String name, String address) {
        super(name, address);
        this.credits = 0;
    }

    public int getCredits() {
        return this.credits;
    }
    public int getStudentId() {
        return this.studentId;
    }
    public List<Integer> getGrade() {
        return this.grade;
    }
    public void setCredits(int newCredits){
        this.credits = newCredits;
    }
    public void setStudentId(int newStudentId) {
        this.studentId = newStudentId;
    }
    public void setGrade (List<Integer> grade) {
    }
    public void study(){
        this.credits++;
    }
    public void addGrade(int grade){
        if(grade >= 1 && grade <= 10) {
            this.grade.add(grade);
        }
    }
    public void printGrades() {
        for (int g : grade) {
            System.out.println(g);
        }
    }
    @Override
    public String toString() {
        return getName() + "\n" + getAddress() + "\n" + String.valueOf(getCredits());
    }
}
