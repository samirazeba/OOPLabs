package Week13;

interface TrafficLightState {
    void transitionToRed();
    void transitionToGreen();
    void transitionToYellow();
}
class RedLightState implements TrafficLightState {
    @Override
    public void transitionToRed() {
        System.out.println("RED");
    }
    @Override
    public void transitionToYellow() {
        System.out.println("Switching to yellow.");
    }
    @Override
    public void transitionToGreen() {
        System.out.println("Switching to green.");
    }
}
class YellowLightState implements TrafficLightState {
    @Override
    public void transitionToYellow() {
        System.out.println("YELLOW");
    }
    @Override
    public void transitionToGreen() {
        System.out.println("Switching to green.");
    }
    @Override
    public void transitionToRed() {
        System.out.println("Switching to red");
    }
}
class GreenLightState implements TrafficLightState {
    @Override
    public void transitionToGreen() {
        System.out.println("GREEN");
    }
    @Override
    public void transitionToYellow() {
        System.out.println("Switching to yellow");
    }
    @Override
    public void transitionToRed() {
        System.out.println("Switching to red");
    }
}
class TrafficLightContext {
    public TrafficLightState state;

    public TrafficLightContext() {
        this.state = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void transitionToRed() {
        state.transitionToRed();
    }
    public void transitionToGreen() {
        state.transitionToGreen();
    }
    public void transitionToYellow() {
        state.transitionToYellow();
    }
}
class TrafficLightController {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();

        context.transitionToGreen();
        context.transitionToYellow();
        context.transitionToRed();
        context.transitionToGreen();
    }
}

