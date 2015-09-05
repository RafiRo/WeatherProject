package weatherProject;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherController {

	weatherView theView;
	WeatherDataService theModel;

	public WeatherController(weatherView theView, WeatherDataService theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addListener(new buttonListener());
	}


	class  buttonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Location location = new Location(theView.countryText.getText(),theView.cityText.getText());
			theModel.getWeatherData(location, theView.bGroup.getSelection().getActionCommand());
			theView.resoultText.setText(theModel.weatherData.toString()+" "+theModel.type);
			theView.setWeatherIcon(theModel.picture);
		}	
	}
}
