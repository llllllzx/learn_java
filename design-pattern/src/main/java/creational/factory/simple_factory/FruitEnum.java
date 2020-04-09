package creational.factory.simple_factory;



public enum FruitEnum {

    APPLE("Apple"),

    ORANGE("Orange");

    private String name;

    FruitEnum(String name){
        this.name = name;
    }
}
