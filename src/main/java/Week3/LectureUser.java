package Week3;

public class LectureUser {
    private String name;
    private LectureGender gender;
    private int age;

    public LectureUser(String name, LectureGender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LectureGender getGender() {
        return gender;
    }

    public void setGender(LectureGender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ********* MAIN *********

    public static void main(String[] args) {
        LectureUser u = new LectureUser("Samira", LectureGender.FEMALE, 21);
        System.out.println(u.getName());
        System.out.println(u.getGender());
        System.out.println(u.getAge());

        u.setName("Amar");
        u.setGender(LectureGender.MALE);
        u.setAge(16);

        System.out.println("\nAfter modification:\n");

        System.out.println(u.getName());
        System.out.println(u.getGender());
        System.out.println(u.getAge());
    }
}
