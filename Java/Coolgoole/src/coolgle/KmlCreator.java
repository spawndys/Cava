package coolgle;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import de.micromata.opengis.kml.v_2_2_0.AltitudeMode;
import de.micromata.opengis.kml.v_2_2_0.BalloonStyle;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.KmlFactory;
import de.micromata.opengis.kml.v_2_2_0.LineString;
import de.micromata.opengis.kml.v_2_2_0.LookAt;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;
import de.micromata.opengis.kml.v_2_2_0.Style;

public class KmlCreator 
{
	/**
	 * constructor for KmlCreator object
	 * Takes in an arraylist of locations and the name of a file that will turn into the kml file. 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws XPathExpressionException 
	 */
	
	public KmlCreator() 
	{
		//Nothing, use secondary Constructor 
	}
	
	public KmlCreator(ArrayList<Location> locations, String fileName) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
	{
		// Create an array of location names : 
		//ArrayList<String> Locations = new ArrayList<String>();
			
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
		
		// Name it whatever
		placemark1.setName("Path"); //We can change this later. 
		final LineString linestring1 = new LineString();
		placemark1.setGeometry(linestring1);
		linestring1.setExtrude(false);
		linestring1.setTessellate(true);
		List<Coordinate> coord1 = new ArrayList<Coordinate>();
		linestring1.setCoordinates(coord1);
		
		// Add each location to the path 
		for (int i = 0; i < locations.size(); i++)
		{
			coord1.add(new Coordinate(locations.get(i).getLongitude(),locations.get(i).getLatitude()));
		}
		
		// Create The KML File
		File newFile = new File (fileName);
		
		// Copy the data above into the file
		kml.marshal(newFile);
		
		// Open the File with it's default program
		if (Desktop.isDesktopSupported())  
		{
		    Desktop.getDesktop().open(newFile);
		}
		else
		{
			// If error opening file, post error message to console. 
			System.out.println("Error opening KML");
		}
	}
	/**
	 * locationMapping
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	
	
	public static final void main (String argv[]) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
	{
		// Make a new Geocoder to fill in Location Data
		Geocoder converter = new Geocoder();
		
		// Create locations arraylist to send into kmlCreator
		ArrayList<Location> testLocations = new ArrayList<Location>();
		
		/*
		// Read in the file
		BufferedReader br = new BufferedReader(new FileReader("Locations.txt"));
		String line;
		
		// Read file Location by location
		while ((line = br.readLine()) != null) 
		{
			//If Location isn't commented out in file (denoted by "#" on line in file)
			if (!line.startsWith("#"))
			{
				// Create a new location based on search term  
				Location newLocation = converter.createLocation(line);
				
				// If found, add to locations array
				if (newLocation.getName().compareTo("") != 0)
					testLocations.add(newLocation);
				
				// Testing, print out location information
				//System.out.println(newLocation);
			}
			try 
			{
			    Thread.sleep(150);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
		}
		
		// Close database file
		br.close();
		
		
		
		// Make the database file : 
		// Clear old contents of data
		PrintWriter writer = new PrintWriter("LocationDatabase.txt");
		writer.print("");
		// Add locations again : 
		for (int j = 0; j < testLocations.size(); j++)
		{
			testLocations.get(j).printToFile("LocationDatabase.txt");
		}
		System.out.println("Database Updated!");
		
		//Create the kml for that location array and open it 
		//KmlCreator kml = new KmlCreator(testLocations, "testKml.kml");
		*/
		
		// Read in Database File : 
		// Read in the file
		BufferedReader br2 = new BufferedReader(new FileReader("LocationDatabase.txt"));
		String locationString;
		ArrayList<Location> DatabaseLocations = new ArrayList<Location>();
		// Read file Location by location
		while ((locationString = br2.readLine()) != null) 
		{
			Location newLocation = new Location(locationString);
			DatabaseLocations.add(newLocation);
			System.out.println(newLocation);
		}
		
		
		// Testing Distance Function : 
		Location location1;
		Location location2;
		Random rand = new Random();
		
		for (int h = 0; h <= 10; h++)
		{
			int num1 = rand.nextInt(80);
			int num2 = rand.nextInt(80);
			
			location1 = DatabaseLocations.get(num1);
			location2 = DatabaseLocations.get(num2);
			double distanceBetween = Math.round(100 * location1.distanceTo(location2) ) / 100d; 
			System.out.println("Distance between " + location1.getName() + " and " + location2.getName() 
				+ " is " + distanceBetween + " miles. ");
		}
		
	}
}
