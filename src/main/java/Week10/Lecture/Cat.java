package Week10.Lecture;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cat {
    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void thisIsPublicStaticMethod() {
        System.out.println("I'm public and static");
    }
    public void meow() {
        System.out.println("meow");
    }
    public void saySomething(String something) {
        System.out.println("I said something ".concat(something));
    }
    public void heyThisIsPrivate() {
        System.out.println("How did you call this?");
    }
}
class RunCat {
    public static void main(String[] args) {
        Cat myCat = new Cat("Cicko", 12);

        Field[] catFields = myCat.getClass().getDeclaredFields();

        for (Field f : catFields) {
            System.out.println(f.getName());
        }

        //myCat.name = "Cicko Micko";  <- compile time error "'name' has private access"

        for (Field field : catFields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                try {
                    field.set(myCat, "Micko Cicko");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Use reflection on methods

        Method [] catMethods = myCat.getClass().getDeclaredMethods();

        for (Method method : catMethods) {
            try{
                System.out.println(method.getName());
                if (method.getName().equals("meow")) {
                    method.invoke(myCat);
                } else if (method.getName().equals("saySomething")) {
                    method.invoke(myCat, "Aw, Aw, Aw");
                } else if (method.getName().equals("heyThisIsPrivate")) {
                    method.setAccessible(true);
                    method.invoke(myCat);
                } else if (method.getName().equals("thisIsPublicStaticMethod")) {
                    method.invoke(null); //static method doesn't need an object
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
