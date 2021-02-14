package com.kevinpham;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            // 30 Second timeout
            connection.setReadTimeout(3000);

            // Setting response code, also performs the connection
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            // Response code 200 = OK
            if (responseCode != 200) {
                System.out.println("Error reading web page");
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line = "";
            // Read content of website
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();

//
//            // *** Alternative ***
//
//            urlConnection.connect();
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream()));
//
//            Map<String, List<String>> headerFields = connection.getHeaderFields();
//            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("--------key = " + key);
//                for (String string : value) {
//                    System.out.println("value = " + value);
//                }
//            }
//
//
//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();


        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
