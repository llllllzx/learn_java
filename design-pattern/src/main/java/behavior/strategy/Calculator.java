package behavior.strategy;

public interface Calculator {
    /**
     * 计算税
     *
     * @param salary
     * @param bonus
     * @return
     */
    double calculate(double salary, double bonus);
}
