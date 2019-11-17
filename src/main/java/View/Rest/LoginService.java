
package View.Rest;


import Model.DTO.User.UserDTO;
import Controller.UserController.JWTHandler;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("login")
public class LoginService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postLoginData(LoginData login){
        if (login!=null && "brian".equals(login.getUsername()) && "kodeord".equals(login.getPassword())){
            String answer = JWTHandler.generateJwtToken(new UserDTO(login.getUsername(), ""));
            return Response.ok().entity(answer).build();
        }
        throw new NotAuthorizedException("forkert brugernavn/kodeord");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("tokentest")
    public UserDTO postToken(String token){
        UserDTO validate = JWTHandler.validateToken(token);
        return validate;
    }

}

