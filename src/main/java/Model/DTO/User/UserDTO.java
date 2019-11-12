package Model.DTO.User;


import Model.Database.IUserDAO;
import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.MongoObjectId;


public class UserDTO implements IUserDTO{
    @MongoObjectId
    private String _id;
    private String userId;
    private String username;
    private String name;
    private String email;

    public UserDTO(String user, String name, String userId){
    this.username=user;
    this.name =name;
    this.userId = userId;
}

    public UserDTO() {
    }

    public String getId(){ //Konverterer ObjectID'et til en pæn string
        return _id;
    }


    public void setID(String id){ //Konverterer en HexString til ObjectID
        _id =id;
    }


    @Override
    public String getUserID(){
        return userId;
    }


    public String getName(){
        return name;
    }


    public String getUsername(){
        return username;
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    public String getEmail(){
        return email;
    }



}