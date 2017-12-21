package patterns.behavioural.strategy.flys;

public class SimpleFly implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Just flying");
    }
}
