package coolgle;
/*****************************************
 ** File: Location
 ** Team Name: Cava++
 *Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu, 
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- Class that represents a location for a search
***********************************************/
public class Location {
	//class variables
	private String name;
	private char key;
	private double latitude;
	private double longitude;
	
	private String address; 
	private String city; 
	private String state; 
	
	
	/**
	 * getKey()
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	
	/**
	 * Default Constructor for location object : 
	 */
	public Location()
	{
		name = ""; 
		latitude = 0.0;
		longitude = 0.0;
		city = "";
		state = "";
		address = "";
	}
	
	//Secondary Constructor
	public Location(String name, double latitude, double longitude, String city, String state, String address)
	{
		name = this.name;
		latitude = this.latitude;
		longitude = this.longitude;
		city = this.city;
		state = this.state;
		address = this.address;
	}
	
	
	public String getName()
	{
		return name;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public String getAddress()
	{
		return address;
	}
	public double getLatitude()
	{
		return latitude;
	}
	public double getLongitude()
	{
		return longitude;
	}
	
	
	public void setLongitude(double newLongitude)
	{
		longitude = newLongitude;
	}
	public void setLatitude(double newLatitude)
	{
		latitude = newLatitude;
	}
	public void setName(String newName)
	{
		name = newName;
	}
	public void setCity(String newCity)
	{
		city = newCity;
	}
	public void setState(String newState)
	{
		state = newState;
	}
	public void setAddress(String newAddress)
	{
		address = newAddress;
	}
	
	
}
