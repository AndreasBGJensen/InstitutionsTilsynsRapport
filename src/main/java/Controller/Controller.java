package Controller;

import Controller.CrawlerController.ControllerGETTilsynsrapport;
import Model.DTO.Institutions.Vuggestue;
import Model.Database.IInstitutionDAO;
import Model.Database.InstitutionDAO;
import org.json.JSONObject;

import javax.ws.rs.core.Response;

import java.util.List;

public class Controller {
    IInstitutionDAO  database = new InstitutionDAO();
    ControllerGETTilsynsrapport crawler = new ControllerGETTilsynsrapport();




    public Controller(){}

    /*
    Method inserts all searchresults into the database. If one instance exist it will not be insertet into the database.
     */
    public Response updateInstitutionQuery(String vejNavn, String postNr){

        List<Vuggestue> respons = crawler.getTilsynsrapport(vejNavn,postNr);

        for (Vuggestue a:respons
        ) {

            //Insures that there will be only one
            if(database.checkInstitution(a.getNavn())!=0) {
                database.createInstitution(a);
                System.out.println("Added : " + a.toString());
            }else{
                database.removeInstitution(a.getNavn());
                database.createInstitution(a);
            }
        }

        return Response.ok().entity("Database updated").build();


    }

    public Response getUserSearchInstitutionsFromDatabase(String vejNavn, String postNr){
        List<Vuggestue> institutionList =crawler.getInstitutions(vejNavn,postNr);
        JSONObject json = new JSONObject();

        for (Vuggestue a:institutionList
        ) {
            Response response = database.getInstitution(a.getNavn());
            Vuggestue vuggestue = (Vuggestue) response.getEntity();
            json.put(vuggestue.getNavn(),vuggestue);
        }

        System.out.println(json.toString());

        return Response.ok().entity(json).build();
    }
}
