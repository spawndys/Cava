/*****************************************
 ** File: KmlCreator
 ** Team Name: Cava++
 ** Date: 10/18/13
 ** E-mail: 
 ** Daniel Brandes <bradan1@umbc.edu>, 
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- Used to create the kml file and display the data in google earth
 **             Once a arraylist of the places the user wishes to visit is created. 

// Additional: To be used after user hits map it button, takes a search and actually 
 * maps it on google earth
// Example use : - 
// KmlCreator newKml = new KmlCreator("Search1.kml");
// newKml.openKml(newKml.FillKml(search));
*/

package coolgle;

import de.micromata.opengis.kml.v_2_2_0.AltitudeMode;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;
import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class KmlCreator 
{
    // Name of kml file - set in constructor
    private String fileName; 

    private static final int SPEED = 55; // In miles / hour
    
    /**
     * KmlCreator
     * Description - constructor for kmlCreator
     * Parameter - name you want the file to be called. Ex : "newKML.kml"
     */
    public KmlCreator(String file) 
    {
        fileName = file; 
    }


    /**
     * FillKml
     * Description - Creates a path in the kml file with points given in input search object. 
     * Parameters - Search ojbect 
     * Return - Kml File, of type File. Must import java.io.File to use it outside this class. 
     * Pre - Arraylist in search has at least 1 mid location, a start location, and a end location
     *       All locations in list have valid latitude and longitude. 
     *       Note : Search should be optimized. 
     * 
     * Post -kml file is ready to be sent into the openKml function. 
     */
    public File FillKml(Search search) 
    { 
        // Grab information from search 
        ArrayList<Location> locations = search.getMidLocations();

        // Create The KML File
        File newFile = new File(fileName);
        try 
        {   
            // Create the kml object and document object to edit it
            final Kml kml = new Kml();
            final Document document = new Document();
            kml.setFeature(document);

            // Set the FileName of the document
            document.setName(fileName);
            document.setOpen(true);

            // Create a new Path
            final Placemark placemark1 = new Placemark();
            document.getFeature().add(placemark1);

            // Naming 
            placemark1.setName("Shortest Path"); 
            final LineString linestring1 = new LineString();
            placemark1.setGeometry(linestring1);
            linestring1.setExtrude(false);
            linestring1.setTessellate(true);
            
            List<Coordinate> coord1 = new ArrayList<Coordinate>();

            // Add Start location to path
            coord1.add(new Coordinate(search.getStart().getLongitude(),search.getStart().getLatitude()));
            
            // Add each Mid location to the path
            for (int i = 0; i < locations.size(); i++)
            {
                coord1.add(new Coordinate(locations.get(i).getLongitude(),locations.get(i).getLatitude()));
            }

            // Add End location to path
            coord1.add(new Coordinate(search.getEnd().getLongitude(),search.getEnd().getLatitude()));
            
            linestring1.setCoordinates(coord1);
            
            // Add pointers to each location to display more information about them. 
            double time = search.getStartTime(); 
            int distance = 0; 
            
            // Points for the  Locations
            
            // For this, we will add the starting and ending locations to our arraylist of mid locations.
            locations.add(0,search.getStart());
            locations.add(locations.size(),search.getEnd());
            int i = 0;
            for ( i = 0; i < locations.size(); i++ ) 
            {
                double newDist = 0;
                if (i > 0)
                    newDist = locations.get(i).distanceTo(locations.get(i-1));
                distance += Math.round(newDist);
                if ( newDist != 0 )
                    time += (newDist / SPEED);
                
                document.createAndAddStyle()
                .createAndSetBalloonStyle();
                
                Placemark placemark = document.createAndAddPlacemark()
                .withName(locations.get(i).getName() + " (" + i + ")") //This is the name that shows when you're not clicked in on it. 
                .withDescription("Estimated Arrival Time :  <br> " + printTime(time)
                                  + "<br>Distance Traveled : <br> " + distance + " miles");

                Point point = placemark.createAndSetPoint();
                List<Coordinate> coord = point.createAndSetCoordinates();
                coord.add( coord1.get(i) ); 
            }
            
            // Copy the data above into the file
            kml.marshal(newFile);

        } 
        catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "KML - FileNotFoundException", "Failure", JOptionPane.ERROR_MESSAGE); 
        } 

        return newFile; 
    }


    /**
     * openKml
     * Description - Opens the kml file in Google earth
     * Parameters - File to be opened, should be the same as the file returned by FillKml function. 
     * Pre - Google earth is installed on end users computer. 
     * Post -Google Earth will be opened, centered in the path. 
     */
    public void openKml(File kmlFile)
    {
        // Open the File with it's default program
        if (Desktop.isDesktopSupported())
        {
            try 
            {
                Desktop.getDesktop().open(kmlFile);
            }
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(null, "KML - IOException", "Failure", JOptionPane.ERROR_MESSAGE); 
            }
        }
        else
        {
            // If error opening file, post error message to console.
            JOptionPane.showMessageDialog(null, "Cannot open KML file", "Failure", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    
    /**
     * printTime
     * Description - Gives a nicely formatted time string
     * Parameters - int time from search, for example, 8.50 ( = 8:30 AM)
     * Return - string msg for example : 8:30 AM
     * Pre - Google earth is installed on end users computer. 
     * Post -Google Earth will be opened, centered in the path. 
     */
    public String printTime( double timeToPrint)
    {
        String msgTime = "";
        
        String AMPM = "AM";
        
        // If time is over a day, return to miliary time again
        if (timeToPrint >= 24)
             timeToPrint = timeToPrint % 24; 
        // Get Hours : 
        double hours = Math.floor(timeToPrint); 
        if (hours > 12)
        {
            AMPM = "PM";
            hours -= 12;
            timeToPrint -= 12; 
        }
        if (hours == 12)
            AMPM = "PM";
        if (hours == 12)
        {
            AMPM = "AM";
            hours = 12;
        }
        
        DecimalFormat df = new DecimalFormat("00");
        
        // Get Minutes : 
        timeToPrint -= hours; // Just get minute part
        double mins = timeToPrint; 
        mins *= 60;
        DecimalFormat df2 = new DecimalFormat("00");
        
        msgTime = df.format(hours) + ":" + df2.format(mins) + " " + AMPM;     
        
        return msgTime;
    }
}
