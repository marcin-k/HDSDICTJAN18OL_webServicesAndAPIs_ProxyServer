/*
 * Api can be accessed by using the url: http://localhost:49000/api/proxy/<city_name>
 * by replacing the city_name with actual value e.g.:
 * http://localhost:49000/api/proxy/london
 *
 * ​openweathermap API key: 372d50605bd8dc374d5f835f3c731ad8
 */
package com.mycompany.proxy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; 
import javax.ws.rs.core.Response;
					
@Path("/proxy") 
public class Tester {
					
  @GET
  @Path("/{param}")
  public Response sayHelloWorld(@PathParam("param") String city) {
    String url = "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&mode=json&appid=372d50605bd8dc374d5f835f3c731ad8";
    System.out.println("-----------------------\n"+url+"-----------------------\n");
    WeatherConnection myWeather = new WeatherConnection();
    String output = myWeather.getResponse(url);

    return Response.status(200).entity(output).build(); 
  }
					
}

