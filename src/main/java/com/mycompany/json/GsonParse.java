package com.mycompany.json;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author W206665118
 */
public class GsonParse {

    StringBuilder sb = new StringBuilder();

    public String fetchDat() {

        try {
            URL url = new URL("https://www.w3schools.com/angular/customers.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code: " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            System.out.println("Output from Server .... \n");

            while ((output = br.readLine()) != null) {
                sb.append(output);
                System.out.println(output);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public void jsonObject() {
        Gson gson = new GsonBuilder().create();
        Records record=gson.fromJson(fetchDat(), Records.class);
        record.Display();
    }

    public static void main(String[] args) {
        GsonParse wm = new GsonParse();
        wm.jsonObject();
    }
}