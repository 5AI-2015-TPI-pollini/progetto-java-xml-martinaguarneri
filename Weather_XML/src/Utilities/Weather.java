/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 * This class represent a single weather result.
 * It is the answer of OpenWeather server and it is associated to the location of the weather.
 * @author Martina Guarneri
 */
public class Weather {
    //Attributes of the Location weather
    private String climateCondition;
    private float temperature;
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
        this.climateCondition = climateCondition;
        this.temperature = temperature;
    }
}
