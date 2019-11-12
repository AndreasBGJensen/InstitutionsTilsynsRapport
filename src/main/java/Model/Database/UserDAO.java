package Model.Database;

import Model.DTO.User.IUserDTO;
import Model.DTO.User.UserDTO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.util.JSON;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.json.JSONObject;



import javax.ws.rs.core.Response;

public class UserDAO implements IUserDAO {


    //Creating a user in the database.

    @Override
    public Response createUser(UserDTO userDTO) {
        try {
            Jongo jongo = new Jongo(MongoConnector.getInstance());
            MongoCollection users = jongo.getCollection("Users");
            users.save(userDTO);

            JSONObject json = new JSONObject();
            json.put("code", "1");
            json.put("message", "The user have been stored in the database");

            return Response.ok().entity(json.toString()).build();
        }catch (Exception e){
            JSONObject json = new JSONObject();
            json.put("code","-1");
            json.put("message","Something wen wrong in the database operation");
            return Response.ok().entity(json.toString()).build();
        }
    }


    /*
    Getting the user from the database
     */

    @Override
    public Response getUser(String id){

        try {
        Jongo jongo = new Jongo(MongoConnector.getInstance());
        MongoCollection users = jongo.getCollection("Users");
        IUserDTO test = users.findOne("{userId: '"+id+"'}").as(UserDTO.class);

//Creating a response if the user does not exist in the database
        if (test==null){
            JSONObject error = new JSONObject();
            error.put("code",-1);
            error.put("message", "This user does not exist");

            return Response.ok().entity(error.toString()).build();
        }
        else {
            //Creating Json object to get a json string format in the response.
            JSONObject json = new JSONObject();
            json.put("navn",test.getName());
            json.put("userId",test.getUserID());

            System.out.println(json.toString());

            return Response.ok().entity(json.toString()).build();
        }
        }catch (Exception e){
            JSONObject json = new JSONObject();
            json.put("code","-1");
            json.put("message","Something wen wrong in the database operation");
            return Response.ok().entity(json.toString()).build();
        }
    }

    /*
    Method deletes a user when requested
     */

    @Override
    public Response deleteUser(String userId){

        try {
            Jongo jongo = new Jongo(MongoConnector.getInstance());
            MongoCollection users = jongo.getCollection("Users");
            users.remove("{userId: '" + userId + "'}");
            JSONObject json = new JSONObject();
            json.put("code", 1);
            json.put("Message", "User id" + userId + " is deletet");


            return Response.ok().entity(json.toString()).build();
        }catch (Exception e){
            JSONObject json = new JSONObject();
            json.put("code","-1");
            json.put("message","Something wen wrong in the database operation");
            return Response.ok().entity(json.toString()).build();
        }
    }

}
