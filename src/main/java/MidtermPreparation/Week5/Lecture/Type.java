package MidtermPreparation.Week5.Lecture;

enum Type {
    ADDITION, SUBTRACTION, MULTIPLICATION
}
class Operation {
    private Type type;
    private String name;

    public String whatDoYouDo(String whatIDo) {
        return whatIDo;
    }
    public String whatDoYouDo() {
        return "I do operations";
    }

    public Operation(Type type) {
        this.type = type;
    }

    public Operation(String name) {
        this.name = name;
    }

    public Operation(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Addition extends Operation {
    public Addition(Type type, String name) {
        super(type, name);
    }

    @Override
    public String whatDoYouDo() {
        return "I do additon";
    }
}
class Multiplication extends Operation {
    public String whatDoYouDo() {
        return "Multiply me";
    }
    public Multiplication (Type type) {
        super(type);
    }
}
class RunOperation {
    public static void main(String[] args) {
        Operation o = new Operation(Type.ADDITION, "My Operation Special");
        Addition a = new Addition(Type.ADDITION, "My Operation Special");
        Multiplication m = new Multiplication(Type.MULTIPLICATION);

        printTheOperation(m);
        printTheOperation(o);
        printTheOperation(a);

    }
    public static void printTheOperation(Operation o) {
        if (o instanceof Multiplication) {
            Multiplication m = (Multiplication) o;
            System.out.println(m.whatDoYouDo());
        }
    }
}