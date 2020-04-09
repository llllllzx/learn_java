package behavior.strategy;

public class SimpleCalculatorStrategy implements Calculator {
    private static final double SALARY_RATE = 0.1;
    private static final double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
