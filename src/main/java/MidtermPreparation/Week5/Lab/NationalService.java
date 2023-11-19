package MidtermPreparation.Week5.Lab;

interface NationalService {
    int getDaysLeft();
    void work();
}
class CivilService implements NationalService {
    private int daysLeft;

    public CivilService () {
        this.daysLeft = 362;
    }

    @Override
    public int getDaysLeft() {
        return daysLeft;
    }

    @Override
    public void work() {
        this.daysLeft--;
    }
}

class MilitaryService implements NationalService {
    private int daysLeft;

    public MilitaryService (int daysLeft) {
        this.daysLeft = daysLeft;
    }

    @Override
    public int getDaysLeft() {
        return daysLeft;
    }

    @Override
    public void work() {
        this.daysLeft--;
    }
}

class RunServices {

    public static void main(String[] args) {
        CivilService cs = new CivilService();
        MilitaryService ms = new MilitaryService(352);

        System.out.println("Civil service: ");
        System.out.println("Days left: " + cs.getDaysLeft());
        cs.work();
        System.out.println("After work: " + cs.getDaysLeft());

        System.out.println("\nMilitary service:");
        System.out.println("Days left: " + ms.getDaysLeft());
        ms.work();
        System.out.println("After work: " + ms.getDaysLeft());
    }

}
