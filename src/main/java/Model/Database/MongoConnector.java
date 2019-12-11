package Model.Database;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoConnector {
    private final static String database = "aa";
    static MongoConnector instance;
    private static String username = System.getenv("DEVOPSMONGOUSER");
    private static String password = System.getenv("DEVOPSMONGOPASS");
    private MongoClient mongoClient;

    private MongoConnector() {
        this.mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://" + username + ":" + password + "@tilsyn-m11lw.azure.mongodb.net/test?retryWrites=true&w=majority"));
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new MongoConnector();
            return instance.mongoClient.getDB(database);
        } else {
            return instance.mongoClient.getDB(database);
        }
    }
}
