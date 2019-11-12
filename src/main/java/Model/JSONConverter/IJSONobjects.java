package Model.JSONConverter;

import Model.DTO.Institutions.Institution;
import Model.DTO.User.UserDTO;
import org.json.JSONObject;

public interface IJSONobjects {

    public JSONObject institutionJSON();

    public JSONObject userJSON(UserDTO user);

}
