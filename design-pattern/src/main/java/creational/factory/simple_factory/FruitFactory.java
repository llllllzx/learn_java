package creational.factory.simple_factory;

/**
 * @author Zhaoxin Liu
 */
public class FruitFactory {

    /**
     * @param fruitName
     * @return
     */
    public Fruit createFruit(String fruitName) {
        // TODO implement here
        if (fruitName == "APPLE") {
            return new Apple("Apple");
        } else if (fruitName == "ORANGE") {
            return new Orange("Orange");
        }
        return null;
    }

}