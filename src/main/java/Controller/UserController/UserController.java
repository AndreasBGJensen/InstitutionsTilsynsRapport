package Controller.UserController;

import Model.DTO.Institutions.Institution;
import Model.Database.IInstitutionDAO;
import Model.Database.IUserDAO;
import Model.Database.InstitutionDAO;
import Model.Database.UserDAO;
import org.json.JSONObject;

import javax.ws.rs.core.Response;

public class UserController implements IUserController, IInstitutionDAO {

    private IUserDAO userDAO = new UserDAO();
    private IInstitutionDAO institutionDAO = new InstitutionDAO();


    @Override
    public Response createUser(JSONObject input) {
    return null;
    }

    @Override
    public Response userValidation(JSONObject input) {
        return null;
    }

    @Override
    public Response deleteUser(String input) {

        return userDAO.deleteUser(input) ;
    }



    @Override
    public Response getUser(String id) {
        return userDAO.getUser(id);
    }

    @Override
    public Response createInstitution(Institution institution) {
        return null;
    }

    @Override
    public Response getInstitution(String institutionId) {
        institutionDAO.getInstitution(institutionId);

        return null;
    }

    @Override
    public Response updateInstitution(String institutionId) {
        return null;
    }

    @Override
    public Response getAllInstitution(String institutionId) {
        return null;
    }
}
