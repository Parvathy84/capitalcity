package utils;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetCapital {

    private final static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static Map<String, String> getCapitalByName(String countryName) throws IOException {
        Map<String, String> captialList = new HashMap<>();
        HttpGet request = new HttpGet(String.format("https://restcountries.eu/rest/v2/name/%s", countryName));
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    captialList = getCapital(EntityUtils.toString(entity));
                }
            } else {
                captialList.put("Error", "No Country Name found");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return captialList;
    }

    private static Map<String, String> getCapital(String response) throws ParseException {
        Map<String, String> captialList = new HashMap<>();
        Object obj = new JSONParser().parse(response);
        JSONArray ja = (JSONArray) obj;
        for (Object jo : ja) {
            String name = ((JSONObject) jo).get("name").toString();
            String capital = ((JSONObject) jo).get("capital").toString();
            if (!capital.equalsIgnoreCase("")) {
                captialList.put(name, capital);
            }
        }
        return captialList;
    }

    private static Map<String, String> getCapitalWithCode(String response) throws ParseException {
        Map<String, String> captialList = new HashMap<>();
        Object obj = new JSONParser().parse(response);
        JSONObject jo = (JSONObject) obj;
        String name = jo.get("name").toString();
        String capital = jo.get("capital").toString();
        if (!capital.equalsIgnoreCase("")) {
            captialList.put(name, capital);
        }
        return captialList;
    }

    public static Map<String, String> getCapitalByCode(String countryCode) throws IOException {
        Map<String, String> captialList = new HashMap<>();
        HttpGet request = new HttpGet(String.format("https://restcountries.eu/rest/v2/alpha/%s", countryCode));
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    captialList = getCapitalWithCode(EntityUtils.toString(entity));
                }
            } else {
                captialList.put("Error", "No Country Code found");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return captialList;
    }
}
