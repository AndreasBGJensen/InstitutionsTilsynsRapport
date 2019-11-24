package Controller;

import Controller.CrawlerController.ControllerGETTilsynsrapport;
import Model.DTO.Institutions.Vuggestue;
import Model.Database.IInstitutionDAO;
import Model.Database.InstitutionDAO;

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
}
