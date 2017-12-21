package patterns.behavioural.strategy.flys;

public class NotFly implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Can't fly");
    }
}
