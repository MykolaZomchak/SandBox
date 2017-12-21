package patterns.behavioural.strategy.ducks;

import patterns.behavioural.strategy.flys.FlyBehaviour;
import patterns.behavioural.strategy.flys.NotFly;
import patterns.behavioural.strategy.quacks.QuackBehaviour;
import patterns.behavioural.strategy.quacks.SilentQuack;

public abstract class Duck implements FlyBehaviour, QuackBehaviour {

    FlyBehaviour fly = new NotFly();
    QuackBehaviour quack = new SilentQuack();

    public abstract void display();

    public void fly(){
        fly.fly();
    }

    public void quack(){
        quack.quack();
    }

}
