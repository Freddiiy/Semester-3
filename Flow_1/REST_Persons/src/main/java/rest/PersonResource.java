package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import entities.Person;
import errorhandling.PersonNotFoundException;
import facades.PersonFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
public class PersonResource {
    private static PersonFacade personFacade;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id")int id) {
        PersonDTO personDTO = personFacade.get(id);
        if (personDTO == null) return Response.status(404).build();

        return Response
                .ok()
                .entity(gson.toJson(personDTO))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<PersonDTO> personDTOList = personFacade.getAll();
        if (personDTOList == null) return Response.status(404).build();

        return Response
                .ok()
                .entity(personDTOList)
                .build();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(String jsonObject) {
        PersonDTO personDTO = gson.fromJson(jsonObject, PersonDTO.class);
        PersonDTO returnedPersonDTO = personFacade.add(personDTO);
        if (returnedPersonDTO == null) return Response.status(404).build();

        return Response
                .ok()
                .entity(returnedPersonDTO)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
        PersonDTO personDTO = personFacade.delete(id);
        if (personDTO == null) return Response.status(404).build();

        return Response
                .ok()
                .entity(gson.toJson(personDTO))
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("id") int id, String jsonObject) {
        PersonDTO personDTO = personFacade.get(id);
        PersonDTO jsonPerson = gson.fromJson(jsonObject, PersonDTO.class);
        if (personDTO == null) return Response.status(404).build();
        if (jsonPerson == null) return Response.status(400).build();

        personDTO.setFirstname(jsonPerson.getFirstname());
        personDTO.setLastname(jsonPerson.getLastname());
        personDTO.setPhone(jsonPerson.getPhone());
        personFacade.edit(personDTO);

        return Response
                .ok()
                .entity(gson.toJson(personDTO))
                .build();
    }
}
