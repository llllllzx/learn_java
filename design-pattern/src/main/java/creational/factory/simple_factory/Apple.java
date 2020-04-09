package creational.factory.simple_factory;

/**
 * @author Zhaoxin Liu
 */
public class Apple implements Fruit {

    /**
     * Default constructor
     */
    public Apple() {
    }

    public Apple(String name) {
        this.Name = name;
    }

    /**
     * 
     */
    private String Name;

    /**
     * 获取水果名
     * @return
     */
    public String getName() {
        // TODO implement here
        return "My name is " + Name;
    }

}