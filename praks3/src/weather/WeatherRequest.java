package weather;

import files.WriteReadFile;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class WeatherRequest {

    private double currentTemp;
    private double dayOneMaxTemp;
    private double dayOneMinTemp;
    private double dayTwoMaxTemp;
    private double dayTwoMinTemp;
    private double dayThreeMaxTemp;
    private double dayThreeMinTemp;
    private String cityName;
    private String coordinates;

    public WeatherRequest() {
        this.cityName = WriteReadFile.readFile("input.txt");
        getUserInput();
        parseJson();
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Currently selected city - " + WriteReadFile.readFile("input.txt"));
        System.out.println("Type 'Y' to change the city name");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Enter city name");
            this.cityName = scanner.nextLine();
            WriteReadFile.writeToFile("input.txt", cityName);
        }
    }


    private String getWebsiteContent(String websiteURL){
        String websiteContent = "";
        try {
            URL url = new URL(websiteURL);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                websiteContent += inputLine;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return websiteContent;
    }

    private void parseJson() {
        JSONObject weatherForecast = new JSONObject(getWebsiteContent(
                "http://api.openweathermap.org/data/2.5/forecast?q=" + cityName +
                        "&units=metric&APPID=6fc96a79f789482d605329f9b119921e"));

        JSONObject weatherCurrent = new JSONObject(getWebsiteContent(
                "http://api.openweathermap.org/data/2.5/weather?q=" + cityName +
                        "&units=metric&APPID=6fc96a79f789482d605329f9b119921e"
        ));

        WriteReadFile.writeToFile("output.txt",
                weatherCurrent.toString() + "\r\n" + weatherForecast.toString());

        currentTemp = weatherCurrent.getJSONObject("main").getDouble("temp");
        dayOneMaxTemp = weatherForecast.getJSONArray("list").getJSONObject(0)
                .getJSONObject("main").getDouble("temp_max");

        dayOneMinTemp = weatherForecast.getJSONArray("list").getJSONObject(0)
                .getJSONObject("main").getDouble("temp_min");

        dayTwoMaxTemp = weatherForecast.getJSONArray("list").getJSONObject(1)
                .getJSONObject("main").getDouble("temp_max");

        dayTwoMinTemp = weatherForecast.getJSONArray("list").getJSONObject(1)
                .getJSONObject("main").getDouble("temp_min");

        dayThreeMaxTemp = weatherForecast.getJSONArray("list").getJSONObject(2)
                .getJSONObject("main").getDouble("temp_max");

        dayThreeMinTemp = weatherForecast.getJSONArray("list").getJSONObject(2)
                .getJSONObject("main").getDouble("temp_min");

        cityName = weatherForecast.getJSONObject("city").getString("name");

        coordinates = weatherForecast.getJSONObject("city").getJSONObject("coord").getDouble("lat")
                + ":" + weatherForecast.getJSONObject("city").getJSONObject("coord").getDouble("lon");
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public double getDayOneMaxTemp() {
        return dayOneMaxTemp;
    }

    public double getDayOneMinTemp() {
        return dayOneMinTemp;
    }

    public double getDayTwoMaxTemp() {
        return dayTwoMaxTemp;
    }

    public double getDayTwoMinTemp() {
        return dayTwoMinTemp;
    }

    public double getDayThreeMaxTemp() {
        return dayThreeMaxTemp;
    }

    public double getDayThreeMinTemp() {
        return dayThreeMinTemp;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCoordinates() {
        return coordinates;
    }
}
