package View.Rest;
import Controller.Controller;
import Controller.UserController.IUserController;
import Controller.UserController.UserController;
import View.Rest.Exceptions.NoImplementationException;
import View.Rest.Exceptions.NoImplementationExceptionMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("mongo/institutions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InstitutionAPI {

    Controller controller = new Controller();

    GET

}
