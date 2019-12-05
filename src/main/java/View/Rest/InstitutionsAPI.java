package View.Rest;

import Controller.Controller;
import Model.DTO.Institutions.Vuggestue;
import Model.DTO.SearchParam;
import View.Rest.Exceptions.DbException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("institution")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InstitutionsAPI {

    Controller controller = new Controller();

    //TODO: Changing Response to some other datatype
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Vuggestue> postLoginData(SearchParam search) throws DbException {   //TODO: right way to to this by throwing exception here?
        System.out.println(search.toString());
        return controller.getUserSearchInstitutionsFromDatabase(search.getVejnavn(), search.getPostNr());

//        try {
//            return controller.getUserSearchInstitutionsFromDatabase(search.getVejnavn(), search.getPostNr());
//        } catch (Exception e) {
//            return Response.status(INTERNAL_SERVER_ERROR).entity("Somthing happen").build();
//        }
    }

    @Path("update")
    @POST
    public String deepUpdateDatabase(SearchParam search) {
        System.out.println(search.toString());
        return controller.updateInstitutionQuery(search.getVejnavn(), search.getPostNr());
    }

    @Path("/all")
    @GET
    public Iterable<Vuggestue> getAllVuggestuer() {

        return controller.getAllInstitutions();
    }
}
