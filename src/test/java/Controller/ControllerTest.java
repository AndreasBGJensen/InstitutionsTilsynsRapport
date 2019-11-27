package Controller;

import Controller.CrawlerController.ControllerGETTilsynsrapport;
import Model.DTO.Institutions.Vuggestue;
import com.mongodb.util.JSON;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

    Controller control = new Controller();

    @Test
    public void updateInstitutionQueryTest() {


        String[] vejNavn ={"Mimersgade"};

        String[] postNr = {"2200"};




        String vejnavn = "";
        String postnr ="";
        String respons;
        String testString = "Indhentet tilsyn for adressen: " + vejnavn + ", "+postnr;
        for(int i = 0; i<vejNavn.length;i++) {
            vejnavn = vejNavn[i];
            postnr = postNr[i];

            respons= control.updateInstitutionQuery(vejNavn[i],postNr[i]);

            assertEquals(testString,respons);


        }



    }
    @Test
    public void getUserSearchInstitutionsFromDatabaseTest(){

        String[] vejNavn ={"Mimersgade","Olfert Fischers Gade"};

        String[] postNr = {"2200","1311"};

        JSONObject json = new JSONObject();

        Response respons;

        for(int i = 0; i<vejNavn.length;i++) {

            try{
                respons = control.getUserSearchInstitutionsFromDatabase(vejNavn[i], postNr[i]);



                json.put("Search result", respons.getEntity());

                System.out.println(json.toString());
            }catch(Exception e){
                e.printStackTrace();
            }


        }



    }
}
