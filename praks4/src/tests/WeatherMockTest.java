package tests;

import files.WriteReadFile;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weather.WeatherRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherMockTest {

    private WriteReadFile writeReadFile = new WriteReadFile();
    private WeatherRequest request;

    @BeforeEach
    public void beforeEach() {
        request = new WeatherRequest();
        JSONObject currentWeather = new JSONObject(writeReadFile.readFile("../tests/MockCurrentWeather.txt"));
        String jsonString = "";
        for (String line : writeReadFile.readFile("../tests/MockForecast.txt").split("\n")) {
            jsonString += line;
        }
        JSONObject forecast = new JSONObject(jsonString);
        request.parseJson(forecast, currentWeather);
    }

    @Test
    public void coordinatesIsCorrectFormat() {
        try {
            String[] parts = request.getCoordinates().split(":");
            Double.valueOf(parts[0]);
            Double.valueOf(parts[1]);
        } catch (NumberFormatException e) {
            assert false;
        }
        assert true;
    }

    @Test
    public void mockForecastCityEqualsRequestCity() {
        assertEquals("Testlinn", request.getCityName());
    }

    @Test
    public void mockForecastCoordinatesEqualsRequestCoordinates() {
        assertEquals("22.444:33.555", request.getCoordinates());
    }

    @Test
    public void mockCurrentTemperatureEqualsRequest() {
        assertEquals(1, request.getCurrentTemp());
    }

    @Test
    public void mockDayOneMaximumTemperatureEqualsRequest() {
        assertEquals(-12.21, request.getDayOneMaxTemp());
    }

    @Test
    public void mockDayOneMinimumTemperatureEqualsRequest() {
        assertEquals(-13.42, request.getDayOneMinTemp());
    }

    @Test
    public void mockDayTwoMaximumTemperatureEqualsRequest() {
        assertEquals(-11.59, request.getDayTwoMaxTemp());
    }

    @Test
    public void mockDayTwoMinimumTemperatureEqualsRequest() {
        assertEquals(-12.49, request.getDayTwoMinTemp());
    }

    @Test
    public void mockDayThreeMaximumTemperatureEqualsRequest() {
        assertEquals(0.72, request.getDayThreeMaxTemp());
    }

    @Test
    public void mockDayThreeMinimumTemperatureEqualsRequest() {
        assertEquals(0.12, request.getDayThreeMinTemp());
    }
}
