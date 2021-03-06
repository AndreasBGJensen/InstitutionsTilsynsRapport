package Controller;

import Controller.CrawlerController.ControllerGETTilsynsrapport;
import Model.DTO.Institutions.Vuggestue;
import Model.Database.IInstitutionDAO;
import Model.Database.InstitutionDAO;
import View.Rest.Exceptions.DbException;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    IInstitutionDAO database = new InstitutionDAO();
    ControllerGETTilsynsrapport crawler = new ControllerGETTilsynsrapport();


    public Controller() {
    }

    /*
    Method inserts all searchresults into the database.
     If one instance exist it will not be insertet into the database.
     */
    public String updateInstitutionQuery(String vejNavn, String postNr) {
        try {
            List<Vuggestue> respons = crawler.getTilsynsrapport(vejNavn, postNr);

            if (respons.size() == 0) {
                return "Forespørgslen kunne ikke gennemføres";
            }

            for (Vuggestue a : respons
            ) {
                //TODO: Sikre at indstser ikke bliver dubbleret
                //Insures that there will be only one
                int res = database.checkInstitution(a.getNavn());

                if (res == 0) {
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

    /*This method is retrives a list of institutions from the crawler, and retrives the institutions from the database and
    returns the Vuggestueobjects to the API.*/
    public List<Vuggestue> getUserSearchInstitutionsFromDatabase(String vejNavn, String postNr) throws DbException {
        List<Vuggestue> institutionList = crawler.getInstitutions(vejNavn, postNr);

//        JSONObject json = new JSONObject();

        List<Vuggestue> returnList = new ArrayList<>();

        for (Vuggestue a : institutionList
        ) {
            Vuggestue vuggestue = database.getInstitution(a.getNavn());
            returnList.add(vuggestue);
//            Vuggestue vuggestue = (Vuggestue) response.getEntity();
//            json.put(vuggestue.getNavn(),vuggestue);
        }

        return returnList;
//        System.out.println(json.toString());

//        return Response.ok().entity(json).build();
    }

    /*
    Retrives all Vuggestueobjects from the database and returns a list to the API.
     */
    public Iterable<Vuggestue> getAllInstitutions(){
        return database.getAllInstitution();
    }
}
