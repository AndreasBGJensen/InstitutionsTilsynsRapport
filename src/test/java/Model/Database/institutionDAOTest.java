package Model.Database;

import Model.DTO.Institutions.Vuggestue;
import View.Rest.Exceptions.DbException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Tester database. Testen har dog en del mangler eftersom at den i bund og grund ikke tester den enkelte metode men også tester
Oprettelse af database connection osv.
 */

public class institutionDAOTest {

    private IInstitutionDAO institutionDAO = new InstitutionDAO();

    @Test
    public void createInstitution() throws DbException {
        Vuggestue testInstitution = new Vuggestue("Røde Rose", "Thorsgade 42", "10-16", "220689", "31", "https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");

//        institutionDAO.createInstitution(testInstitution);
        assertDoesNotThrow(() -> institutionDAO.createInstitution(testInstitution));

//        assertEquals(200,response.getStatus());
    }

    //Testing chat we can get an Institution frm the database
    @Test
    public void getInstitution() throws DbException {
        Vuggestue testInstitution = new Vuggestue("Test", "Thorsgade 42", "10-16", "220689", "31", "https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");
        institutionDAO.createInstitution(testInstitution);
        Vuggestue test = institutionDAO.getInstitution("Test");
//        Vuggestue test =  (Vuggestue) response.getEntity();
        assertEquals(test.toString(), testInstitution.toString());
//        assertEquals(200,response.getStatus());
    }

    @Test
    public void ErrorGetInstitution() throws DbException {
        Vuggestue testInstitution = new Vuggestue("TestErrorGetInstitution", "Thorsgade 42", "10-16", "220689", "31", "https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");

        // institutionDAO.createInstitution(testInstitution);
//        Vuggestue response = institutionDAO.getInstitution("Test");

        Throwable thrown = assertThrows(DbException.class,
                () -> {
                    institutionDAO.getInstitution("TestErrorGetInstitution");
                },
                "Expected institutionDAO.getInstitution(\"Test\"); to throw an exception, but it did not throw!");
        assertTrue(thrown.getMessage().contains("DbException error"));
//        assertEquals(204, response.getStatus());
    }

    @Test
    public void ErrorRemoveInstitution() {
        Vuggestue testInstitution = new Vuggestue("TestErrorRemove", "Thorsgade 42", "10-16", "220689", "31", "https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");
//        int result = institutionDAO.removeInstitution("Test");
//        assertEquals(0, result);
        Throwable thrown = assertThrows(DbException.class,
                () -> {
                    institutionDAO.removeInstitution("TestErrorRemove");
                },
                "Expected institutionDAO.removeInstitution(\"Test\"); to throw an exception, but it did not throw!");
        assertTrue(thrown.getMessage().contains("DbException error"));
    }

    @Test
    public void removeInstitution() throws DbException {
        Vuggestue testInstitution = new Vuggestue("testRemoveInstitution", "Thorsgade 42", "10-16", "220689", "31", "https://pasningogskole.kk.dk/institution/35245x0/vuggestuen");
        institutionDAO.createInstitution(testInstitution);
        assertDoesNotThrow(() -> {
            institutionDAO.removeInstitution("testRemoveInstitution");
        }, "hej");    //TODO: implement this, currently does not work.
    }

    @Test
    public void getAll() {
        System.out.println(institutionDAO.getAllInstitution());
    }
}
