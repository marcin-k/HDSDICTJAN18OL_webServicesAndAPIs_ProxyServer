package com.mycompany.proxy;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author marcin
 */
public class WeatherConnection {
    
//    couldnt get that to work
//    final String DEGREE  = "\u2103";
	
    public String getResponse(String url) {
        
        Client client = ClientBuilder.newClient();
        Response rs = client.target(url)
                .request()
                .get();
        //Stores json that comes from weather server as a string
        String jsonString = rs.readEntity(String.class);
        
        //parsing the string version of json to json Object 
        //using google's gson library
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject)jsonParser.parse(jsonString);
        
                       //parse city name
        String reply = jo.get("city").getAsJsonObject()
                .get("name").getAsString()+" "+
//                //country 
                jo.get("city").getAsJsonObject().get("country").getAsString()+" "+
                //date and time
                jo.get("list").getAsJsonArray().get(0).getAsJsonObject()
                        .get("dt_txt").getAsString()+" "+
                //describtion of the weather
                jo.get("list").getAsJsonArray().get(0).getAsJsonObject()
                        .getAsJsonArray("weather").get(0).getAsJsonObject()
                        .get("main").getAsString()+" ("+
                 
                jo.get("list").getAsJsonArray().get(0).getAsJsonObject()
                        .getAsJsonArray("weather").get(0).getAsJsonObject()
                        .get("description").getAsString()+") temperature: "+
                
                jo.get("list").getAsJsonArray().get(0).getAsJsonObject()
                        .get("main")
                        .getAsJsonObject()
                        .get("temp")
                        .getAsString()+" "
                +  "degree C";
                        

        
        return reply;
                

    }
    
}
