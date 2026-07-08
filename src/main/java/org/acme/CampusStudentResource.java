package org.acme;

import jakarta.annotation.security.PermitAll;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
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
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/studentss")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CampusStudentResource {


    @Inject
    JsonWebToken jwt;

    @GET
    public List<CampusStudent> getAllStudents() {
        return CampusStudent.listAll();
    }

    @Path("/{id}")
    @GET
    public CampusStudent getStudentById(@PathParam("id") UUID id) {
        return CampusStudent.findById(id);
    }


    @POST
    @Transactional
    public Response createStudent(CampusStudent student) {
        student.persist();
        return Response.status(Response.Status.CREATED).entity(student).build();
    }


   @POST
    @Path("/login")
    @PermitAll
    public Response loginStudent(CampusStudent loginData) {

        System.out.println("GİRİŞ DENEMESİ -> İsim: '" + loginData.name + "', Numara: '" + loginData.studentNumber + "'");
        
        CampusStudent foundStudent = CampusStudent.find("name = ?1 and studentNumber = ?2", loginData.name, loginData.studentNumber).firstResult();

        if (foundStudent != null) {
            
            String token = Jwt.issuer("kampus-sistemi")
                              .upn(foundStudent.name) 
                              .groups("Ogrenci") 
                              .claim("studentNumber", foundStudent.studentNumber) 
                              .expiresIn(3600) 
                              .sign(); 

            return Response.ok(token).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("İsim veya öğrenci numarası hatalı!").build();
        }
    }


    
    @GET
    @Path("/profil")
    @RolesAllowed("Ogrenci") 
    public Response getProfil() {
        
      
        String isim = jwt.getName();
        String numara = jwt.getClaim("studentNumber");
        
        String mesaj = "Başarıyla giriş yaptın " + isim + " (" + numara + "). Bu metni sadece geçerli bir JWT'ye sahip olduğun için görüyorsun!";
        
        return Response.ok(mesaj).build();
    }

}
    
