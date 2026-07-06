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
import jakarta.ws.rs.PathParam;
import java.util.UUID;


@Path("/api/studentss")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CampusStudentResource {

    @GET
    public List<Student> getAllStudents() {
        return Student.listAll();
    }

    @Path("/{id}")
    @GET
    public Student getStudentById(@PathParam("id") UUID id) {
        return Student.findById(id);
    }


    @POST
    @Transactional
    public Response createStudent(Student student) {
        student.persist();
        return Response.status(Response.Status.CREATED).entity(student).build();
    }
}
