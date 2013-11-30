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
import java.io.UnsupportedEncodingException;
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
public class Geocoder 
{   
        public Geocoder()
        {
            //placeholder
        }
    
        public Location createLocation(String name) 
        {
            Location location = new Location();
            try
            {
                
                // URL prefix to the geocoder 
                final String GEOCODER_REQUEST_PREFIX_FOR_XML= "http://maps.google.com/maps/api/geocode/xml";

                System.out.println("Searching For  : " + name);

                // prepare a URL to the geocoder
                URL url = new URL(GEOCODER_REQUEST_PREFIX_FOR_XML + "?address=" + URLEncoder.encode(name, "UTF-8") + "&sensor=false");

                // prepare an HTTP connection to the geocoder
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                Document geocoderResultDocument = null;

                //try
                // open the connection and get results as InputSource.
                conn.connect();
                InputSource geocoderResultInputSource = new InputSource(conn.getInputStream());

                // read result and parse into XML Document
                geocoderResultDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(geocoderResultInputSource);

                //finally 

                conn.disconnect();


                // prepare XPath
                XPath xpath = XPathFactory.newInstance().newXPath();

                // extract the result
                NodeList resultNodeList = null;
                resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result/formatted_address", geocoderResultDocument, XPathConstants.NODESET);

                if (resultNodeList.getLength() == 0)
                {	
                    // Err : No location Found from search term
                }
                else 
                {
                    // Get Name Of Location
                    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/address_component/short_name", geocoderResultDocument, XPathConstants.NODESET);
                    if (resultNodeList.item(0) != null)
                            location.setName(resultNodeList.item(0).getTextContent());

                    String address = "";
                    // Get Street Number Of Location
                    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/address_component[type/text()='street_number']/long_name", geocoderResultDocument, XPathConstants.NODESET);
                    if (resultNodeList.item(0) != null)
                            address = resultNodeList.item(0).getTextContent() + " ";

                    // Get Route Of Location - combine with street number to get address
                    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/address_component[type/text()='route']/long_name", geocoderResultDocument, XPathConstants.NODESET);
                    if (resultNodeList.item(0) != null)
                    {
                            address += resultNodeList.item(0).getTextContent();
                            location.setAddress(address);
                    }

                    // Get City Of Location
                    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/address_component[type/text()='locality']/long_name", geocoderResultDocument, XPathConstants.NODESET);
                    if (resultNodeList.item(0) != null)
                            location.setCity(resultNodeList.item(0).getTextContent());

                    // Get State Of Location
                    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/address_component[type/text()='administrative_area_level_1']/long_name", geocoderResultDocument, XPathConstants.NODESET);
                    if (resultNodeList.item(0) != null)
                            location.setState(resultNodeList.item(0).getTextContent());

                    // Get Lat/Long
                    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/geometry/location/lat", geocoderResultDocument, XPathConstants.NODESET);
                    if (resultNodeList.item(0) != null)
                            location.setLatitude(Double.parseDouble(resultNodeList.item(0).getTextContent()));

                    resultNodeList = (NodeList) xpath.evaluate("/GeocodeResponse/result[1]/geometry/location/lng", geocoderResultDocument, XPathConstants.NODESET);
                    if (resultNodeList.item(0) != null)
                    location.setLongitude(Double.parseDouble(resultNodeList.item(0).getTextContent()));
                } // End else
            } // End try
            catch (IOException e)
            {
                  System.out.println("IOException");  
            }
            catch (XPathExpressionException e)
            {
                  System.out.println("XPathExpressionException");  
            }
            catch(ParserConfigurationException e)
            {
                   System.out.println("ParserConfigurationException");  
            }
            catch(SAXException e)
            {
                   System.out.println("SAXException");  
            }
            //catch(UnsupportedEncodingException e)
            //{
            //       System.out.println("UnsupportedEncodingException");  
            //}
        return location;
    } // end of createLocation method
} //End of Geocoder

