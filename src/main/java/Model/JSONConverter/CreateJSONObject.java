package Model.JSONConverter;

import Model.DTO.Institutions.Institution;
import Model.DTO.User.UserDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONObject implements IJSONobjects {

    Object convert;
    JSONObject object = new JSONObject();
    JSONArray array = new JSONArray();
    JSONObject institutionJSON = new JSONObject();

    CreateJSONObject(Object object) {
        convert = object;
    }


    public JSONObject JSONcreate() {

        //Using Gson to make a JsonString compatable to a JSONobject
        Gson adapter = new Gson();

        return new JSONObject(adapter.toJson(convert));

    }

    @Override
    public JSONObject institutionJSON() {
        return null;
    }

    @Override
    public JSONObject userJSON(UserDTO user) {
        return null;
    }
}
