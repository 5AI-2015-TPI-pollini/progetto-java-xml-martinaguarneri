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
    private String postal_code;
    private String country;
    private float latitude;
    private float longitude;
    
    //Constructor
    public Location (String address, String route, String locality, String postal_code, String country)
    {
        this.address = address;
        this.route = route;
        this.locality = locality;
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
    
    //This method returns the Address
    public String getAddress ()
    {
        return address;
    }
    
    /*
        This method converts the location attributes in the URL needed to make HTTP request to Google's Geocoding Service.
        It replaces the spaces in the attributes with "+" and then it adds the attributes in the asked form.
    */
    public String toURL ()
    {
        //It creates a copy of the url to not modify the common URL part
        String url = "https://maps.googleapis.com/maps/api/geocode/xml?";
        String temp = "";
        
        //ADDRESS
        //Replaces the address spaces with "+" to convert the String to URL standards then it adds it to URL
        if (address != "")
        {
            temp = address;
            temp = temp.replace(' ', '+');
            url += "address=" + temp;
        }
        
        //COMPONENTS
        //This IF block checkes if there is any component in the Location. Then it adds it in the URL standard
        if (route != "" || locality != "" ||  postal_code != "")
        {
            /*
                This flag is needed to know if the parameter is the first component.
                If it is not, it is necessary put the pipeline separator "|" before adding it to the URL.
            */
            boolean first = true;
            url += "&components=";
            //route
            if (route != "")
            {
                first = false;
                temp = route;
                temp = temp.replace(' ', '+');
                temp = "route:" + temp;
                url += temp;
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
                url += temp;
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
                url += temp;
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
                url += temp;
            }
        }
        //It returns the obtained URL which contains the address and (if there are) the contents.
        return url;
    }
    
    /*
        This method converts the coordinates in the URL needed to make HTTP request to OpenWeather.
    */
    public String toWeatherURL ()
    {
        String url = "http://api.openweathermap.org/data/2.5/weather?";
        return url + "lat=" + latitude + "&lon=" + longitude + "&units=metric&appid=017ce450c780e94c3e2c08895a8cac92&mode=xml";
    }
}
