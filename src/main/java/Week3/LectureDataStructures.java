package Week3;

import java.util.*;
import java.util.stream.Collectors;

public class LectureDataStructures {
    private List<LectureUser> users = new ArrayList<>();

    public LectureDataStructures() {
        users = Arrays.asList(
                new LectureUser("Becir", LectureGender.MALE, 29),
                new LectureUser("Fatima", LectureGender.FEMALE, 105),
                new LectureUser("Adnan", LectureGender.MALE, 35)
        );
    }
    public List<LectureUser> getAll() {

        return this.users;
    }
    public Optional<LectureUser> getByName(String name) {
        return users
                .stream()
                .filter(user -> {
                    return user.getName().equals(name);
                }).findFirst();
    }
    public List<LectureUser> findAgeGreaterThan(int age) {
        return users
                .stream()
                .filter(user -> age >= user.getAge())
                .toList();
    }
    public List<Integer> multiplyAge() {
        return users
                .stream()
                .map(user -> user.getAge() * 2)
                .collect(Collectors.toList());
    }
    public void multiplyAgeAndPrint() {
        users
                .stream()
                .map(user -> user.getAge() * 2)
                .forEach(y -> {
                    System.out.println(y);
                });
    }
    public List<LectureUser> multiplyAgeRetuenUserAndPrint() {
        return users
                .stream()
                .peek(y -> {
                    y.setAge(y.getAge() * 2);
                }).collect(Collectors.toList());
    }
    public void getByGender(LectureGender gender){
        users = users.stream()
                .filter(user -> user.getGender().equals(gender))
                .collect(Collectors.toList());
        for (LectureUser u : users){
            System.out.println(u.getName());
        }
    }

    // ********** MAIN **********

    public static void main(String[] args) {
        LectureDataStructures ds = new LectureDataStructures();

        System.out.println("Get all users:");
        List<LectureUser> allUsers = ds.getAll();
        for (LectureUser u : allUsers){
            System.out.println(u.getName() + "  " + u.getGender() + "  " + u.getAge());
        }

        System.out.println("\nGet by name:");
        Optional<LectureUser> optioanlUser = ds.getByName("Adnan");
        if(optioanlUser.isPresent()) {
            LectureUser user = optioanlUser.get();
            System.out.println(user.getName());
        } else {
            System.out.println("User not found");
        }

        System.out.println("\nFind age greater than:");
        List<LectureUser> users = ds.findAgeGreaterThan(100);
        for (LectureUser user : users){
            System.out.println(user.getName() + "  " + user.getAge());
        }

        System.out.println("\nMultiply age:");
        System.out.println(ds.multiplyAge());

        System.out.println("\nMultiply age and print:");
        ds.multiplyAgeAndPrint();

        System.out.println("\nMultiply age return user and print:");
        users  = ds.multiplyAgeRetuenUserAndPrint();
        for (LectureUser user : users ){
            System.out.println(user.getName() + "  " + user.getAge());
        }

        System.out.println("\nGet by gender:");
        ds.getByGender(LectureGender.MALE);
    }
}
