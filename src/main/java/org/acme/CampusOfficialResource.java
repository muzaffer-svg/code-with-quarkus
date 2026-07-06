package org.acme;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;


@Path("/api/officials")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CampusOfficialResource {

    @GET
    public List<CampusOfficial> getAllOfficials() {
        return CampusOfficial.listAll();
    }

    @POST
    @Transactional
    public Response createOfficial(CampusOfficial official) {
        official.persist();
        return Response.status(Response.Status.CREATED).entity(official).build();
    }
}

