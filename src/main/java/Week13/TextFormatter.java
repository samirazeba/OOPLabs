package Week13;

interface TextFormatter {
    String formatText(String text);
}
class UpperCaseFormatter implements TextFormatter {
    @Override
    public String formatText (String text) {
        return text.toUpperCase();
    }
}
class LowerCaseFormatter implements TextFormatter {
    @Override
    public String formatText (String text) {

        return text.toLowerCase();
    }
}
class CamelCaseFormatter implements TextFormatter {
    @Override
    public String formatText (String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        String result = "";
        boolean newText = true;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                result += newText ? Character.toUpperCase(c) : Character.toLowerCase(c);
                newText = false;
            } else {
                newText = true;
            }
        }
        return result;
    }
}
class TextEditor {
    private TextFormatter textFormatter;

    public void setFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }
    public String formatText (String text) {
        if (textFormatter == null) {
            throw new IllegalStateException("Text formatter is not set.");
        }
        return textFormatter.formatText(text);
    }
}
class TextFormatterMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.setFormatter(new UpperCaseFormatter());
        System.out.println("Uppercace: " + editor.formatText("word"));

        editor.setFormatter(new LowerCaseFormatter());
        System.out.println("Lowercase: " + editor.formatText("wORd"));

        editor.setFormatter(new CamelCaseFormatter());
        System.out.println("Camelcase: " + editor.formatText("hello world"));
    }
}
