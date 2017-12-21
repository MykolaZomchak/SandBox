package patterns.behavioural.strategy.quacks;

public class AnnoyingQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Annoying quack!!!");
    }
}
