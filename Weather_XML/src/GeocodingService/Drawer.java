/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeocodingService;

import Utilities.Location;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.xpath.XPath;

/**
 * This class draws the Coordinates (using XPath technology) from the XML file generated in the Request class
 * @author Martina Guarneri
 */
public class Drawer {
    //Void constructor
    public Drawer () {
    }
    
    /*
        This static method draes the coordinates of the location from the XML file generated before.
        First it
    */
    public static void draw (Location location) throws FileNotFoundException
    {
        //It initializes the BufferedReader that it will use to read the XML file.
        BufferedReader reader = new BufferedReader (new FileReader ("google_answer.xml"));
    }
}
