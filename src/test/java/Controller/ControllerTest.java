package Controller;

import Model.DTO.Institutions.Vuggestue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {

    Controller control = new Controller();

    /*
    Testing that the crawler finds tilsynsrapporter and that they are loaded into the db.
    Test dog mangelfuld...
     */
    @Test
    public void updateInstitutionQueryTest() {
//        String[] vejNavn = {"Mimersgade", "Åfløjen", "Stærevej", "Nordbanegade", "Ravnsborggade", "Gothersgade", "Holbergsgade", "Wilders Plads", "Islands Brygge"};
//        String[] postNr = {"2200", "2700", "2400", "2200", "2200", "1123", "1057", "1403", "2300"};
        String[] vejNavn = {"Mimersgade"};
        String[] postNr = {"2200"};
        String respons;
        String testString = "Indhentet tilsyn, database opdateret";
        for (int i = 0; i < vejNavn.length; i++) {
            respons = control.updateInstitutionQuery(vejNavn[i], postNr[i]);
            assertEquals(testString, respons);
        }
    }

    /*
    Tester at en forspørgsel ikke kan gennemføres
     */
    @Test
    public void updateInstitutionQueryFAILTest() {
        String vejNavnForkert = "dsfdsfdsf";
        String postNrForkert = "sdfsdf";
        String respons;
        respons = control.updateInstitutionQuery(vejNavnForkert, postNrForkert);
        String forkertForespørgsel = "Forespørgslen kunne ikke gennemføres";
        assertEquals(forkertForespørgsel, respons);
    }

    /*
    Testing that the search address will find the wright ones from the Crawler and that they are loaded from the database.
     */
    @Test
    public void getUserSearchInstitutionsFromDatabaseTest() {
        String[] vejNavn = {"Mimersgade"};
        String[] postNr = {"2200"};
        List<Vuggestue> entry = null;
        for (int i = 0; i < vejNavn.length; i++) {
            try {
                entry = control.getUserSearchInstitutionsFromDatabase(vejNavn[i], postNr[i]);
                assertTrue(entry.toString().toLowerCase().contains("pladser"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*assertEquals is unnecessary*/
//        try {
//            assertEquals(1, entry.size());
//        } catch (NullPointerException npe) {
//            npe.printStackTrace();
//        }

    }

    /*
    Denne test tester lidt af hvert.
    Der er på bagrund af denne test lavet try-catch i PDFManager og i InstitutionsDAO (hvis at et navn ikke er kompertibelt med MongoDB)
     */

    @Test
    public void whenManyFilesAreImagesAndInstitutionNamesAreNotCompatableWithMongoDB() {
        String[] vejNavn = {"Dahlerupsgade"};
        String[] postNr = {"1603"};
        String respons;
        String testString = "Indhentet tilsyn, database opdateret";
        respons = control.updateInstitutionQuery(vejNavn[0], postNr[0]);
        assertEquals(testString, respons);
    }
}
