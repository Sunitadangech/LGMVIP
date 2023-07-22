import java.util.Scanner;

public class currency {

    private static final double INR_TO_USD = 0.0120;
    private static final double INR_TO_EUR = 0.01139;
    private static final double INR_TO_CAD = 0.0163;
    private static final double INR_TO_JPY = 1.6012;
    private static final double INR_TO_CNY = 0.083;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount in INR: ");
        double amountInINR = scanner.nextDouble();

        System.out.println("Enter the currency you want to convert to: ");
        String currencyToConvertTo = scanner.next();

        double amountInTargetCurrency;
        switch (currencyToConvertTo) {
            case "USD":
                amountInTargetCurrency = amountInINR * INR_TO_USD;
                break;
            case "EUR":
                amountInTargetCurrency = amountInINR * INR_TO_EUR;
                break;
            case "CAD":
                amountInTargetCurrency = amountInINR * INR_TO_CAD;
                break;
            case "JPY":
                amountInTargetCurrency = amountInINR * INR_TO_JPY;
                break;
            case "CNY":
                amountInTargetCurrency = amountInINR * INR_TO_CNY;
                break;
            default:
                amountInTargetCurrency = 0;
                System.out.println("Invalid currency");
                break;
        }

        System.out.println(amountInINR + " INR = " + amountInTargetCurrency + " " + currencyToConvertTo);
    }
}
