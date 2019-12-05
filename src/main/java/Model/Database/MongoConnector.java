package Model.Database;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoConnector {
    private final static String dbName = "aa";
    static MongoConnector instance;
    //    static MongoDatabase dbInstance;
    private static String username = System.getenv("DEVOPSMONGOUSER");
    private static String password = System.getenv("DEVOPSMONGOPASS");
    private static MongoClient mongoClient;

    private MongoConnector() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://" + username + ":" + password + "@tilsyn-m11lw.azure.mongodb.net/test?retryWrites=true&w=majority"));
    }

//    public static MongoDatabase getInstance() {   //TODO: implement this getDatabase instead of getDB, as getDB is deprecated!
//        if (dbInstance != null) {
//            MongoClient mongoClient = (MongoClient) MongoClients.create("mongodb+srv://" + username + ":" + password + "@tilsyn-m11lw.azure.mongodb.net/test?retryWrites=true&w=majority");
//            return mongoClient.getDatabase(dbName);
//        } else {
//            return mongoClient.getDatabase(dbName);
//        }
//    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new MongoConnector();
            return instance.mongoClient.getDB(dbName);
        } else {
            return instance.mongoClient.getDB(dbName);
        }
    }
}
