package weather;

import java.io.ByteArrayInputStream;

public class Main {
    public static void main(String[] args) {

        ByteArrayInputStream stream = new ByteArrayInputStream("y\ntallinn".getBytes());
        System.setIn(stream);
        WeatherRequest wr = new WeatherRequest();
    }
}
