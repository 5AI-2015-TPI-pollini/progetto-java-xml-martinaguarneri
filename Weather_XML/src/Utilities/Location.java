/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 * This class represent a single location with all its attributes.
 * It can convert them in the URL needed to make HTTMP request to Google's Geocoding Service.
 * @author Martina Guarneri
 */
public class Location {
    //Location attributes
    private String address;
    private String route;
    private String locality;
    private String administrative_area;
    private String postal_code;
    private String country;
    private float latitude;
    private float longitude;
    //This is the URL common part fot all the possible location
    private String url = "https://maps.googleapis.com/maps/api/geocode/xml?";
    
    //Constructor
    public Location (String address, String route, String locality, String administrative_area, String postal_code, String country)
    {
        this.address = address;
        this.route = route;
        this.locality = locality;
        this.administrative_area = administrative_area;
        this.postal_code = postal_code;
        this.country = country;
    }
    
    //This method sets latidute and longitude
    public void setCoordinates (float lat, float lon)
    {
        latitude = lat;
        longitude = lon;
    }
    
    //This method returns latitude
    public float getLatitude ()
    {
        return latitude;
    }
    
    //This method returns longitude
    public float getLongitude ()
    {
        return longitude;
    }
    
    
    /*
        This method converts the location attributes in the URL needed to make HTTP request to Google's Geocoding Service.
        It replaces the spaces in the attributes with "+" and then it adds the attributes in the asked form.
    */
    public String toURL ()
    {
        //It creates a copy of the url to not modify the common URL part
        String tempURL = url;
        String temp = "";
        
        //ADDRESS
        //Replaces the address spaces with "+" to convert the String to URL standards then it adds it to URL
        if (address != "")
        {
            temp = address;
            temp = temp.replace(' ', '+');
            tempURL += "address=" + temp;
        }
        
        //COMPONENTS
        //This IF block checkes if there is any component in the Location. Then it adds it in the URL standard
        if (route != "" || locality != "" || administrative_area != "" || postal_code != "")
        {
            /*
                This flag is needed to know if the parameter is the first component.
                If it is not, it is necessary put the pipeline separator "|" before adding it to the URL.
            */
            boolean first = true;
            tempURL += "&components=";
            //route
            if (route != "")
            {
                first = false;
                temp = route;
                temp = temp.replace(' ', '+');
                temp = "route:" + temp;
                tempURL += temp;
            }
            //locality
            if (locality != "")
            {
                temp = locality;
                temp = temp.replace(' ', '+');
                if (first)
                {
                    temp = "locality:" + temp;
                    first = false;
                }
                else
                {
                    temp = "|locality:" + temp;
                }
                tempURL += temp;
            }
            //administrative area
            if (administrative_area != "")
            {
                temp = administrative_area;
                if (first)
                {
                    temp = "administrative_area:" + temp;
                    first = false;
                }
                else
                {
                    temp = "|administrative_area:" + temp;
                }
                tempURL += temp;
            }
            //postal code
            if (postal_code != "")
            {
                temp = postal_code;
                if (first)
                {
                    temp = "postal_code:" + temp;
                    first = false;
                }
                else
                {
                    temp = "|postal_code:" + temp;
                }
                tempURL += temp;
            }
            //country
            if (country != "")
            {
                temp = country;
                if (first)
                {
                    temp = "country:" + temp;
                    first = false;
                }
                else
                {
                    temp = "|country:" + temp;
                }
                tempURL += temp;
            }
        }
        //It returns the obtained URL which contains the address and (if there are) the contents.
        return tempURL;
    }
}
