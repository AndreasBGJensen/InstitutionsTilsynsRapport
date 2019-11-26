package View.Rest;
import Controller.Controller;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.PRECONDITION_FAILED;


@Path("institution")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InstitutionAPI {

    Controller controller = new Controller();

    @POST
    public Response postLoginData(SearchParam search){
        System.out.println(search.toString());
        try {
            return Response.ok().entity(controller.getUserSearchInstitutionsFromDatabase(search.getVejnavn(), search.getPostNr())).build();
        }catch (Exception e) {
            return Response.status(INTERNAL_SERVER_ERROR).entity("Somthing happen").build();
        }
        }

}
