package com.example.reststuff;

import com.example.reststuff.entity.Customer;
import com.example.reststuff.facade.CustomerFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.glassfish.jersey.internal.inject.Custom;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
public class Resource {
    CustomerFacade facade = new CustomerFacade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getCustomerById(@PathParam("id")long id) {
        Customer c = facade.getCustomerById(id);

        return Response
                .ok()
                .entity(gson.toJson(c))
                .build();
    }

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Response getAllCustomers() {
        List<Customer> customerList = facade.getAllCustomers();

        return Response
                .ok()
                .entity(gson.toJson(customerList))
                .build();
    }

    @POST
    @Path("/remove/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response removeCustomerById(@PathParam("id")long id) {
        facade.removeCustomerById(id);

        return Response
                .ok()
                .build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addCustomer(String jsonObject) {
        Customer c = gson.fromJson(jsonObject, Customer.class);
        facade.addCustomer(c);

        return Response
                .ok()
                .cookie(new NewCookie("newCustomer", c.getFirstName()))
                .entity(gson.toJson(c))
                .build();
    }
}
