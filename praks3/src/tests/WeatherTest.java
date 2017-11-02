package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weather.WeatherRepository;
import weather.WeatherRequest;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {

    private WeatherRequest request;
    private WeatherRepository repository = new WeatherRepository("Tallinn");

    @BeforeEach
    public void beforeEach() {
        ByteArrayInputStream stream = new ByteArrayInputStream("y\nTallinn".getBytes());
        System.setIn(stream);
        request = new WeatherRequest();
    }

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
        assertEquals("Tallinn", repository.getCityName());
    }

    @Test
    public void repositoryCoordinatesEqualsRequestCoordinates() {
        assertEquals(repository.getCoordinates(), request.getCoordinates());
    }

    @Test
    public void repositoryCoordinatesEqualsTallinnLocation() {
        assertEquals("59.437:24.7535", repository.getCoordinates());
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
