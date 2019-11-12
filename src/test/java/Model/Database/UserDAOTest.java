package Model.Database;

import Model.DTO.User.UserDTO;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    UserDAO test = new UserDAO();
    UserDTO testUser = new UserDTO("banan","Andreas Jensen","33");
    Jongo jongo = new Jongo(MongoConnector.getInstance());

    MongoCollection users = jongo.getCollection("Users");


/*
Auther: Andreas
Testing that we can create a user in the database

 */

    @Test
    public void createUser(){

        Response response = test.createUser(testUser);
        users.find("{userId: '22'}").as(String.class);

        assertEquals("900",response);
    }

/*
Auther: Andreas
Testing that we can delete a user in the database

 */
    @Test
    public void deleteUser() {
        UserDTO deleteUser = new UserDTO("banan","Andreas","2");
        users.save(deleteUser);

        Response response = test.deleteUser("2");


        //Making the JSONObject so et is easy to get the code tag.
        JSONObject entety = new JSONObject(response.getEntity().toString());

        assertEquals(1,entety.get("code"));

    }

    /*
    Auther: Andreas
    Testing that we can get a user in the database
    and that we will get a error if a user does not exist in the database.

     */
    @Test
    public void getUser() {
        UserDTO getUser = new UserDTO("banan","Andreas","300");
        users.save(getUser);

        Response createdUser =Response.ok().entity(getUser).build();
        Response returnedUser =  test.getUser("300");


        UserDTO created = (UserDTO)createdUser.getEntity();
        UserDTO recieved = (UserDTO)returnedUser.getEntity();
        //Testing that the recieved Id's at equal. The two object wont be equal.
        assertEquals(created.getName(), recieved.getName());


        //Testing that an NoUserInDatabaseException will be returned
        //UserDTO userNoExistence = test.getUser("99999");
        //assertEquals("No such user in database", userNoExistence.getMessage());

    }
}