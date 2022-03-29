package com.fredoku.countryrestproxy.resource;

import com.fredoku.countryrestproxy.type.Country;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Helo";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountry(@PathParam("name") String name) {
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

            return Response
                    .ok()
                    .entity(jsonString)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response
                .status(404)
                .build();
    }

}
