package View.Rest;

import Controller.UserController.JWTHandler;
import Model.DTO.User.UserDTO;
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
    public Response login(){
        String URI =  "https://auth.dtu.dk/dtu/?service=http://localhost:8080/rest/campusnet/redirect";
        return Response.seeOther(UriBuilder.fromUri(URI).build()).build();
    }
    @GET @Path("redirect")
    public String callback(@QueryParam("ticket") String cnTicket){
        System.out.println(cnTicket); //Check if we got something back
        //Tjek ticket mod CampusNet
        String body = Unirest.get( "https://auth.dtu.dk/dtu/validate?service=http://localhost:8080/rest/campusnet/redirect&ticket="
                + cnTicket)
                .asString()
                .getBody();

        System.out.println("This is the body " +body);
        return body; //Just return the result for now
    }

}
