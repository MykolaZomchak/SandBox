package patterns.behavioural.strategy.quacks;

public class SilentQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Can't quack");
    }
}
