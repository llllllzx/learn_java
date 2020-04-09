package creational.singleton;


public class LazySingleton {
    //必须使用volatile修饰
    private volatile static LazySingleton singleton = null;

    private LazySingleton() {
        //empty
    }

    //double check
    public LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return LazySingleton.singleton;
    }
}
