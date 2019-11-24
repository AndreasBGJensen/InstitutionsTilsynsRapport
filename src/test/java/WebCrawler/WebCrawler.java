package WebCrawler;

import Controller.CrawlerController.ControllerGETTilsynsrapport;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class WebCrawler {


    @Test
    public void TestWebCrawler(){

        String vejnavn = "Olfert Fischers Gade";
        String postNr = "1311";


        ControllerGETTilsynsrapport controller = new ControllerGETTilsynsrapport();
        Response answerFromWeb = controller.getTilsynsrapport(vejnavn,postNr);

        System.out.println(answerFromWeb.getEntity().toString());


    }




}
