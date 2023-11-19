package MidtermPreparation.Week6.HashMaps;

import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<>();
        names.put("matti", "mage");
        names.put("mikael", "mixu");
        names.put("arto", "arppa");

        System.out.println("mikael's nickname: " + names.get("mikael"));
    }
}
