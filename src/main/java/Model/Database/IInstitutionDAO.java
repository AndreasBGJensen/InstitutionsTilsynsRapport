package Model.Database;

import Model.DTO.Institutions.Institution;
import Model.DTO.Institutions.Vuggestue;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

public interface IInstitutionDAO {

    public Response createInstitution(Vuggestue institution);

    public Response getInstitution(String institutionId);

    public Response updateInstitution(String institutionId);

    public Iterable<Vuggestue>  getAllInstitution();

    public int checkInstitution(String navn);

    public int removeInstitution(String navn);

}
