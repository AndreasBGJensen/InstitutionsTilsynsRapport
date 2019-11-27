package Model.Database;

import Model.DTO.Institutions.Institution;
import Model.DTO.Institutions.Vuggestue;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class institutionDAOTest {


    private IInstitutionDAO institutionDAO = new InstitutionDAO();
    @Test
    public void createInstitution(){
        Vuggestue testInstitution = new Vuggestue("Røde Rose","Thorsgade 42","10-16","220689","31","https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");

        Response response = institutionDAO.createInstitution(testInstitution);

        assertEquals(200,response.getStatus());


    }


    //Testing chat we can get an Institution frm the database
    @Test
    public void getInstitution(){


        Vuggestue testInstitution = new Vuggestue("Test","Thorsgade 42","10-16","220689","31","https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");

        institutionDAO.createInstitution(testInstitution);
        Response response = institutionDAO.getInstitution("Test");
        Institution test =  (Institution)response.getEntity();

        assertEquals(test.toString(),testInstitution.toString());
        assertEquals(200,response.getStatus());




    }


    @Test
    public void ErrorGetInstitution() {


        Vuggestue testInstitution = new Vuggestue("Test", "Thorsgade 42", "10-16", "220689", "31", "https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");

        institutionDAO.createInstitution(testInstitution);
        Response response = institutionDAO.getInstitution("Test");


        assertEquals(300, response.getStatus());
    }


    @Test
    public void removeInstitution(){
        Vuggestue testInstitution = new Vuggestue("Test", "Thorsgade 42", "10-16", "220689", "31", "https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");

        institutionDAO.removeInstitution("Test");
    }

}
