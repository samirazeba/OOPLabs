package Week11.StudentManagementSystem;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentSystemTestTest {

    private static final String filename = "C:\\Users\\PC\\Downloads\\students.csv";
    private static final String emptyFile = "C:\\Users\\PC\\Downloads\\empty.csv";

    @Test
    public void testidStudentisPresent() {
        StudentSystem studentSystem = new StudentSystem(filename);
        List<Student> students = studentSystem.getAllStudents();
        assertFalse(students.isEmpty(), "There should be at least one student in the file");
    }

    @Test
    public void testStudentWithId100() throws StudentNotFountException {
        StudentSystem studentSystem = new StudentSystem(filename);
        try {
            assertFalse(studentSystem.getStudentById(100).isPresent(),
                    "Student with ID 100 is present");
        } catch (StudentNotFountException e) {
            throw new StudentNotFountException("Student could not be found");
        }

    }

    @Test
    public void testStudentNull() {
        StudentSystem studentSystem = new StudentSystem(filename);
        List<Student> students = studentSystem.getAllStudents();
        for (Student student : students) {
            assertNotNull(student, "Student shouldn't be null");
        }
    }

    @Test
    public void testHighestGPAStudent() {
        StudentSystem studentSystem = new StudentSystem(filename);
        assertNotNull(studentSystem.getHighestGPAStudent(),
                "There should be a studentd with the highest GPA");

    }

    @Test
    public void testExceptionForEmptyStudentList() {
        StudentSystem studentSystem = new StudentSystem(emptyFile);
        try {
            studentSystem.getAllStudents();
        } catch (EmptyStudentListException e) {
            assertEquals(e.getMessage(), "List of students is empty.");
        }
    }

    @Test
    public void testNamesArray () {
        StudentSystem studentSystem = new StudentSystem(filename);
        List<String> actuealNames = studentSystem.getAllStudents().stream()
                .map(student -> student.name())
                .limit(5)
                .collect(Collectors.toList());
        List<String> expectedName = List.of("Camila Wood",
                "Alexander Thompson",
                "Liam Taylor",
                "Evelyn Jenkins",
                "Michael Jackson");
        assertEquals(actuealNames, expectedName, "First 5 names match.");
    }

    @Test
    public void testSize() {
        StudentSystem studentSystem = new StudentSystem(filename);
        assertTrue(studentSystem.getAllStudents().size() == 70, "The file has 70 students");
    }

    @Test
    public void testLargestName() {
        StudentSystem studentSystem = new StudentSystem(filename);
        assertTrue(!(studentSystem.getLongestNameStudent().name().equals("Ava White")), "Ava White is not the longest name in the file.");

        //assertEquals("Ava White", studentSystem.getLongestNameStudent(), "Two names are equal");
    }

    @Test
    public void testStudents() {
        StudentSystem studentSystem = new StudentSystem(filename);
        assertNotSame(studentSystem.getHighestGPAStudent(), studentSystem.getLongestNameStudent(), "Student with the highest GPA and the longest name are not the same.");
    }

    @Test
    public void testSameStudent() throws StudentNotFountException {
        StudentSystem studentSystem = new StudentSystem(filename);
        try {
            assertNotSame(studentSystem.getHighestGPAStudent(), studentSystem.getStudentById(12), "Student are not the same.");
        } catch (StudentNotFountException e) {
            throw new StudentNotFountException("Students should not be the same.");
        }
    }


}