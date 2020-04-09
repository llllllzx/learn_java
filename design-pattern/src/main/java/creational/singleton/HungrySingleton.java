package creational.singleton;

public class HungrySingleton {
    /**
     * 当类加载的时候被加载
     */
    private final static HungrySingleton singleton = new HungrySingleton();

    /**
     * 构造器必须是私有的
     */
    private HungrySingleton() {
        //empty
    }

    public HungrySingleton getSingleton() {
        return singleton;
    }

}


