/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather_xml;

//Imports for HTTP requests
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
public class Weather_XML {
    //address=santa+cruz&components=postal_code:89898|country:ES
    //ZERO_RESULTS
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {
        //OpenWeather parameters
        double latitude;
        double longitude;
        
        //Creation of URLS
        URL googleServiceURL;
        URL openWeatherURL;
        
        //Scan of the place
        String temp_address = "";
        String temp_locality = "locality:";
        String temp_postal_code = "postal_code:";
        String temp_country = "country:";
        /*
            Two possibility:
            1) Just the address that can contain a road or a city or anything
            2) Address and components
            User makes the choiche through graphic interface
        */
        
    }
    
}
