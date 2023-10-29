package Week4.Lecture;

class Component {
    private String id;
    private String producer;
    private String description;

    public Component (String id, String producer, String description) {
        this.id = id;
        this.producer = producer;
        this.description = description;
    }

    public String getId() {
        return this.id;
    }
    public String getProducer() {
        return this.producer;
    }
    public String getDescription() {
        return this.description;
    }
    @Override
    public String toString() {
        return super.toString() + "\nAnd my personal message again!";
    }
}
class Motor extends Component {
    private String motorType;

    public Motor(String motorType, String id, String producer, String description) {
        super (id, producer, description);
        this.motorType = motorType;
    }

    public String getMotorType() {
        return this.motorType;
    }
}
class ComponentMain {
    public static void main(String[] args) {
        Component component = new Component("hz", "volkswagen", "VW GOLF 1L 86-91");
        Motor motor = new Motor("combustion engine", "hz", "volkswagen", "VW GOLF 1L 86-91");
        System.out.println(motor.getMotorType());
        System.out.println(motor.getProducer());
        System.out.println("\n" + component.toString());
    }
}
