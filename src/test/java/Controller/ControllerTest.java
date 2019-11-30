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


    /*
    Testing that the crawler finds tilsynsrapporter and that they are loaded into the db.
    Test dog mangelfuld...
     */
    @Test
    public void updateInstitutionQueryTest() {


        String[] vejNavn ={"Mimersgade","Åfløjen","Stærevej", "Nordbanegade","Ravnsborggade","Gothersgade","Holbergsgade","Wilders Plads","Islands Brygge"};

        String[] postNr = {"2200","2700","2400","2200","2200","1123","1057","1403","2300"};





        String respons;
        String testString = "Indhentet tilsyn, database opdateret";


for(int i = 0; i<vejNavn.length;i++) {
    respons = control.updateInstitutionQuery(vejNavn[i], postNr[i]);
    assertEquals(testString,respons);
}





    }

    /*
    Tester at en forspørgsel ikke kan gennemføres
     */

    @Test
    public void updateInstitutionQueryFAILTest() {
        //Her får vi testen at crache
        String vejNavnForkert ="dsfdsfdsf";

        String postNrForkert = "sdfsdf";

        String respons;
        respons= control.updateInstitutionQuery(vejNavnForkert,postNrForkert);

        String forkertForespørgsel ="Forespørgslen kunne ikke gennemføres";
        assertEquals(forkertForespørgsel,respons);
    }
    /*
    Testing that the search adress will find the wright ones from the Crawler and that they are loaded from the database.
     */

    @Test
    public void getUserSearchInstitutionsFromDatabaseTest(){

        String[] vejNavn ={"Mimersgade"};

        String[] postNr = {"2200"};

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
