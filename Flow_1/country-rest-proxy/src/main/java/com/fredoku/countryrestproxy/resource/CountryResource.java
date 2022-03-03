package com.fredoku.countryrestproxy.resource;

import com.fredoku.countryrestproxy.type.Country;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@Path("/country")
public class CountryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Helo";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountry(@PathParam("name") String name) {
        Country country = new Country();
        try {
            URL url = new URL("https://restcountries.com/v3.1/alpha/" + name);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("ACCEPT", MediaType.APPLICATION_JSON);
            Scanner scanner = new Scanner(urlConnection.getInputStream());
            String jsonString = null;

            if (scanner.hasNext()) {
                jsonString = scanner.nextLine();
            }
            scanner.close();
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; //TODO replace this stub to something useful
    }

}
