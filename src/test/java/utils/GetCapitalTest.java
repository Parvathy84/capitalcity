package utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetCapitalTest {

    @Test
    void getCapitalByName1() throws IOException {
        Map<String, String> actualResult = GetCapital.getCapitalByName("united");
        Map<String, String> expctedResult = new HashMap<>();
        expctedResult.put("Tanzania, United Republic of", "Dodoma");
        expctedResult.put("United States of America", "Washington, D.C.");
        expctedResult.put("Mexico", "Mexico City");
        expctedResult.put("United Arab Emirates", "Abu Dhabi");
        expctedResult.put("United Kingdom of Great Britain and Northern Ireland", "London");
        assertEquals(expctedResult, actualResult);
    }

    @Test
    void getCapitalByName2() throws IOException {
        Map<String, String> actualResult = GetCapital.getCapitalByName("canada");
        Map<String, String> expctedResult = new HashMap<>();
        expctedResult.put("Canada", "Ottawa");
        assertEquals(expctedResult, actualResult);
    }

    @Test
    void getCapitalByNameError() throws IOException {
        Map<String, String> actualResult = GetCapital.getCapitalByName("test");
        Map<String, String> expctedResult = new HashMap<>();
        expctedResult.put("Error", "No Country Name found");
        assertEquals(expctedResult, actualResult);
    }

    @Test
    void getCapitalByCode1() throws IOException {
        Map<String, String> actualResult = GetCapital.getCapitalByCode("co");
        Map<String, String> expctedResult = new HashMap<>();
        expctedResult.put("Colombia", "Bogotá");
        assertEquals(expctedResult, actualResult);
    }

    @Test
    void getCapitalByCodeError() throws IOException {
        Map<String, String> actualResult = GetCapital.getCapitalByCode("go");
        Map<String, String> expctedResult = new HashMap<>();
        expctedResult.put("Error", "No Country Code found");
        assertEquals(expctedResult, actualResult);
    }
}