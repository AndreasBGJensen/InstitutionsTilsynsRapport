package Model.Crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class documentURL {

    public String url;

    //public String url = "https://pasningogskole.kk.dk/vuggestue-og-dagpleje?address%5Borigin%5D="+vej+"%2C+"+postNr+"&field_institution_profile_tid=All";
    public String url1 = "https://pasningogskole.kk.dk/vuggestue-og-dagpleje?address%5Borigin%5D=";
    public String url2 = "%2C+";
    public String url3 = "+&field_institution_profile_tid=All";

    public documentURL(){}


    public Document createDocument(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            return doc;
        }catch (IOException e){
            return null;

        }
    }


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
