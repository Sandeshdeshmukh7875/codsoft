import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    private static String getUserInput(String prompt) throws IOException {
        System.out.print(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().toUpperCase(); // Assume currency codes are in uppercase
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        // Replace this URL with the actual API URL for currency exchange rates
        String apiUrl = "https://api.example.com/exchangerates?base=" + baseCurrency;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Parse the response to get the exchange rate
            // This will depend on the format of the response from the API
            // For simplicity, we assume the API returns a JSON object with a 'rate' field
            return parseExchangeRateFromJson(response.toString(), targetCurrency);
        }
    }

    private static double parseExchangeRateFromJson(String json, String targetCurrency) {
        // Implement JSON parsing logic to extract the exchange rate for the target currency
        // For simplicity, we assume a JSON structure like {"rates": {"EUR": 0.85, "GBP": 0.75, ...}}
        // You should use a JSON parsing library for real-world scenarios
        // Replace this implementation with a suitable one based on your API response
        return 0.0;
    }

    private static double getAmountToConvert() throws IOException {
        String amountStr = getUserInput("Enter the amount to convert: ");
        return Double.parseDouble(amountStr);
    }

    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    private static void displayResult(double convertedAmount, String targetCurrency) {
        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
    }

    public static void main(String[] args) {
        try {
            // Step 1: Currency Selection
            String baseCurrency = getUserInput("Enter the base currency code (e.g., USD): ");
            String targetCurrency = getUserInput("Enter the target currency code (e.g., EUR): ");

            // Step 2: Currency Rates - Fetch real-time exchange rates from API
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

            // Step 3: Amount Input
            double amountToConvert = getAmountToConvert();

            // Step 4: Currency Conversion
            double convertedAmount = convertCurrency(amountToConvert, exchangeRate);

            // Step 5: Display Result
            displayResult(convertedAmount, targetCurrency);

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
