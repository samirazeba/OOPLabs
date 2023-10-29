package Week4.Lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WhetherForecaster {
    private Random random;

    public WhetherForecaster() {
        this.random = new Random();
    }
    public String forecastWhether() {
        double probability = this.random.nextDouble();

        if (probability <= 0.1) {
            return "Sleet";
        } else if (probability <= 0.4) {
            return "Snow";
        } else {
            return "Sunny";
        }
    }
    public int forecastTemperature() {
        return (int)(4 * this.random.nextGaussian() - 3);
    }

    public static void main(String[] args) {
        WhetherForecaster whetherForecaster = new WhetherForecaster();
        ArrayList<String> days = new ArrayList<String>();
        Collections.addAll(days, "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        System.out.println("Weather forecast for the next week:");
        for (String day : days) {
            String forecast = whetherForecaster.forecastWhether();
            int temperatureForecast = whetherForecaster.forecastTemperature();

            System.out.println(day + ": " + forecast + "  " + temperatureForecast + " degrees.");
        }

    }
}
