/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeatherService;

import Utilities.Location;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This class makes the HTTP request to OpenWeather Service and then returns the XML answer.
 * @author Martina Guarneri
 */
public class Request {
    public Request () {
    }
    
    public static void get (Location location) throws IOException
    {
        //Connection Start
        //It creates the url from the location then it opens a connection through it
        URL url = new URL (location.toWeatherURL()); 
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        //Reading
        //It reads the answer through a BufferedReader and it writes it in a XML file using a PrintWriter
        String line;
        BufferedReader reader = new BufferedReader (new InputStreamReader (connection.getInputStream ()));
        PrintWriter printer = new PrintWriter (new FileOutputStream ("openweather_answer.xml"));
        while ((line = reader.readLine()) != null)
        {
            printer.println(line);
        }
        
        //Connection End
        printer.close();
        reader.close();
    }
}
