package Week10.StudentGradeAnalysisSystem;

/* In the Start class, instantiate a GradeAnalyzer object with
a list of grades, and then use reflection to access and print
the field names and values of the GradeAnalyzer class.
Iterate through the declared methods and invoke those whose names
start with "calculate" or "print," printing the method names and
their results.
 */


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
        GradeAnalyzer analyzer = new GradeAnalyzer(
                Arrays.asList(7.0, 7.0, 10.0, 6.0, 7.0, 7.0)
        ) ;

        Field[] analyzerFields = analyzer.getClass().getDeclaredFields();
        for (Field field : analyzerFields) {
            field.setAccessible(true);
            try{
                System.out.println(field.getName() + ": " + field.get(analyzer));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Invoking methods: ");
        Method[] analyzerMethods = analyzer.getClass().getDeclaredMethods();
        for (Method method : analyzerMethods) {
                if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                    method.setAccessible(true);
                try {
                    Object result = method.invoke(analyzer);
                    System.out.println(method.getName() + ": " + result);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        Student student = new Student("Samira", 1234, Arrays.asList(7, 7, 10, 6, 7, 7));
        Method[] studentMethods = student.getClass().getDeclaredMethods();
        for (Method method : studentMethods) {
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                method.setAccessible(true);
                try {
                    System.out.println(method.getName() + ": " + method.invoke(student));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}