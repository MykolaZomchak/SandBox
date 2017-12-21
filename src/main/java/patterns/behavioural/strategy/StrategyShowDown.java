package patterns.behavioural.strategy;

import patterns.behavioural.strategy.ducks.*;

public class StrategyShowDown {


    public static void main(String[] args) {
        Duck[] ducks = new Duck[4];

        ducks[0] = new SimpleDuck();
        ducks[1] = new RocketDuck();
        ducks[2] = new RubberDuck();
        ducks[3] = new WoodenDuck();

        for(Duck duck : ducks){
            duck.display();
            duck.fly();
            duck.quack();
            System.out.println();
        }
    }
}
