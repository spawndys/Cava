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
***********************************************/
// To be used after user hits map it button
// Example use : 
//  - Create several Locations, add them to a arraylist named testLocations - 
// KmlCreator newKml = new KmlCreator("Search1.kml");
// newKml.openKml(newKml.FillKml(testLocations));


package coolgle;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

public class KmlCreator 
{
    // Name of kml file - set in constructor
    private String fileName; 

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
     * Description - Creates a path in the kml file with points given in input arraylist
     * Parameters - arraylist of locations to add to the kml
     * Return - Kml File, of type File. Must import java.io.File to use it outside this class. 
     * Pre - Arraylist has at least 2 locations in it, all locations in list have valid latitude and longitude. 
     *       Note : Assumes locations are in sorted order, first location first, last last, and mid locations
     *              in order to create the shortest path between the first and last hitting them all. 
     * Post -kml file is ready to be sent into the openKml function. 
     */
    public File FillKml(ArrayList<Location> locations) 
    {
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

            // Add each location to the path
            for (int i = 0; i < locations.size(); i++)
            {
                coord1.add(new Coordinate(locations.get(i).getLongitude(),locations.get(i).getLatitude()));
            }

            linestring1.setCoordinates(coord1);
            
            // Add placemarks to show the arrival time
            
            
            // Copy the data above into the file
            kml.marshal(newFile);

        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("FileNotFoundException");
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
                System.out.println("IOException");
            }
        }
        else
        {
            // If error opening file, post error message to console.
            System.out.println("Error opening KML");
        }
    }
}
