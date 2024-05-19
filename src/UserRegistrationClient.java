import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class UserRegistrationClient {

    private static final String API_URL = "https://e3m1dkivq8.execute-api.us-west-1.amazonaws.com/Production/create-record";
    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.println("Welcome to User Registration!");
                System.out.println("Please enter the following details:");

                // Collect user information
                String firstName = getUserInput(reader, "First Name");
                String lastName = getUserInput(reader, "Last Name");
                String email = getUserInput(reader, "Email");
                String city = getUserInput(reader, "City");
                String school = getUserInput(reader, "School");
                String state = getUserInput(reader, "State");
                String country = getUserInput(reader, "Country");

                // Create JSON payload
                String jsonPayload = String.format("{\"cust_id\":\"%s\",\"first_name\":\"%s\",\"last_name\":\"%s\",\"email\":\"%s\",\"city\":\"%s\",\"school\":\"%s\",\"state\":\"%s\",\"country\":\"%s\"}",
                        generateUniqueId(), firstName, lastName, email, city, school, state, country);

                // Make POST request
                int responseCode = sendPostRequest(API_URL, jsonPayload);

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    System.out.println("User registration successful!");
                } else {
                    System.out.println("Error: Failed to register user. HTTP error code: " + responseCode);
                }

                // Ask if the user wants to register another user
                System.out.println("Do you want to register another user? (yes/no)");
                String choice = reader.readLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getUserInput(BufferedReader reader, String fieldName) throws IOException {
        System.out.print(fieldName + ": ");
        return reader.readLine();
    }

    private static int sendPostRequest(String apiUrl, String jsonPayload) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(jsonPayload.getBytes());
        }

        return connection.getResponseCode();
    }

    private static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
