/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 * This class represent a single location with all its attributes.
 * It can convert them in the URL needed to make HTTMP request to Google's Geocoding Service.
 * @author 70060402
 */
public class Location {
    //Location attributes
    private String address;
    private String route;
    private String locality;
    private String administrative_area;
    private String postal_code;
    private String country;
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
    
    /*
        This method converts the location attributes in the URL needed to make HTTP request to Google's Geocoding Service.
        It replaces the spaces in the attributes with "+" and then it adds the attributes in the asked form.
    */
    public String toURL ()
    {
        //It creates a copy of the url to not modify the common URL part
        String tempURL = url;
        //Replaces the address spaces with "+" to convert the String to URL standards then it adds it to URL
        if (address != "")
        {
            tempURL += "address=" + address;
        }
        //This IF block checkes if there is any component in the Location. Then it adds it in the URL standard
        if (route != "" || locality != "" || administrative_area != "" || postal_code != "")
        {
            /*
                This flag is needed to know if the parameter is the first component.
                If it is not, it is necessary put the pipeline separator "|" before adding it to the URL.
            */
            String temp = "";
            boolean first = true;
            tempURL += "&components=";
            if (route != "")
            {
                first = false;
                temp = route;
                temp.replace(" ", "+");
                temp = "route:" + temp;
                tempURL += temp;
            }
        
            if (locality != "")
            {
                temp = locality;
                temp.replace(" ", "+");
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
        return url;
    }
}
