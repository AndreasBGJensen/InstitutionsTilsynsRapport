package Model.Database;

import Model.DTO.Institutions.Institution;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public interface IInstitutionDAO {

    public Response createInstitution(Institution institution);

    public Response getInstitution(String institutionId);

    public Response updateInstitution(String institutionId);

    public Response getAllInstitution(String institutionId);

}
