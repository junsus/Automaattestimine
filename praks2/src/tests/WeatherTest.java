package tests;

import org.junit.jupiter.api.Test;
import weather.WeatherRepository;
import weather.WeatherRequest;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {

    private WeatherRequest request = new WeatherRequest();
    private WeatherRepository repository = new WeatherRepository();

    @Test
    public void coordinatesIsCorrectFormat() {
        try {
            String[] parts = repository.getCoordinates().split(":");
            Double.valueOf(parts[0]);
            Double.valueOf(parts[1]);
        } catch (NumberFormatException e) {
            assert false;
        }
        assert true;
    }

    @Test
    public void repositoryCityEqualsRequestCity() {
        assertEquals(repository.getCityName(), request.getCityName());
    }

    @Test
    public void repositoryCityEqualsTallinn() {
        assertEquals(repository.getCityName(), "Tallinn");
    }

    @Test
    public void repositoryCoordinatesEqualsRequestCoordinates() {
        assertEquals(repository.getCoordinates(), request.getCoordinates());
    }

    @Test
    public void repositoryCoordinatesEqualsTallinnLocation() {
        assertEquals(repository.getCoordinates(), "59.437:24.7535");
    }

    @Test
    public void repositoryCurrentTemperatureEqualsRequest() {
        assertEquals(repository.getCurrentTemp(), request.getCurrentTemp());
    }

    @Test
    public void repositoryDayOneMaximumTemperatureEqualsRequest() {
        assertEquals(repository.getDayOneMaxTemp(), request.getDayOneMaxTemp());
    }

    @Test
    public void repositoryDayOneMinimumTemperatureEqualsRequest() {
        assertEquals(repository.getDayOneMinTemp(), request.getDayOneMinTemp());
    }

    @Test
    public void repositoryDayTwoMaximumTemperatureEqualsRequest() {
        assertEquals(repository.getDayTwoMaxTemp(), request.getDayTwoMaxTemp());
    }

    @Test
    public void repositoryDayTwoMinimumTemperatureEqualsRequest() {
        assertEquals(repository.getDayTwoMinTemp(), request.getDayTwoMinTemp());
    }

    @Test
    public void repositoryDayThreeMaximumTemperatureEqualsRequest() {
        assertEquals(repository.getDayThreeMaxTemp(), request.getDayThreeMaxTemp());
    }

    @Test
    public void repositoryDayThreeMinimumTemperatureEqualsRequest() {
        assertEquals(repository.getDayThreeMinTemp(), request.getDayThreeMinTemp());
    }
}
