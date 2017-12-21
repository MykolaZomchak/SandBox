package patterns.behavioural.strategy.ducks;

import patterns.behavioural.strategy.quacks.AnnoyingQuack;

public class RubberDuck extends Duck {

    { quack = new AnnoyingQuack(); }

    @Override
    public void display() {
        System.out.println("Rubber Duck");
    }
}
