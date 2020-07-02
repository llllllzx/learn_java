package Test;

/**
 * @author liuzhaoxin
 */
public class StackOverFlow {
    public int stackSize = 0;

    public void stackIncre() {
        stackSize++;
        stackIncre();
    }

    public static void main(String[] args) throws Throwable {
        StackOverFlow sof = new StackOverFlow();
        try {
            sof.stackIncre();
        } catch (Throwable e) {
            System.out.println(sof.stackSize);
            throw e;
        }
    }
}
