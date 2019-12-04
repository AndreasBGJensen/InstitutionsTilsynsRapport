package Model.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


/*
This class constructs an URL that matches the one from Københavns Kommune. Then i returns a Document containing
all of the tags and attributes fra an URl.
 */
public class documentURL {

    public String url;

    //public String url = "https://pasningogskole.kk.dk/vuggestue-og-dagpleje?address%5Borigin%5D="+vej+"%2C+"+postNr+"&field_institution_profile_tid=All";
    public String url1 = "https://pasningogskole.kk.dk/vuggestue-og-dagpleje?address%5Borigin%5D=";
    public String url2 = "%2C+";
    public String url3 = "+&field_institution_profile_tid=All";

    public documentURL(){}

    /*
     Create a document from URL. A document contains all tags and attributes from a given URL.
    */
    public Document createDocument(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            return doc;
        }catch (IOException e){
            return null;

        }
    }


    /*
    Constructs an URL so that i matches the one from Københavns Kommune.
     */
    public void createUrl(String vej, String postNr) {
        String url = url1.concat(vej).concat(url2).concat(postNr).concat(url3);
        setUrl(url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
