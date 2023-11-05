package Week5.CivileService;

public class MainTask1 {
    public static void main(String[] args) {

        System.out.println("Civil Service:");
        CivilService cs = new CivilService();
        System.out.println(cs.getDaysLeft());
        cs.work();
        System.out.println(cs.getDaysLeft());

        System.out.println("\nMilitary Service:");
        MilitaryService ms = new MilitaryService(352);
        System.out.println(ms.getDaysLeft());
        ms.work();
        System.out.println(ms.getDaysLeft());

    }
}
