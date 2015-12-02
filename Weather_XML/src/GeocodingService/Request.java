/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeocodingService;

import Utilities.Location;
import static com.oracle.webservices.internal.api.EnvelopeStyle.Style.XML;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.text.Document;

/**
 * This class makes the HTTP request to the Google's Geocoding Service and then returns the XML answer.
 * @author Martina Guarneri
 */
public class Request {
    //Connection attributes
    private HttpURLConnection connection;
    private URL url;
    //Location
    private Location location;
    //XML document
    private Document xml;
    
    public Request (Location location) throws MalformedURLException
    {
        this.location = location;
        url = new URL (location.toURL());
    }
    
    
    public void get () throws IOException
    {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        BufferedReader read = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        String line = read.readLine ();
        String html = "";
        while (line!=null) {
            html += line;
            line = read.readLine ();
        }
        System.out.println(html);
    }
}
