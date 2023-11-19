package MidtermPreparation.Week4.Lecture;

class Vehicle {
    private double speed;
    private int numOfWheels;

    public Vehicle(double s, int w) {
        this.speed = s;
        this.numOfWheels = w;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(int s) {
        this.speed = s;
    }
    public int getNumOfWheels() {
        return numOfWheels;
    }
    public void setNumOfWheels(int w) {
        this.numOfWheels = w;
    }

    public void produceNoise() {
        System.out.println("GENERIC  VEHICLE NOISE");
    }
}
enum CarBrand {
    AUDI, MERCEDES, BMW
}
class Car extends Vehicle {
    private CarBrand brand;

    public void produceNoise() {
        System.out.println("I'M PRODUCING A CAR NOISE");
    }

    public Car (double speed, int numOfWheels, CarBrand brand) {
        super(speed, numOfWheels);
        this.brand = brand;
    }

    public CarBrand getBrand () {
        return brand;
    }
    public void setBrand(CarBrand b) {
        this.brand = b;
    }
}
enum BicycleType {
    BMX, GT
}
class Bicycle extends Vehicle {
    private BicycleType bicycleType;

    public Bicycle (double s, int w, BicycleType bt) {
        super(s, w);
        this.bicycleType = bt;
    }

    @Override
    public void produceNoise() {
        System.out.println("I'M PRODUCING A BICYCLE NOISE");
    }

    public BicycleType getBicycleType() {
        return bicycleType;
    }
    public void setBicycleType(BicycleType bt) {
        this.bicycleType = bt;
    }
}
class RunVehicle {
    public static void main(String[] args) {
        Car car = new Car(100, 4, CarBrand.AUDI);
        System.out.println(car.getSpeed());
        car.produceNoise();

        Bicycle bicycle = new Bicycle(30, 2, BicycleType.BMX);
        System.out.println(bicycle.getBicycleType());

        changeObject(bicycle);

        System.out.println(bicycle.getBicycleType());
        bicycle.produceNoise();
    }
    public static void changeObject(Bicycle bicycle) {
        bicycle.setBicycleType(BicycleType.GT);
    }
}

