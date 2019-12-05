package Model.Database;

import Model.DTO.User.UserDTO;

import javax.ws.rs.core.Response;

public interface IUserDAO {

    Response createUser(UserDTO userDTO);

    Response deleteUser(String userId);

    Response getUser(String id);
}
