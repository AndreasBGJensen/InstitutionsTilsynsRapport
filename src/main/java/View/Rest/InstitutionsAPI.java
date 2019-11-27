package View.Rest;
import Controller.Controller;
import Model.DTO.SearchParam;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;


@Path("institution")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InstitutionsAPI {

    Controller controller = new Controller();


    //TODO: Changing Response to some other datatype
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postLoginData(SearchParam search){
        System.out.println(search.toString());
        try {
            return Response.ok().entity(controller.getUserSearchInstitutionsFromDatabase(search.getVejnavn(), search.getPostNr())).build();
        }catch (Exception e) {
            return Response.status(INTERNAL_SERVER_ERROR).entity("Somthing happen").build();
        }
    }


    @GET
    public String deepUpdateDatabase(SearchParam search){
        return controller.updateInstitutionQuery(search.getVejnavn(),search.getPostNr());

    }

}
