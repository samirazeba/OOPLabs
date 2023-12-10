package Week10.StudentGradeAnalysisSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradeAnalyzer {
    private List<Double> grades;

    public GradeAnalyzer(List<Double> grades) {
        this.grades = grades;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public double calculateAverageGrade() {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        } double average = sum / grades.size();

        return average;
    }

}
