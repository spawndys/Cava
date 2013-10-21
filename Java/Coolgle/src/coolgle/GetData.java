// NOTE : 
// Google's API is javascript based, in order for us to use java, 
// I found a library we can use that has the same functionally in java : 
// https://code.google.com/p/geocoder-java/
// Example based on this code :  
// https://code.google.com/p/gmaps-samples/source/browse/trunk/geocoder/java/GeocodingSample.java?r=2476

package coolgle;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/*****************************************
 ** File: Gui
 ** Team Name: Cava++
 *Date: 10/18/13
 ** E-mail: Daniel Brandes bradan1@umbc.edu, 
 ** Lizset Chavez <lizset1@umbc.edu>
 ** Patrick Ritchie <ritc1@umbc.edu>,
 ** Xiaofei He <xiaofei2@umbc.edu>,
 ** Yo-Han Kim <ykim18@umbc.edu>,
 ** Jim Millican <jmill1@umbc.edu>
 ** Decription- Patricks Test File to get data from Google. 
***********************************************/
public class GetData 
{
	  public String getData(String search) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException 
	  {
		String returnString = "";
		  
		// URL prefix to the geocoder
		final String GEOCODER_REQUEST_PREFIX_FOR_XML = "http://maps.google.com/maps/api/geocode/xml";
		  
		// query address
	    String address = search;

	    System.out.println("Searching For  : " + address);
	    
	    // prepare a URL to the geocoder
	    URL url = new URL(GEOCODER_REQUEST_PREFIX_FOR_XML + "?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=false");

	    // prepare an HTTP connection to the geocoder
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	    Document geocoderResultDocument = null;
	    try 
	    {
	      // open the connection and get results as InputSource.
	      conn.connect();
	      InputSource geocoderResultInputSource = new InputSource(conn.getInputStream());

	      // read result and parse into XML Document
	      geocoderResultDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(geocoderResultInputSource);
	    } 
	    finally 
	    {
	      conn.disconnect();
	    }

	    // prepare XPath
	    XPath xpath = XPathFactory.newInstance().newXPath();

	    // extract the result
	    NodeList resultNodeList = null;
	    
	    // a) obtain the formatted_address field for every result
	    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result/formatted_address", geocoderResultDocument, XPathConstants.NODESET);
	    
	    if (resultNodeList.getLength() == 0)
	    {	
	    	System.out.println("ERROR : No location Found");
	    }
	    else //If location Found
	    {
		    //Print exact name of first location, assuming there is one
		    System.out.println("Exact Location : " + resultNodeList.item(0).getTextContent());
	
		    // b) extract the locality for the first result
		    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/address_component[type/text()='locality']/long_name", geocoderResultDocument, XPathConstants.NODESET);
		    System.out.println("City Found : " + resultNodeList.item(0).getTextContent());
		
		    // c) extract the coordinates of the first result
		    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/geometry/location/*", geocoderResultDocument, XPathConstants.NODESET);
		    float lat = Float.NaN;
		    float lng = Float.NaN;
		    
		    for(int i=0; i<resultNodeList.getLength(); ++i) 
		    {
		    	Node node = resultNodeList.item(i);
		    	if("lat".equals(node.getNodeName())) 
		    		lat = Float.parseFloat(node.getTextContent());
		    	if("lng".equals(node.getNodeName())) 
		    		lng = Float.parseFloat(node.getTextContent());
		    }
		    System.out.println("Latitude : " + lat + "\nLongitude : " + lng + "\n");
		    returnString += "" + lng + "," + lat + ",0";
	    }
		return returnString;
	  }
}
