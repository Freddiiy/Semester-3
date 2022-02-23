package com.example.reststuff;

import com.example.reststuff.dto.CustomerDTO;
import com.example.reststuff.entity.Customer;
import com.example.reststuff.facade.CustomerFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customerasd")
public class Resource {
    CustomerFacade facade = new CustomerFacade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id")long id) {
        CustomerDTO customerDTO = facade.getCustomerById(id);

        return Response
                .ok()
                .entity(gson.toJson(customerDTO))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
        List<CustomerDTO> customerDTOList = facade.getAllCustomers();

        return Response
                .ok()
                .entity(gson.toJson(customerDTOList))
                .build();
    }

    @POST
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeCustomerById(@PathParam("id")long id) {
        facade.removeCustomerById(id);
        return Response
                .ok()
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(String jsonObject) {
        CustomerDTO c = gson.fromJson(jsonObject, CustomerDTO.class);
        facade.addCustomer(c);

        return Response
                .ok()
                .cookie(new NewCookie("newCustomer", c.getFirst()))
                .entity(gson.toJson(c))
                .build();
    }
}
