package Controller;

import Controller.CrawlerController.ControllerGETTilsynsrapport;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

Controller control = new Controller();

    @Test
    public void updateInstitutionQueryTest() {
        String[] vejNavn ={"Mimersgade","Olfert Fischers Gade"};

        String[] postNr = {"2200","1311"};

        String testString = "Database updated";

        Response respons;

        for(int i = 0; i<vejNavn.length;i++) {
            respons= control.updateInstitutionQuery(vejNavn[i],postNr[i]);

            assertEquals(testString,respons.getEntity().toString());


        }



}
@Test
public void getUserSearchInstitutionsFromDatabaseTest(){

    String[] vejNavn ={"Mimersgade","Olfert Fischers Gade"};

    String[] postNr = {"2200","1311"};

    Response respons;

    for(int i = 0; i<vejNavn.length;i++) {
        respons= control.getUserSearchInstitutionsFromDatabase(vejNavn[i],postNr[i]);

       String result = respons.getEntity().toString();
        System.out.println(result);
    }



}
}
