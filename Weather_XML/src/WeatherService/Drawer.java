/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeatherService;

import Utilities.Location;
import Utilities.Weather;
import java.io.FileInputStream;
import static java.util.stream.DoubleStream.builder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

/**
 * This class draws the answer of OpenWeather (using XPath technology) from the XML file generated in the Request class
 * @author Martina Guarneri
 */
public class Drawer {
    //Void constructor
    public Drawer () {
    }
    
    public static Weather getWeatherData(Location location) throws ParserConfigurationException
    {
        //Attributes needed to XPath technology
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document weatherDocument;
        //It gets weather attributes using XPath technology
        Weather weather = new Weather (location);
        try {
            weatherDocument = builder.parse(new FileInputStream("openweather_answer.xml"));
            //Node path
            String Weather = "/current/clouds/@name";
            String Temperature = "/current/temperature/@value"; 
            String Humidity = "/current/humidity/@value"; 
            String Pressure = "/current/pressure/@value"; 
            XPath xPath =  XPathFactory.newInstance().newXPath();
            //It rescues attributes from their nodes
            weather.setWeather(xPath.compile(Weather).evaluate(weatherDocument));
            weather.setTemperature(Float.parseFloat(xPath.compile(Temperature).evaluate(weatherDocument)));
            weather.setHumidity(Float.parseFloat(xPath.compile(Humidity).evaluate(weatherDocument)));
            weather.setPressure(Float.parseFloat(xPath.compile(Pressure).evaluate(weatherDocument)));

        }
        catch(Exception ex)
        {
            
        }
        System.out.println(weather);
        return weather;
    }
}