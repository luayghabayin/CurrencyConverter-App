/**
 *
 * @author luay ghabayin
 */
import java.util.Scanner;

public class CurrencyConverter {

    // final variables for exchange rate of each currency
    static final double EURO = 1.124;
    static final double CAD = 0.758;
    static final double GBP = 1.296;
    static final String EURO_SYMBOL = "€";
    static final String CAD_SYMBOL = "$";
    static final String GBP_SYMBOL = "£";
    static final String USD_SYMBOL = "$";
//    static final $

    // main method
    public static void main(String[] args) {
        // scnnaer object to read input
        Scanner in = new Scanner(System.in);
        // variable for currency in hand
        String currencyFrom;
        // loop to get and validate input for currency in hand
        while (true) {
            System.out.print("Enter currency in hand (USD|CAD|EURO|GBP): ");
            currencyFrom = in.next().toUpperCase();
            if (checkCurrency(currencyFrom)) {
                break;
            }
            System.out.println("Invalid currency");
        }
        // variable for currency required
        String currencyTo;
        // loop to get and validate input for currency required
        while (true) {
            System.out.print("Enter required currency (USD|CAD|EURO|GBP): ");
            currencyTo = in.next().toUpperCase();
            if (checkCurrency(currencyTo)) {
                break;
            }
            System.out.println("Please enter valid currency");
        }
        // variable for amount
        double amount;
        String temp_symbol = "";

        if (currencyFrom.equals("EURO")) {
            temp_symbol = EURO_SYMBOL;
        } else if (currencyFrom.equals("CAD")) {
            temp_symbol = CAD_SYMBOL;
        } else if (currencyFrom.equals("GBP")) {
            temp_symbol = GBP_SYMBOL;
        } else if (currencyFrom.equals("USD")) {
            temp_symbol = USD_SYMBOL;
        }

        double dollar = convertToDollar(currencyFrom, 1);
        double exchangeValue = dollarToCurrency(currencyTo, dollar);
        // loop to get positive value for the amount
        while (true) {
            System.out.print(String.format("\nExchange rate: One " + currencyFrom + "(" + temp_symbol + ")= %.3f" + " " + currencyTo + " dollar", exchangeValue));
            System.out.print("\nEnter the " + currencyFrom + " amount to convert to " + currencyTo + ": ");
            amount = in.nextDouble();
            if (amount <= 0) {
                System.out.println("\nPlease enter a positive amount to be converted.");
                continue;
            }
            if (checkCurrency(currencyFrom)) {
                break;
            }
        }

        // convert given amount to dollar from cy in hand
        dollar = convertToDollar(currencyFrom, amount);
        // convert dollar to required currency
        exchangeValue = dollarToCurrency(currencyTo, dollar);
        // display the amount and exchange value in 2 decimal places
        System.out.printf("\n%.2f %s is equal to %.2f %s\n", amount, currencyFrom, exchangeValue, currencyTo);
    }

    // method to convert given currency amount to dollar
    private static double convertToDollar(String currencyFrom, double value) {
        if (currencyFrom.equals("EURO")) {
            return value * EURO;
        }
        if (currencyFrom.equals("CAD")) {
            return value * CAD;
        }
        if (currencyFrom.equals("GBP")) {
            return value * GBP;
        }
        if (currencyFrom.equals("USD")) {
            return value;
        }
        return 0.0;

    }

    // method to convert dollar to given currency amount
    private static double dollarToCurrency(String currency, double dollar) {
        if (currency.equals("EURO")) {
            return dollar / EURO;
        }
        if (currency.equals("CAD")) {
            return dollar / CAD;
        }
        if (currency.equals("GBP")) {
            return dollar / GBP;
        }
        if (currency.equals("USD")) {
            return dollar;
        }
        return 0.0;
    }
    // method to check currency

    private static boolean checkCurrency(String currency) {
        return currency.equals("USD") || currency.equals("CAD") || currency.equals("EURO") || currency.equals("GBP");
    }
}
