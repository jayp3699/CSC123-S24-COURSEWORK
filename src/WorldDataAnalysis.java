import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldDataAnalysis {

    public static void main(String[] args) {
        List<Map<String, String>> countryData = readCSV("world_factbook.csv");

        if (countryData != null && !countryData.isEmpty()) {
            String countryWithHighestBirthRate = getCountryWithHighestValue(countryData, "birth_rate");
            String countryWithHighestPopulation = getCountryWithHighestValue(countryData, "population");
            String countryWithSmallestArea = getCountryWithSmallestValue(countryData, "area");

            double totalPopulation = getTotalValue(countryData, "population");
            double averageBirthRate = getAverageValue(countryData, "birth_rate");
            double totalArea = getTotalValue(countryData, "area");

            System.out.println("Country with highest birth rate: " + countryWithHighestBirthRate);
            System.out.println("Country with highest population: " + countryWithHighestPopulation);
            System.out.println("Country with smallest area: " + countryWithSmallestArea);
            System.out.println("Total population of the world: " + totalPopulation);
            System.out.println("Average birth rate of the world: " + averageBirthRate);
            System.out.println("Total area of land in the world: " + totalArea);
        } else {
            System.out.println("No data found.");
        }
    }

    public static List<Map<String, String>> readCSV(String filename) {
        List<Map<String, String>> countryDataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] keys = null;

            while ((line = br.readLine()) != null) {
                if (keys == null) {
                    keys = line.split(",");
                } else {
                    String[] values = line.split(",");
                    Map<String, String> countryData = new HashMap<>();

                    for (int i = 0; i < keys.length; i++) {
                        countryData.put(keys[i], values[i]);
                    }

                    countryDataList.add(countryData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countryDataList;
    }

    public static String getCountryWithHighestValue(List<Map<String, String>> countryDataList, String key) {
        double maxValue = Double.MIN_VALUE;
        String countryWithMaxValue = "";

        for (Map<String, String> countryData : countryDataList) {
            double value = Double.parseDouble(countryData.get(key));
            if (value > maxValue) {
                maxValue = value;
                countryWithMaxValue = countryData.get("country_name");
            }
        }

        return countryWithMaxValue;
    }

    public static String getCountryWithSmallestValue(List<Map<String, String>> countryDataList, String key) {
        double minValue = Double.MAX_VALUE;
        String countryWithMinValue = "";

        for (Map<String, String> countryData : countryDataList) {
            double value = Double.parseDouble(countryData.get(key));
            if (value < minValue) {
                minValue = value;
                countryWithMinValue = countryData.get("country_name");
            }
        }

        return countryWithMinValue;
    }

    public static double getTotalValue(List<Map<String, String>> countryDataList, String key) {
        double total = 0;

        for (Map<String, String> countryData : countryDataList) {
            total += Double.parseDouble(countryData.get(key));
        }

        return total;
    }

    public static double getAverageValue(List<Map<String, String>> countryDataList, String key) {
        double total = getTotalValue(countryDataList, key);
        return total / countryDataList.size();
    }
}
