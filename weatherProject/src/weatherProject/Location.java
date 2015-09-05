package weatherProject;

public class Location implements Comparable{

	private String city;
	private String country;
	
	public Location() {

	}

	public Location(String country,String city) {
		this.city=city;
		this.country=country;
	}


	@Override
	public String toString() {
		return "Country:" + country +", \nCity:"+ city;
	}

	String getCity() {
		return city;
	}

	String getCountry(){
		return country;
	}

	String getData (){
		return country + "%20" + city;
	}

	void setData (String country,String city){
		this.city=city;
		this.country=country;
	}


	public boolean compareTo(Location location) {
		if (this.city.toLowerCase().compareTo(location.getCity().toLowerCase())==0)
			return true;
		else 
			return false;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}