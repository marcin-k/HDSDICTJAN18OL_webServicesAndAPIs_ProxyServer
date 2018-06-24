package com.mycompany.proxy;


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
    
	
    public String getResponse(String url) {
        Client client = ClientBuilder.newClient();
        Response rs = client.target(url)
                .request()
                .get();
        //TODO: change the String to JSON or a class based on the response
        String str = rs.readEntity(String.class);
        return str;

    }
    
}
