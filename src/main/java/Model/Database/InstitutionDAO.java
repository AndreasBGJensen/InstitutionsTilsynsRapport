package Model.Database;

import Model.DTO.Institutions.Vuggestue;
import View.Rest.Exceptions.DbException;
import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class InstitutionDAO implements IInstitutionDAO {
    private static final String COLLECTION = "TestInstitutionsStore";

    @Override
    public void createInstitution(Vuggestue institution) throws DbException {
        Jongo jongo = new Jongo(MongoConnector.getInstance());
        MongoCollection users = jongo.getCollection(COLLECTION);
        if (users != null) {
            users.save(institution);
        } else {
            throw new DbException("Could not get collection InstitutionStore");
        }
//            return Response.ok().build(); // Return a response    // should not return a Response
    }

    @Override
    public Vuggestue getInstitution(String institutionName) throws DbException {
        Jongo jongo = new Jongo(MongoConnector.getInstance());
        MongoCollection institutioner = jongo.getCollection(COLLECTION);
        Vuggestue institution = institutioner.findOne("{navn: '" + institutionName + "'}").as(Vuggestue.class);
        //JSONObject json = new JSONObject(institution.toString());
        System.out.println(institution);
        if (institution != null) {
            return institution;
        } else {
            throw new DbException("DbException error: institution, " + institutionName + " is not found!");
//            return Response.noContent().entity("Not able to find the instution in the database").build();
        }
    }

    @Override
    public void updateInstitution(String institutionName) throws DbException {
        getInstitution(institutionName);
        throw new NotImplementedException();
    }

    @Override
    public int checkInstitution(String navn) {
        Jongo jongo = new Jongo(MongoConnector.getInstance());
        MongoCollection institutioner = jongo.getCollection(COLLECTION);
        try {
            int count = (int) institutioner.count("{navn: '" + navn + "'}");
            return count;
        } catch (IllegalArgumentException e) {
            System.out.println("Kan ikke slå dette navn op i mongoDB");
            return 3;
        }
    }

    @Override
    public void removeInstitution(String navn) throws DbException {
        Jongo jongo = new Jongo(MongoConnector.getInstance());
        MongoCollection institutioner = jongo.getCollection(COLLECTION);
        Vuggestue institution = institutioner.findOne("{navn: '" + navn + "'}").as(Vuggestue.class);
        if (institution != null) {
            institutioner.remove("{navn: '" + navn + "'}");
        } else {
            throw new DbException("DbException error: institution, " + navn + ", desired for removal can not be found.");
        }
    }

    @Override
    public Iterable<Vuggestue> getAllInstitution() {
        Jongo jongo = new Jongo(MongoConnector.getInstance());
        MongoCollection institutioner = jongo.getCollection(COLLECTION);
        Find result = institutioner.find();
        return result.as(Vuggestue.class);
    }
}
