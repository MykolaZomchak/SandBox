package patterns.behavioural.strategy.quacks;

public class SimpleQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack, Quack");
    }
}
