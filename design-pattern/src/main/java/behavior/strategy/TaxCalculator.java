package behavior.strategy;

import lombok.Getter;

public class TaxCalculator implements Calculator {
    @Getter
    private final double salary;
    @Getter
    private final double bonus;
    private final Calculator calculator;


    public TaxCalculator(double salary, double bonus, Calculator calculator) {
        this.salary = salary;
        this.bonus = bonus;
        this.calculator = calculator;
    }

    private double calculate() {
        if (calculator != null) {
            return calculator.calculate(salary, bonus);
        } else {
            throw new IllegalArgumentException("lack calculator strategy!!!");
        }
    }

    public double taxCal() {
        return calculate();
    }

    @Override
    public double calculate(double salary, double bonus) {
        return 0;
    }
}
