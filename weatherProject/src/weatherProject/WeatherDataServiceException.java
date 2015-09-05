package weatherProject;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WeatherDataServiceException extends Exception{
	private Location location;
	public WeatherDataServiceException(){
		System.out.println("City not Found");	
		String message = "Wrong City";
		JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
				JOptionPane.ERROR_MESSAGE);
	}

	public WeatherDataServiceException(Location location){
		this.location = location;
		if(location.getCity().length()==0)
		{
			String message = "City is empty";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
					JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			System.out.println("City not Found");	
			String message = "Wrong City";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
					JOptionPane.ERROR_MESSAGE);
		}
	} 
	public Location getCheak(){
		return location;
	}
}
