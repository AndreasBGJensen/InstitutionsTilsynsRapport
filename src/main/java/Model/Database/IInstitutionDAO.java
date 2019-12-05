package Model.Database;

import Model.DTO.Institutions.Vuggestue;
import View.Rest.Exceptions.DbException;

public interface IInstitutionDAO {

    public void createInstitution(Vuggestue institution) throws DbException;

    public Vuggestue getInstitution(String institutionId) throws DbException;

    public void updateInstitution(String institutionId) throws DbException;

    public Iterable<Vuggestue>  getAllInstitution();

    public int checkInstitution(String navn);

    public void removeInstitution(String navn) throws DbException;

}
