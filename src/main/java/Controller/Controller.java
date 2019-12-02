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
    Method inserts all searchresults into the database.
     If one instance exist it will not be insertet into the database.
     */
    public String updateInstitutionQuery(String vejNavn, String postNr){
    try {
        List<Vuggestue> respons = crawler.getTilsynsrapport(vejNavn, postNr);

        if(respons.size()==0){
            return  "Forespørgslen kunne ikke gennemføres";
        }

        for (Vuggestue a : respons
        ) {
    //TODO: Sikre at indstser ikke bliver dubbleret
            //Insures that there will be only one
            int res = database.checkInstitution(a.getNavn());

            if ( res== 0) {
                database.createInstitution(a);
                System.out.println("Added : " + a.toString());
            } else if(res==3){
                System.out.println("Ikke i stand til at gemme dette navn");
            }

                else {
                database.removeInstitution(a.getNavn());
                database.createInstitution(a);
            }
        }

        return "Indhentet tilsyn, database opdateret";

        }catch (Exception e){
                return "Noget gik galt under indhentningen af data";
            }

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



    public Iterable<Vuggestue> getAllInstitutions(){
        return database.getAllInstitution();
    }
}
