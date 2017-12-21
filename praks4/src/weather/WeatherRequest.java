package weather;

import files.WriteReadFile;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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

    public WeatherRequest() {}

    public WeatherRequest(String cityName) {
        this.cityName = cityName;

        JSONObject weatherForecast = new JSONObject(getWebsiteContent(
                "http://api.openweathermap.org/data/2.5/forecast?q=" + cityName +
                        "&units=metric&APPID=6fc96a79f789482d605329f9b119921e"));
        JSONObject currentWeather = new JSONObject(getWebsiteContent(
                "http://api.openweathermap.org/data/2.5/weather?q=" + cityName +
                        "&units=metric&APPID=6fc96a79f789482d605329f9b119921e"));
        parseJson(weatherForecast, currentWeather);
    }

    public void writeOutput(String outputLocation) {
        new WriteReadFile().writeToFile(outputLocation + cityName + ".txt", parseOutput());
    }

    public String parseOutput() {
        JSONObject cityInfoOutput = new JSONObject();
        JSONObject cityInfo = new JSONObject();

        cityInfo.put("city", cityName);
        cityInfo.put("coordinates", coordinates);
        cityInfo.put("CurrentTemp", currentTemp);
        cityInfoOutput.put("city", cityInfo);

        JSONObject forecast = new JSONObject();
        JSONObject dayOne = new JSONObject();
        dayOne.put("MaxTemp", dayOneMaxTemp);
        dayOne.put("MinTemp", dayOneMinTemp);
        forecast.put("DayOne", dayOne);

        JSONObject dayTwo = new JSONObject();
        dayTwo.put("MaxTemp", dayTwoMaxTemp);
        dayTwo.put("MinTemp", dayTwoMinTemp);
        forecast.put("DayTwo", dayTwo);

        JSONObject dayThree = new JSONObject();
        dayThree.put("MaxTemp", dayThreeMaxTemp);
        dayThree.put("MinTemp", dayThreeMinTemp);
        forecast.put("DayThree", dayThree);
        cityInfoOutput.put("ThreeDayForecast", forecast);

        return cityInfoOutput.toString();
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

    public void parseJson(JSONObject weatherForecast, JSONObject weatherCurrent) {

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
