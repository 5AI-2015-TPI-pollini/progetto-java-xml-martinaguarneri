/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

//Imports for HTTP requests
import GeocodingService.Request;
import Utilities.Location;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
/*
//Imports for XPath Technology
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
*/

/**
 * UTILITIES:
 * Google API Key: AIzaSyCL451yjk5RnQUKn7QC0TyXEIro8za-Awk
 * https://maps.googleapis.com/maps/api/geocode/xml?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyCL451yjk5RnQUKn7QC0TyXEIro8za-Awk
 * 
 * @author 70060402
 */
public class TestClass {
    //address=santa+cruz&components=postal_code:89898|country:ES
    //ZERO_RESULTS
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        Location location = new Location ("gussago", "", "", "", "", "");
        Request richiesta = new Request(location);
        richiesta.get();
        /*
            Two possibility:
            1) Just the address that can contain a road or a city or anything
            2) Address and components
            User makes the choiche through graphic interface
        */
    }
    
}
