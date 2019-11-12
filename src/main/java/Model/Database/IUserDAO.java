package Model.Database;

import Model.DTO.User.UserDTO;

import javax.ws.rs.core.Response;

public interface IUserDAO {

    public Response createUser(UserDTO userDTO);

    public Response deleteUser(String userId);


    public Response getUser(String id);

}
