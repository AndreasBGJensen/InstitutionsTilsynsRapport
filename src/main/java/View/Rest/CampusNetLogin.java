package View.Rest;

import View.Rest.JWTHandler;
import Model.DTO.User.UserDTO;
import View.Rest.Exceptions.NotAuthorizedException;
import io.jsonwebtoken.JwtHandler;
import kong.unirest.Unirest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("campusnet")
public class CampusNetLogin {

    @GET
    @Path("login")
    public Response login() {
        String URI = "https://auth.dtu.dk/dtu/?service=http://localhost:8080/rest/campusnet/redirect";
        return Response.seeOther(UriBuilder.fromUri(URI).build()).build();
    }

    @GET @Path("redirect")
    public Response callback(@QueryParam("ticket") String cnTicket){
        System.out.println(cnTicket); //Check if we got something back
        //Tjek ticket mod CampusNet
        String body = Unirest.get( "https://auth.dtu.dk/dtu/validate?service=http://localhost:8080/rest/campusnet/redirect&ticket="
                + cnTicket)
                .asString()
                .getBody();

        if ("yes".equals(body.split("\n")[0])){
            String userID = body.split("\n")[1];
            String token = JWTHandler.generateJwtToken(new UserDTO(userID, ""));
            return Response.seeOther(UriBuilder.fromUri("http://localhost:3000/?token="+ token).build()).build();
        }
        return login();
    }

}
