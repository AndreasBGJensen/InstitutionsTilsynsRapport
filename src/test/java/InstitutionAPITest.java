import View.Rest.InstitutionAPI;
import Model.DTO.SearchParam;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class InstitutionAPITest {

    InstitutionAPI api = new InstitutionAPI();


    @Test
    public void postLoginDataTest(){

        SearchParam para = SearchParam.builder().vejnavn("Mimersgade").postNr("2200").build();

        JSONObject request = new JSONObject();
        request.put("vejnavn","2200");


        Response response = api.postLoginData(para);

        System.out.println(response.getEntity().toString());


    }

}
