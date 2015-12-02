/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeocodingService;

import Utilities.Location;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * This class draws the Coordinates (using XPath technology) from the XML file generated in the Request class
 * @author Martina Guarneri
 */
public class Drawer {
    
    //Void constructor
    public Drawer () {
    }
    
    /*
        This static method draes the coordinates of the location from the XML file generated before.
        First it
    */
    public static Location drawLocation (Location location) throws FileNotFoundException, ParserConfigurationException
    {
        //Attributes needed to XPath technology
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document locationDocument;
        //It gets latitude and longitude using XPath technology
        try {
            //It opens the needed instance
            locationDocument =  builder.parse(new FileInputStream("google_answer.xml"));
            String LatitudeExpression = "/GeocodeResponse/result/geometry/location/lat/text()";
            String LongitudeExpression = "/GeocodeResponse/result/geometry/location/lng/text()";
            XPath xPath =  XPathFactory.newInstance ().newXPath ();
            //It reads latitude and longitude from their node using XPath
            float lat = Float.parseFloat (xPath.compile (LatitudeExpression).evaluate (locationDocument));
            float lon = Float.parseFloat (xPath.compile (LongitudeExpression).evaluate (locationDocument));
            //It adds latitude and longitude to the location
            location.setCoordinates (lat, lon);
            System.out.println (lat + " " + lon);//****DEBUG****************************************************************************
        } catch (Exception ex) {}
        return location;
    }
}
