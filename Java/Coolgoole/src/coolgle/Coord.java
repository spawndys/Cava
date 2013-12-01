//Merge Notes : 
//Changed the lat and long field here to doubles istead of floats. 

package coolgle;

public class Coord 
{
	private double latitude;
	private double longitude;
	
	public Coord()
        {
              latitude = 0;
              longitude = 0;
        }
        
        public Coord(double latitude, double longitude)
        {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() 
        {
		return latitude;
	}

	public double getLongitude() 
        {
		return longitude;
	}
        
        public void setLatitude(double newLat) 
        {
            latitude = newLat;
        }
        
        public void setLongitude(double newLong) 
        {
            longitude = newLong;
        }
        
        
	public String toString() 
        {
		String msg = String.format("%.05f", latitude) + " "+ String.format("%.05f", longitude);
		return msg;
	}
	
}