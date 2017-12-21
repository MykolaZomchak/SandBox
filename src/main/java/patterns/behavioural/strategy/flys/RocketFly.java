package patterns.behavioural.strategy.flys;

public class RocketFly implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Flying that rocket!!!");
    }
}
