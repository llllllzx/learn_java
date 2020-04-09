package creational.factory.simple_factory;

public class Driver {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();
        Fruit apple = fruitFactory.createFruit(FruitEnum.APPLE.toString());
        Fruit orange = fruitFactory.createFruit(FruitEnum.ORANGE.toString());

        System.out.println(apple.getName());
        System.out.println(orange.getName());
    }
}
