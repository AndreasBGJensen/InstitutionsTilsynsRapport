package Controller.UserController;

import Model.DTO.Institutions.Vuggestue;
import Model.Database.IInstitutionDAO;
import Model.Database.IUserDAO;
import Model.Database.InstitutionDAO;
import Model.Database.UserDAO;
import View.Rest.Exceptions.DbException;
import org.json.JSONObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

        return userDAO.deleteUser(input);
    }

    @Override
    public Response getUser(String id) {
        return userDAO.getUser(id);
    }

    @Override
    public void createInstitution(Vuggestue institution) {
        throw new NotImplementedException();
    }

    @Override
    public Vuggestue getInstitution(String institutionId) throws DbException {
        Vuggestue institution = institutionDAO.getInstitution(institutionId);
        if (institution != null) {
            return institution;
        } else {
            throw new DbException("Institution " + institutionId + " not found.");
        }
    }

    @Override
    public void updateInstitution(String institutionId) {
        throw new NotImplementedException();
    }

    @Override
    public Iterable<Vuggestue> getAllInstitution() {
        return null;
    }

    @Override
    public int checkInstitution(String navn) {
        return 0;
    }

    @Override
    public void removeInstitution(String navn) {
    }
}
