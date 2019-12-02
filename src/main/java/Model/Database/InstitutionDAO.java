package Model.Database;


import Model.DTO.Institutions.Vuggestue;
import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import javax.ws.rs.core.Response;


/*
This class is used to make operations in the database.
 */


public class InstitutionDAO implements IInstitutionDAO {


    /*
   This megthos creates an instance in the database.
    */
    @Override
    public Response createInstitution(Vuggestue institution) {


            Jongo jongo = new Jongo(MongoConnector.getInstance());

            MongoCollection users = jongo.getCollection("InstitutionsStore");

            users.save(institution);

            return Response.ok().build(); // Return a response

    }

    /*
    This method retrives an instance of Vuggestue from the database
     */

    @Override
    public Response getInstitution(String institutionName) {
        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection("InstitutionsStore");

        Vuggestue institution = institutioner.findOne("{navn: '"+institutionName+"'}").as(Vuggestue.class);

        //JSONObject json = new JSONObject(institution.toString());

        System.out.println(institution);

        if(institution!= null){
            return Response.ok().entity(institution).build();
        }

        return Response.noContent().entity("Not able to find the instution in the database").build();
    }

    /*
    Hvis method will be used to update an Vuggestue instance
     */
    //TODO: Implement updateInstitution
    @Override
    public Response updateInstitution(String institutionName) {
         getInstitution(institutionName);

        return null;
    }

    /*
    This checks is an vuggestueinstance exists in the database
     */
    @Override
    public int checkInstitution(String navn){

        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection("InstitutionsStore");
        return (int)institutioner.count("{navn: '"+navn+"'}");
    }

    /*
    Removes an instance of vugggestue from the database.
     */

    @Override
    public int removeInstitution(String navn) {
        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection("InstitutionsStore");

        Vuggestue institution = institutioner.findOne("{navn: '"+navn+"'}").as(Vuggestue.class);

        if(institution== null){

            return 0;
        }
            institutioner.remove("{navn: '"+navn+"'}");


        return 1;
    }

/*
Retrives a list of all institutions from the database.
 */

    @Override
    public Iterable<Vuggestue> getAllInstitution(){
        Jongo jongo = new Jongo(MongoConnector.getInstance());

        MongoCollection institutioner = jongo.getCollection("InstitutionsStore");

        Find result =institutioner.find();

        return result.as(Vuggestue.class);

    }
}
