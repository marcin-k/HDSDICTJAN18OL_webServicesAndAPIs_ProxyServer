# HDSDICTJAN18OL_webServicesAndAPIs_ProxyServer
Overview
Develop an API proxy for acquiring weather data, you will be acting as a proxy server 
as defined to be “a server that acts as an intermediary for requests from clients seeking resources from other servers”.

Step 1 
The user will make a request to your application specifying a city (a GET). 
Your appointed method on the server will make a client connection to 
http://openweathermap. org/forecast​ to acquire the data and return it to the client, as such 
your application acts as an intermediary.
Step 2 
You will need to sign up to acquire an API key to the openweathermap.org site.
Step 3
The specific URL you will access to get the information should be 
http://api.openweathermap.org/data/2.5/forecast?q=[INSERT CITY]&mode=json&appid=[INSERT API ID]
Step 4 
For this task you can use Jersey HTTP Clients on your server side and client side.
Example:
Input in your browser http://api.openweathermap.org/data/2.5/forecast?q=DUBLIN&mode=json&appid=Xj667TMlp4topMGN
