package tests;

import files.WriteReadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weather.WeatherRepository;
import weather.WeatherRequest;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TxtConsoleTest {
    private WeatherRequest request;

    @BeforeEach
    public void beforeEach() {
        System.setIn(System.in);
    }

    @Test
    public void correctInputCityAfterUserInput1() {
        ByteArrayInputStream stream = new ByteArrayInputStream("y\nHelsinki".getBytes());
        System.setIn(stream);
        request = new WeatherRequest();
        assertEquals("Helsinki", request.getCityName());
    }


    @Test
    public void correctInputCityAfterUserInput2() {
        ByteArrayInputStream stream = new ByteArrayInputStream("y\nBeijing".getBytes());
        System.setIn(stream);
        request = new WeatherRequest();
        assertEquals("Beijing", request.getCityName());
    }

    @Test
    public void sameCityAfterNoUserInput() {
        String currentCity = WriteReadFile.readFile("input.txt");
        ByteArrayInputStream stream = new ByteArrayInputStream("n\nBeijing".getBytes());
        System.setIn(stream);
        request = new WeatherRequest();
        assertEquals(currentCity, request.getCityName());
    }

    @Test
    public void correctOutputFile() {
        ByteArrayInputStream stream = new ByteArrayInputStream("y\nTallinn".getBytes());
        System.setIn(stream);
        new WeatherRequest();
        new WeatherRepository("Tallinn");
        assertEquals(WriteReadFile.readFile("output.txt"), WriteReadFile.readFile("outputrepo.txt"));
    }

}
