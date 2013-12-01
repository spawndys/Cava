//DistanceTo functions created with help from : http://www.geodatasource.com/developers/java

package coolgle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;

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
    private Coord coord; 

    private String address; 
    private String city; 
    private String state; 

    /**
     * Default Constructor for location object : 
     */
    public Location()
    {
            name = ""; 
            coord = new Coord(0,0);
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
            coord = new Coord(0,0);
            coord.setLatitude((Double.parseDouble(data[4])));
            coord.setLongitude((Double.parseDouble(data[5])));
    }

    //Secondary Constructor - Enter All 
    public Location(String name, double latitude, double longitude, String city, String state, String address)
    {
            this.name = name;
            coord = new Coord (latitude, longitude);
            this.city = city;
            this.state = state;
            this.address = address;
    }
    
    //Secondary Constructor - Enter All with a coord instead of a lat/long pair
    public Location(String name, Coord coords, String city, String state, String address)
    {
            this.name = name;
            coord = new Coord(coords.getLatitude(), coords.getLongitude());
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
            return coord.getLatitude();
    }
    public double getLongitude()
    {
            return coord.getLongitude();
    }


    public void setLongitude(double newLongitude)
    {
            coord.setLongitude(newLongitude);
    }
    public void setLatitude(double newLatitude)
    {
            coord.setLatitude(newLatitude);
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

    
    public boolean printToFile(String fileName)
    {
        return printToFile(fileName, true); 
    }
    
    
    // Returns true if no errors, false if otherwise
    public boolean printToFile(String fileName, boolean allowRepeats)
    {
        boolean success = true; 
        
        boolean alreadyInFile = false; 
        try 
        {
            // Check the file to see if the location already exists : 
            BufferedReader br;

            br = new BufferedReader(new FileReader("LocationDatabase.txt"));
            String locationString;
            while ((locationString = br.readLine()) != null)
            {
                Location newLocation = new Location(locationString);
                if (isSame(newLocation)) // The location already exists in the file. 
                {
                    alreadyInFile = true; 
                }
            }
            
            if (!alreadyInFile || (alreadyInFile && allowRepeats))
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.append(fileToString());
                writer.newLine();
                writer.close();
            }
            else // Already in file, don't add it again, show warning. 
            {
                JOptionPane.showMessageDialog(null, "This location is already in the file"
                                              , "Failure", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
        } 
        catch (FileNotFoundException e) 
        {	
             System.out.println("Could Not find database File ");
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
    
    public boolean isSame(Location otherLocation)
    {
        boolean same = true; 
        
        //We only check the lat and long in case they changed the name
        if ( coord.getLatitude() != otherLocation.getLatitude() )
            same = false;
        if ( coord.getLongitude() != otherLocation.getLongitude() )
            same = false; 
        
        return same;
    }
}
