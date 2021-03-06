package View.Rest;

import Model.DTO.User.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginService {

    @POST
    public String postLoginData(LoginData login) {

        if (login != null && "brian".equals(login.getUsername()) && "kodeord".equals(login.getPassword())) {
            String answer = JWTHandler.generateJwtToken(new UserDTO(login.getUsername(), ""));
            return answer;
        } else {
            throw new NotAuthorizedException("forkert brugernavn/kodeord");
        }
    }

    @POST
    @Path("tokentest")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response postToken(String token) {
        UserDTO validate = JWTHandler.validate(token);
        return Response.ok().entity(validate.toString()).build();
    }

}
