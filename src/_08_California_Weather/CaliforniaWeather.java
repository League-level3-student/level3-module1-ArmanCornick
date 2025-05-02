package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton searchCity;
	JButton searchWeather;
	JButton searchTemp;
	HashMap<String, WeatherData> weatherData;
	CaliforniaWeather(){
		frame = new JFrame();
		panel = new JPanel();
		searchCity = new JButton();
		searchWeather = new JButton();
		searchTemp = new JButton();
		frame.add(panel);
		panel.add(searchCity);
		panel.add(searchWeather);
		panel.add(searchTemp);
		searchCity.setText("Search by city name");
		searchWeather.setText("Search by city weather");
		searchTemp.setText("Search by temperature range");
		frame.setVisible(true);
		searchCity.addActionListener(this);
		searchWeather.addActionListener(this);
		searchTemp.addActionListener(this);
	}


	void start() {
		weatherData = Utilities.getWeatherData();

		// All city keys have the first letter capitalized of each word
		String cityName = Utilities.capitalizeWords( "National City" );
		WeatherData datum = weatherData.get(cityName);

		if( datum == null ) {
			System.out.println("Unable to find weather data for: " + cityName);
		} else {
			System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}
	}


	@Override
	public void actionPerformed(ActionEvent z) {
		// TODO Auto-generated method stub
		if(z.getSource()==searchTemp) {
			
		}
		if(z.getSource()==searchWeather) {
			String list = "Cities with this weather include:\n";
			String weather = Utilities.capitalizeWords(JOptionPane.showInputDialog("Name selected weather condition"));
			for(String e : weatherData.keySet()) {
				if(weatherData.get(e).weatherSummary.equalsIgnoreCase(weather)) {
					list += e + ", ";
				}
			}
			JOptionPane.showMessageDialog(null, list);
		}
		if(z.getSource()==searchCity) {
			String city = Utilities.capitalizeWords(JOptionPane.showInputDialog("Name selected city"));
			if(weatherData.containsKey(city)) {
				JOptionPane.showMessageDialog(null, city + " is " + weatherData.get(city).weatherSummary + ", with a temperature of " + weatherData.get(city).temperatureF + " F.");
			}
		}
	}
}
