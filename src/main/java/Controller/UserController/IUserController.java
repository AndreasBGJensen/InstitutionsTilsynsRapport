package Controller.UserController;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.Response;

public interface IUserController {


    Response createUser(JSONObject input);

    Response userValidation(JSONObject input);


    Response deleteUser(String id);

    Response getUser(String id);

}
