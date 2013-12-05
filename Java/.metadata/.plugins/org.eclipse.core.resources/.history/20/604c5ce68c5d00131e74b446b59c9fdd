/*****************************************
 ** File: KMlCreator
 ** Team Name: Cava++
 *Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu,
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- To only be used by location class, stores a coordinate 
 *Which is a pair of lats and longs
 ***********************************************/
package coolgle;

public class Coord 
{
	private double latitude;
	private double longitude;
	/**
	 * Default Constructor for coord
	 */
	public Coord()
	{
		latitude = 0;
		longitude = 0;
	}

	/**
	 * Initialized Constructor for coord
	 * 
	 */

	public Coord(double latitude, double longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * Parsed Constructor for coord
	 * 
	 */
	public Coord(String latitude, String longitude) {
		this.latitude = Double.parseDouble(latitude);
		this.longitude = Double.parseDouble(longitude);
	}
	/**
	 * Description- getter for latitude
	 */
	public double getLatitude() 
	{
		return latitude;
	}
	/**
	 * Description- getter for longitude
	 */
	public double getLongitude() 
	{
		return longitude;
	}
	/**
	 * Description- setter for latitude
	 */
	public void setLatitude(double newLat) 
	{
		latitude = newLat;
	}
	/**
	 * Description- setter for longitude
	 */
	public void setLongitude(double newLong) 
	{
		longitude = newLong;
	}

	/**
	 * Description- overridden text file for toString method
	 */
	public String toString() 
	{
		String msg = String.format("%.05f", latitude) + " "+ String.format("%.05f", longitude);
		return msg;
	}

}