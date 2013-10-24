package coolgle;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	 * constructor for SEARCH object
	 */
	public KmlCreator(){
		
	}
	/**
	 * locationMapping
	 * Description- 
	 * Pre- 
	 * Post -
	 */
	
	
	public static final void main (String argv[]) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException
	{
		
		//Name of the KML it will create
		String FileName = "CreatedKML.kml";
		
		// Create an array of location names : 
		ArrayList<String> Locations = new ArrayList<String>();
		
		// Read in the file
		BufferedReader br = new BufferedReader(new FileReader("Locations.txt"));
		String line;
		while ((line = br.readLine()) != null) 
		{
			Locations.add(line);
		}
		br.close();

		// Turn the array of location names into a lat/lng array using the GetData Class:  
		GetData converter = new GetData();
		ArrayList<String> coords = new ArrayList<String>();
		for (int i = 0; i < Locations.size(); i++)
		{
			coords.add(converter.getData(Locations.get(i)));
		}
		
		// Create the kml object and document object to edit it
		final Kml kml = new Kml();
		final Document document = new Document();
		kml.setFeature(document);

		// Set the FileName of the document
		document.setName(FileName);
		document.setOpen(true);

		// Create a new Path
		final Placemark placemark1 = new Placemark();
		document.getFeature().add(placemark1);
		
		// Name it whatever
		placemark1.setName("Path");
		final LineString linestring1 = new LineString();
		placemark1.setGeometry(linestring1);
		linestring1.setExtrude(false);
		linestring1.setTessellate(true);
		List<Coordinate> coord1 = new ArrayList<Coordinate>();
		linestring1.setCoordinates(coord1);
		
		// Add each location to the path 
		for (int i = 0; i < Locations.size(); i++)
		{
			if (coords.get(i).compareTo("") == 0)
				System.out.println("Cannot Find Location : " + Locations.get(i));
			else
				coord1.add(new Coordinate(coords.get(i)));
		}
		
		// Create The KML File
		File newFile = new File (FileName);
		
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
}
