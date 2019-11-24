package Model.Database;


import Model.DTO.Institutions.Vuggestue;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public interface IInstitutionDAO {

    public Response createInstitution(Vuggestue institution);

    public Response getInstitution(String institutionId);

    public Response updateInstitution(String institutionId);

    public Response getAllInstitution(String institutionId);

    public int checkInstance(String navn);

}
