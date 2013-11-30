//DistanceTo functions created with help from : http://www.geodatasource.com/developers/java

package coolgle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
public class Location 
{
    //class variables
    private String name;
    private char key;
    private double latitude;
    private double longitude;

    private String address; 
    private String city; 
    private String state; 

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

    //Enter line from database file
    public Location(String fileInput)
    {
            String[] data = fileInput.split("\\|");

            name = data[0]; 
            address =  data[1]; 
            city = data[2]; 
            state = data[3]; 
            latitude = (Double.parseDouble(data[4]));
            longitude = (Double.parseDouble(data[5]));
    }


    //Secondary Constructor - Enter All 
    public Location(String name, double latitude, double longitude, String city, String state, String address)
    {
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
            this.city = city;
            this.state = state;
            this.address = address;
    }


    // Standard Accessors and Mutators
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

    //Override of toString
    public String toString()
    {
        String returnString = "";
        returnString += "Name : " + getName() + "\n";
        returnString += "Address : " + getAddress() + "\n";
        returnString += "City : " + getCity() + "\n";
        returnString += "State : " + getState() + "\n";
        returnString += "Latitude : " + getLatitude() + "\n";
        returnString += "Longitude : " + getLongitude() + "\n";
        return returnString;
    }

    // toString for printing to database file
    public String fileToString()
    {
        String returnString = "";
        returnString += "" + getName() + "|";
        returnString += "" + getAddress() + "|";
        returnString += "" + getCity() + "|";
        returnString += "" + getState() + "|";
        returnString += "" + getLatitude() + "|";
        returnString += "" + getLongitude();
        return returnString;
    }

    // Returns true if no errors, false if otherwise
    public boolean printToFile(String fileName)
    {
        boolean success = true; 
        try 
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(fileToString());
            writer.newLine();
            writer.close();
        } 
        catch (FileNotFoundException e) 
        {	
             success = false;
        } 
        catch (IOException e) 
        {
             success = false;
        }
        return success;
    }

    //Returns the distance in miles between the two locations
    public double distanceTo(Location otherLocation)
    {
        double distance = 0.0;
        double lon1 = getLongitude(); 
        double lat1 = getLatitude(); 
        double lon2 = otherLocation.getLongitude(); 
        double lat2 = otherLocation.getLatitude(); 

        double theta = lon1 - lon2;
        distance = Math.sin(convertToRadians(lat1)) * Math.sin(convertToRadians(lat2)) + 
                   Math.cos(convertToRadians(lat1)) * Math.cos(convertToRadians(lat2)) * 
                   Math.cos(convertToRadians(theta));
        distance = Math.acos(distance);
        distance = convertToDegrees(distance);
        distance = distance * 60 * 1.1515;

        return distance;
    }

    private double convertToRadians(double degrees) 
    {
        return( degrees * Math.PI / 180.0 );
    }

    private double convertToDegrees(double radians) 
    {
        return( radians * 180 / Math.PI );
    }
}
