/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.Date;

/**
 * This class represent a single weather result.
 * It is the answer of OpenWeather server and it is associated to the location of the weather.
 * @author Martina Guarneri
 */
public class Weather {
    //Attributes of the Location weather
    private String weather;
    private float temperature;
    private float humidity; //Percent %
    private float pressure; //hPa
    
    //Location
    private Location location;
    
    //Constructor
    public Weather (Location location)
    {
        this.location = location;
    }
    
    //This method allows to save the answer of OpenWeather for the given location.
    public void setResults (String climateCondition, float temperature)
    {
        this.temperature = temperature;
    }
        
    //Set weather description
    public void setWeather (String w)
    {
        weather = w;
    }
    
    //Set temperature
    public void setTemperature (float t)
    {
        temperature = t;
    }
    
    //Set humidity
    public void setHumidity (float h)
    {
       humidity = h;
    }
    
    //Set pressure
    public void setPressure (float p)
    {
        pressure = p;
    }
    
    //To string method
    public String toString ()
    {
        return location.getAddress() + " "+ weather + " " + temperature + "°C " + humidity + "% " + pressure + "hPa.";
    }
}
