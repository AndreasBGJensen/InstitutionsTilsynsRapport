package Model.DTO.User;


import Model.Database.IUserDAO;
import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.MongoObjectId;



import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDTO implements IUserDTO{
    @MongoObjectId
    private String _id;
    private String userID;
    private String username;
    private String name;
    private String email;
    private String password;
    private String roles;

    public UserDTO(String user, String name, String userId){
    this.username=user;
    this.name =name;
    this.userID = userId;
}

    public UserDTO(String username, String roles) {
        this.username=username;
        this.roles=roles;

    }


    public String getId(){ //Konverterer ObjectID'et til en pæn string
        return _id;
    }


    public void setID(String id){ //Konverterer en HexString til ObjectID
        _id =id;
    }


    @Override
    public String getUserID(){
        return userID;
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