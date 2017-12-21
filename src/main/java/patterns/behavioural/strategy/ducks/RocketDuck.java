package patterns.behavioural.strategy.ducks;

import patterns.behavioural.strategy.flys.RocketFly;
import patterns.behavioural.strategy.quacks.SimpleQuack;

public class RocketDuck extends Duck {

    {
        quack = new SimpleQuack();
        fly = new RocketFly();
    }

    @Override
    public void display() {
        System.out.println("Rocket Duck");
    }
}
