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
    private float temperature;
    private float temperatureMin;
    private float temperatureMax;
    private int humidity; //Percent %
    private int pressure; //hPa
    private float wind; //km/h
    private String windDirection;
    private int clouds;
    private int visibility;
    private String precipitation; //Yes or No
    
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
    
    
}
