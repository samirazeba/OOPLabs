package MidtermPreparation.Week6.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Dictionary {
    HashMap<String, String> dict = new HashMap<>();

    public Dictionary() {}

    public String translate (String word) {
        if (dict.containsKey(word)) {
            return dict.get(word);
        } else {
            return null;
        }
    }
    public void add(String word, String translation) {
        dict.put(word, translation);
    }
    public int amountOfWords() {
        return dict.size();
    }
    public ArrayList<String> translationList () {
        ArrayList<String> translationList = new ArrayList<>();
        for (String key : dict.keySet()) {
            translationList.add(key + " = " + dict.get(key));
        }
        return translationList;
    }
}
class TextUserInterface {
    Scanner reader;
    Dictionary dictionary;
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statement:\n add - adds a word pair to the dictionary");
        System.out.println(" translate - asks a word and prints its translation");
        System.out.println(" quit - quit the text user interface");
        while (true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }
            else if (command.equals("add")) {
                System.out.print("In Finnish: ");
                String inFinnish = reader.next();
                System.out.print("Translation: ");
                String translatedWord = reader.next();
                this.dictionary.add(inFinnish, translatedWord);
                System.out.println();
            } else if (command.equals("translate")) {
                System.out.print("Give a word: ");
                String word = reader.next();
                String translation = this.dictionary.translate(word);
                System.out.println("Translation: " + translation + "\n");
                System.out.println();
            }
        }
    }
}
class RunDictionary {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        /*dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");


        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("porkkana")); */

        /*dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        System.out.println(dictionary.amountOfWords());


        dictionary.add("cembalo", "harpsichord");
        System.out.println(dictionary.amountOfWords()); */

       /* dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");


        ArrayList<String> translations = dictionary.translationList();
        for(String translation: translations) {
            System.out.println(translation);
        } */

        Scanner reader = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(reader, dictionary);
        ui.start();

    }
}
