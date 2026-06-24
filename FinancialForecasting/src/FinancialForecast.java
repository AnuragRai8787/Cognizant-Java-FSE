public class FinancialForecast {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {

        if (years == 0) {
            return currentValue;
        }
        if (years < 0) {
        throw new IllegalArgumentException("Years cannot be negative");
        }
        return predictFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {

        double initialValue = 10000;
        double growthRate = 0.10;
        int years = 5;

        double futureValue = predictFutureValue(initialValue, growthRate, years);

        System.out.println("Initial Value: " + initialValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.printf("Predicted Future Value: %.2f%n", futureValue);
    }
}