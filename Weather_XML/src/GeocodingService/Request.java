/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeocodingService;

import Utilities.Location;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class makes the HTTP request to the Google's Geocoding Service and then returns the XML answer.
 * @author Martina Guarneri
 */
public class Request { 
    //Void constructor
    public Request (){ 
    }
    
    /*
        This static method makes the Http request and converts the answer in a XML file.
        First it creates the URL form the location. Then it opens the connection with the Google's Service and reads the answer line by line.
        Lastly it creates a XML file with the answer.
    */
    public static void get (Location location) throws IOException
    {
        //Connection Start
        //It creates the url from the location then it opens a connection through it
        URL url = new URL (location.toURL()); 
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        
        //Reading
        //It reads the answer through a BufferedReader and it writes it in a XML file using a PrintWriter
        String line;
        BufferedReader reader = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        PrintWriter printer = new PrintWriter (new FileOutputStream ("google_answer.xml"));
        while ((line = reader.readLine()) != null)
        {
            printer.println(line);
        }
        
        //Connection End
        printer.close();
        reader.close();
    }
}
