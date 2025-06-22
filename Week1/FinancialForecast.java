public class FinancialForecast {

    public static double forecastRecursive(double presentValue, double rate, int years) {
        if (years == 0) return presentValue;  // base case
        return forecastRecursive(presentValue, rate, years - 1) * (1 + rate);
    }

    public static double forecastMemoized(double presentValue, double rate, int years, Double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != null) return memo[years];
        memo[years] = forecastMemoized(presentValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 10000; // ₹10,000 investment
        double growthRate = 0.07;    // 7% annual growth
        int years = 5;

        System.out.println("== Simple Recursive Forecast ==");
        double result = forecastRecursive(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: ₹%.2f%n", years, result);

        System.out.println("\n== Optimized Recursive Forecast (Memoized) ==");
        Double[] memo = new Double[years + 1];
        double optimizedResult = forecastMemoized(presentValue, growthRate, years, memo);
        System.out.printf("Future Value after %d years: ₹%.2f%n", years, optimizedResult);

        System.out.println("\n By Meenakshi A J - 6420952\n");
    }
}
