package ifmo;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("discipline")
public class DisciplineServiceController {
    @EJB
    DisciplineService disciplineService;

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        disciplineService.delete(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Discipline update(Discipline discipline) {
        return disciplineService.update(discipline);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Discipline add(Discipline discipline) {
        return disciplineService.add(discipline);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public List<Discipline> findAll() {
        return disciplineService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    public Discipline findById(@PathParam("id") Long id) {
        return disciplineService.findById(id);
    }
}