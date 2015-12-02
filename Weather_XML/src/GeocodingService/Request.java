/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeocodingService;

import Utilities.Location;
import static com.oracle.webservices.internal.api.EnvelopeStyle.Style.XML;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
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
    //XML Printer
    PrintWriter printer;
    
    //Constructor
    public Request (Location location) throws MalformedURLException, FileNotFoundException
    {
        //It saves the location
        this.location = location;
        //It gets the url from the location
        url = new URL (location.toURL());
        //It initializes the printer and then it creates the XML file with the answer
        printer = new PrintWriter (new FileOutputStream ("google_answer.xml"));
    }
    
    /*
        This method makes the Http request and converts the answer in a XML file.
        First it opens the connection with the Google's Service, then it reads the answer line by line.
        Lastly it create a XML file with the answer.
    */
    public void get () throws IOException
    {
        //It opens a connection through the URL builded in the Constructor
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        //Thanks to the BufferedReader it reads line by line saving them in a XML file
        BufferedReader read = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        //It creates a line and then scans all the others till there aren't more lines
        String line;
        String html = ""; //****DEBUG***************************************************************************************************************
        do {
            line = read.readLine ();
            html += line;
            printer.println(line);
            line = read.readLine();
        } while (line != null);
        //It closes the XML printer
        printer.close();
        System.out.println(html);//****DEBUG********************************************************************************************************
    }
}
