package Model.Database;

import Model.DTO.Institutions.Indstser;
import Model.DTO.Institutions.Institution;
import Model.DTO.Institutions.Vuggestue;
import Model.DTO.User.UserDTO;
import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.json.JSONObject;

import javax.validation.constraints.Null;
import javax.ws.rs.core.Response;
import java.util.List;

public class InstitutionDAO implements IInstitutionDAO {
    private static final String COLLECTION = "TestInstitutionStore";
    @Override
    public Response createInstitution(Vuggestue institution) {


            Jongo jongo = new Jongo(MongoConnector.getInstance());

            MongoCollection users = jongo.getCollection(COLLECTION);

            users.save(institution);

            return Response.ok().build(); // Return a response


    }

    @Override
    public Response getInstitution(String institutionName) {
        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection(COLLECTION);

        Vuggestue institution = institutioner.findOne("{navn: '"+institutionName+"'}").as(Vuggestue.class);

        //JSONObject json = new JSONObject(institution.toString());

        System.out.println(institution);

        if(institution!= null){
            return Response.ok().entity(institution).build();
        }

        return Response.noContent().entity("Not able to find the instution in the database").build();
    }



    @Override
    public Response updateInstitution(String institutionName) {
         getInstitution(institutionName);

        return null;
    }








    @Override
    public int checkInstitution(String navn){

        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection(COLLECTION);

        try {
            int count = (int) institutioner.count("{navn: '" + navn + "'}");

            return count;
        }catch(IllegalArgumentException e){
            System.out.println("Kan ikke slå dette navn op i mongoDB");
            return 3;
        }

    }

    @Override
    public int removeInstitution(String navn) {
        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection(COLLECTION);

        Vuggestue institution = institutioner.findOne("{navn: '"+navn+"'}").as(Vuggestue.class);

        if(institution== null){

            return 0;
        }
            institutioner.remove("{navn: '"+navn+"'}");


        return 1;
    }


    @Override
    public Iterable<Vuggestue> getAllInstitution(){
        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection(COLLECTION);

        Find result =institutioner.find();




        return result.as(Vuggestue.class);

    }
}
