package weather;

import files.WriteReadFile;

public class Main {
    public static void main(String[] args) throws Exception{

        for (String cityName : new WriteReadFile().readFile("../input.txt").split("\n")) {
            new WeatherRequest(cityName).writeOutput("praks4/src/cityInfos/");
        }
    }
}
