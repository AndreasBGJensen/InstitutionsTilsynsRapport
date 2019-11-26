package Model.Database;


import Model.DTO.User.UserDTO;
import Model.DTO.Institutions.Vuggestue;
import com.google.gson.JsonObject;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.json.JSONObject;

import javax.ws.rs.core.Response;

public class InstitutionDAO implements IInstitutionDAO {
    @Override
    public Response createInstitution(Vuggestue institution) {


            Jongo jongo = new Jongo(MongoConnector.getInstance());

            MongoCollection users = jongo.getCollection("InstitutionsStore");

            users.save(institution);

            return Response.ok().build(); // Return a response
    }

    @Override
    public Response getInstitution(String institutionName) {
        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection("InstitutionsStore");

        Vuggestue  institution = institutioner.findOne("{navn: '"+institutionName+"'}").as(Vuggestue.class);

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
    public Response getAllInstitution(String institutionId) {
        return null;
    }

    @Override
    public int checkInstitution(String navn){

        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection("InstitutionsStore");
        return (int)institutioner.count("{navn: '"+navn+"'}");


    }

    @Override
    public Response removeInstitution(String navn) {
        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection("InstitutionsStore");
        institutioner.remove(navn);

        return Response.ok().build();
    }


}
