package behavior.strategy;

public class Driver {
    public static void main(String[] args) {
        final TaxCalculator taxCalculator = new TaxCalculator(10000, 1000, new SimpleCalculatorStrategy());
        final double calculate = taxCalculator.taxCal();
        System.out.println(calculate);
        System.out.println(taxCalculator.getSalary());
        System.out.println(taxCalculator.getBonus());
    }
}


