package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Fakultet;
import repository.FakultetRepository;

import java.util.List;

@Path("/fakultet/")
public class FakultetResource {

    @Inject
    private FakultetRepository fakultetRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addFakultet")
    public Response addFakultet(Fakultet fakultet) {
        Fakultet f = fakultetRepository.createFakultet(fakultet);
        return Response.ok(f).entity(f).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllFakultet")
    public Response getAllFakultet() {
        List<Fakultet> fakultetList = fakultetRepository.getAllFakultet();
        return Response.ok().entity(fakultetList).build();
    }
}
