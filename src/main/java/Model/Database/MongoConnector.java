package Model.Database;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoConnector {
    static MongoConnector instance;
    private final static String database = "aa";
    private MongoClient mongoClient;
    private MongoConnector(){
        this.mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://User:Abekat15@cluster0-hbffi.mongodb.net/test?retryWrites=true&w=majority"));
    }
    public static DB getInstance(){
        if(instance == null){
            instance = new MongoConnector();
            return instance.mongoClient.getDB(database);
        }else{
            return instance.mongoClient.getDB(database);
        }
    }
}


