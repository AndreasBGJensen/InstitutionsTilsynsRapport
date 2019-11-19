package View.Rest;

import Controller.UserController.JWTHandler;
import Model.DTO.User.UserDTO;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("campusnet")
public class CampusNetLogin {

    @GET
    @Path("login")
    public Response login(){
        String URI =  "https://auth.dtu.dk/dtu/?service=http://localhost:8080/rest/campusnet/redirect";
        return Response.seeOther(UriBuilder.fromUri(URI).build()).build();
    }

}
