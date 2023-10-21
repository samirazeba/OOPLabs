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
        System.out.println(ds.getAll());
        System.out.println(ds.getByName("Adnan"));
        System.out.println(ds.findAgeGreaterThan(29));
        System.out.println(ds.multiplyAge());
        ds.multiplyAgeAndPrint();
        System.out.println(ds.multiplyAgeRetuenUserAndPrint());
        ds.getByGender(LectureGender.MALE);
    }
}
