import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherApiTest {

    @Test
    public void currentTemperatureIsCorrectValue() {
        int minTemp = -100;
        int maxTemp = 100;

        WeatherApi api = new WeatherApi("Tallinn");
        int currentTemperature = api.getCurrentTemp();
        assertTrue(minTemp < currentTemperature && currentTemperature < maxTemp);
    }

    @Test
    public void currentTemperature() {

        WeatherApi api = new WeatherApi("Tallinn");
        WeatherReport report = new WeatherReport();

        assertEquals(api.dayOne.currentTemp, report.dayOne.CurrentTemp);
    }

    @Test
    public void lowestTemperatureOfDayOne() {

        WeatherApi api = new WeatherApi("Tallinn");
        WeatherReport report = new WeatherReport();

        assertEquals(api.dayOne.lowestTemp, report.dayOne.lowestTemp);
    }

    @Test
    public void lowestTemperatureOfDayTwo() {

        WeatherApi api = new WeatherApi("Tallinn");
        WeatherReport report = new WeatherReport();

        assertEquals(api.dayTwo.lowestTemp, report.dayTwo.lowestTemp);
    }

    @Test
    public void lowestTemperatureOfDayThree() {

        WeatherApi api = new WeatherApi("Tallinn");
        WeatherReport report = new WeatherReport();

        assertEquals(api.dayThree.lowestTemp, report.dayThree.lowestTemp);
    }

    @Test
    public void highestTemperatureOfDayOne() {

        WeatherApi api = new WeatherApi("Tallinn");
        WeatherReport report = new WeatherReport();

        assertEquals(api.dayOne.highestTemp, report.dayOne.highestTemp);
    }

    @Test
    public void highestTemperatureOfDayTwo() {

        WeatherApi api = new WeatherApi("Tallinn");
        WeatherReport report = new WeatherReport();

        assertEquals(api.dayTwo.highestTemp, report.dayTwo.highestTemp);
    }

    @Test
    public void highestTemperatureOfDayThree() {

        WeatherApi api = new WeatherApi("Tallinn");
        WeatherReport report = new WeatherReport();

        assertEquals(api.dayThree.highestTemp, report.dayThree.highestTemp);
    }

    @Test
    public void coordinatesGEO() {

        WeatherApi api = new WeatherApi("Tallinn");
        WeatherReport report = new WeatherReport();

        assertEquals(api.coordinates, report.coordinates);
    }

}