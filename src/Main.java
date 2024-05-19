import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Interface for loading currency data
interface ICurrencyLoader {
    Map<String, Double> loadCurrencies();
}

// Class to load currency data from a file
class FileCurrencyLoader implements ICurrencyLoader {
    private String fileName;

    public FileCurrencyLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Map<String, Double> loadCurrencies() {
        Map<String, Double> currencies = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String currencyName = parts[0].trim();
                    Double exchangeRate = Double.parseDouble(parts[1].trim());
                    currencies.put(currencyName, exchangeRate);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencies;
    }
}

// Class representing a single currency
class MyCurrency {
    private String name;
    private Double exchangeRate;

    public MyCurrency(String name, Double exchangeRate) {
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public String getName() {
        return name;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    // Convert amount to USD
    public Double toUSD(Double amount) {
        return amount / exchangeRate;
    }

    // Convert amount from USD
    public Double fromUSD(Double amount) {
        return amount * exchangeRate;
    }
}

// Class to maintain a collection of currencies and perform currency conversions
class Currencies {
    private Map<String, MyCurrency> currencyMap;

    // Constructor with ICurrencyLoader
    public Currencies(ICurrencyLoader loader) {
        currencyMap = new HashMap<>();
        Map<String, Double> loadedCurrencies = loader.loadCurrencies();
        for (Map.Entry<String, Double> entry : loadedCurrencies.entrySet()) {
            currencyMap.put(entry.getKey(), new MyCurrency(entry.getKey(), entry.getValue()));
        }
    }

    // Method to add a currency
    public void addCurrency(String name, Double exchangeRate) {
        currencyMap.put(name, new MyCurrency(name, exchangeRate));
    }

    // Method to get a currency's exchange rate
    public Double getExchangeRate(String currencyName) {
        MyCurrency currency = currencyMap.get(currencyName);
        return currency != null ? currency.getExchangeRate() : null;
    }

    // Method to convert amount to USD
    public Double convertToUSD(String currencyName, Double amount) {
        MyCurrency currency = currencyMap.get(currencyName);
        return currency != null ? currency.toUSD(amount) : null;
    }

    // Method to convert amount from USD
    public Double convertFromUSD(String currencyName, Double amount) {
        MyCurrency currency = currencyMap.get(currencyName);
        return currency != null ? currency.fromUSD(amount) : null;
    }
}

// Main class for testing the implementation
public class Main {
    public static void main(String[] args) {
        // Create an instance of FileCurrencyLoader
        FileCurrencyLoader loader = new FileCurrencyLoader("currencies.csv");

        // Use loader to create an instance of Currencies
        Currencies currencies = new Currencies(loader);

        // Demonstrate fetching a currency and converting an amount to and from USD
        String currency = "EUR";
        Double amount = 100.0;

        System.out.println("Exchange rate for " + currency + ": " + currencies.getExchangeRate(currency));
        System.out.println(amount + " " + currency + " in USD: " + currencies.convertToUSD(currency, amount));
        System.out.println(amount + " USD in " + currency + ": " + currencies.convertFromUSD(currency, amount));

        // Check behavior when a currency does not exist
        String nonExistingCurrency = "XYZ";
        System.out.println("Exchange rate for " + nonExistingCurrency + ": " + currencies.getExchangeRate(nonExistingCurrency));
    }
}
