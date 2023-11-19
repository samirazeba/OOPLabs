package MidtermPreparation.Week6.HashMaps;

import java.util.HashMap;

class PromissoryNote {

    private HashMap<String, Double> loans = new HashMap<>();

    public PromissoryNote() {}

    public void setLoan(String toWhom, double value) {
        this.loans.put(toWhom, value);
    }
    public double howMuchIsTheDebt(String whose) {
        if (loans.containsKey(whose)) {
            return loans.get(whose);
        }
        return 0;
    }
}
class RunPromissoryNote {
    public static void main(String[] args) {
        PromissoryNote mattisNote = new PromissoryNote();

        mattisNote.setLoan("Arto", 51.5);
        //mattisNote.setLoan("Mikael", 30);
        mattisNote.setLoan("Arto", 10.5);


        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        //System.out.println(mattisNote.howMuchIsTheDebt("Joel"));

    }
}
