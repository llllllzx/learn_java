package creational.factory.factory_method;


public class Driver {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        Fruit apple = appleFactory.createFruit();
        System.out.println(apple.getName());
    }
}
