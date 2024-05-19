//NAME : JAY PRAJAPATI
//ASSIGNMENT 6 

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// MyCurrency class
class MyCurrency {
    private String currencyCode;
    private double exchangeRate;

    public MyCurrency(String currencyCode, double exchangeRate) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "MyCurrency{" +
                "currencyCode='" + currencyCode + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}

// AbstractCurrencyLoader abstract class
abstract class AbstractCurrencyLoader {

    public Map<String, MyCurrency> loadCurrencies() {
        Map<String, MyCurrency> currencies = new HashMap<>();
        try (InputStream inputStream = getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String currencyCode = parts[0].trim();
                    double exchangeRate = Double.parseDouble(parts[1].trim());
                    currencies.put(currencyCode, new MyCurrency(currencyCode, exchangeRate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencies;
    }

    protected abstract InputStream getInputStream() throws Exception;
}

// FileCurrencyLoader class
class FileCurrencyLoader extends AbstractCurrencyLoader {
    private String filePath;

    public FileCurrencyLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected InputStream getInputStream() throws Exception {
        return new FileInputStream(filePath);
    }
}

// NetworkCurrencyLoader class
class NetworkCurrencyLoader extends AbstractCurrencyLoader {
    private String urlString;

    public NetworkCurrencyLoader(String urlString) {
        this.urlString = urlString;
    }

    @Override
    protected InputStream getInputStream() throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection.getInputStream();
    }
}

// CurrencyLoaderDemo class
public class CurrencyLoaderDemo {
    public static void main(String[] args) {
        try {
            // Load currencies from a local file
            AbstractCurrencyLoader fileLoader = new FileCurrencyLoader("currencies.csv");
            Map<String, MyCurrency> fileCurrencies = fileLoader.loadCurrencies();
            System.out.println("Currencies loaded from file:");
            fileCurrencies.forEach((code, currency) -> System.out.println(currency));

            // Load currencies from a network URL
            AbstractCurrencyLoader networkLoader = new NetworkCurrencyLoader("http://www.usman.cloud/banking/exchange-rate.csv");
            Map<String, MyCurrency> networkCurrencies = networkLoader.loadCurrencies();
            System.out.println("Currencies loaded from network:");
            networkCurrencies.forEach((code, currency) -> System.out.println(currency));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
