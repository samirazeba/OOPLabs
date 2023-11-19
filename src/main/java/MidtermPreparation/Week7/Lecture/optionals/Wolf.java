package MidtermPreparation.Week7.Lecture.optionals;

import java.util.Optional;

record Wolf(String name, int age) {
}
class RunWolf {
    public static void main(String[] args) throws ClassNotFoundException{
        Wolf wolf = getWolfByName("Strasni");

        if (wolf != null) {
            System.out.println(wolf.age());
        } else {
            System.out.println("No wulf");
        }
        Optional<Wolf> wolfOptional = getWolfByNameOptional("Strasni");
        if(wolfOptional.isPresent())
            System.out.println(wolfOptional.get().age());
        else if (wolfOptional.isEmpty())
            System.out.println("NO VALUE IN IT");

        System.out.println(wolfOptional.orElse(new Wolf("novi nuk", 11)));

        System.out.println(wolfOptional.orElseGet(() -> null));

        wolfOptional.orElseThrow(ClassNotFoundException::new);

        wolfOptional.map(Wolf::age)
                .orElse(0);
    }
    public static Wolf getWolfByName(String name) {
        return null;
    }
    public static Optional<Wolf> getWolfByNameOptional(String name) {
        return Optional.ofNullable(new Wolf("Strasni vuk", 12));
    }
}
