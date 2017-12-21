package patterns.behavioural.strategy.ducks;

import patterns.behavioural.strategy.flys.SimpleFly;
import patterns.behavioural.strategy.quacks.SimpleQuack;

public class SimpleDuck extends Duck {

    {
        fly = new SimpleFly();
        quack = new SimpleQuack();
    }

    @Override
    public void display() {
        System.out.println("Simple Duck");
    }
}
