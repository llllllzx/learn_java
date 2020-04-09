package creational.factory.factory_method;

public class AppleFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Apple("Apple");
    }
}
