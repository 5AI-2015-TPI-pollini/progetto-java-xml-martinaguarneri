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
        //It initializes a printer to creates a XML file with the request's answer
        PrintWriter printer = new PrintWriter (new FileOutputStream ("google_answer.xml"));
        
        //START OF THE CONNECTION
        //It creates a ner URL getting it from the location
        URL url = new URL (location.toURL());
        //It opens a connection through the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        
        //READING
        //Thanks to the BufferedReader it reads line by line saving them in a XML file
        BufferedReader read = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        //It creates a line and then scans all the others untill there aren't more lines
        String line;
        String html = ""; //****DEBUG***************************************************************************************************************
        do {
            line = read.readLine ();
            html += line; //****DEBUG********************************************************************************************************
            printer.println(line);
            line = read.readLine();
        } while (line != null);
        
        //END OF THE CONNECTION
        //It closes the XML printer
        printer.close();
        System.out.println(html);//****DEBUG********************************************************************************************************
    }
}
