package Model.Crawler;

import Model.IBaseURL;
import Model.DTO.Institutions.Vuggestue;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;


public class soegningURL implements IBaseURL {


    documentURL doc;

    HashMap<String,String> links = new HashMap<String,String>();
    ArrayList<Vuggestue> vuggestuer = new ArrayList<Vuggestue>();
    TraverserURL traversering;

    static int tilsynCount = 0;

    String vej = "";
    String postNr = "";

    public soegningURL(documentURL doc){this.doc = doc;};


   /*
    This method retrives all the base informations for the kk hjemmeside (result page). All of the institutions exist
    within the tag "fiels-content". This is why we loop througt this list of elements from this tag and extracting
    the informations that we want. Finally the an Vuggestue object is created and alle the informations are set to
    this object. Vuggestue is inserted in a list whith all vuggestuer from this search result.
    The getTilsynLink returns the link to the website of the institution.
     */

    public void getBaseInformations(Document doc){
        Elements ja = doc.getElementsByClass("field-content");
        for (Element a:ja){

            Elements et =a.getElementsByTag("h2");
            Elements to = a.getElementsByClass("field-name-field-open-hours");
            Elements tre = a.select("a[href");
            Elements fire = a.getElementsByTag("li");
            Elements fem = a.getElementsByClass("thoroughfare");
            Elements seks = a.getElementsByClass("field-name-field-telephone");
            //System.out.println(et.text()+"||"+to.text()+"||"+"||"+fire.text()+"||"+"||"+fem.text()+"||"+tre.attr("abs:href"));
            Vuggestue stue = new Vuggestue(et.text(),fem.text(),to.text(),seks.text(),fire.text(),getTilsynLink(tre.attr("abs:href")));

            vuggestuer.add(stue);
            // System.out.println(stue.toString());

        }

    }


    /*
   returns  the link to the webpage of the institution. It finds the webpage from the tag "ic-link tx-ln".
    */
    private String getTilsynLink(String url) {
        String url1=url;
        try{
            Document html = doc.createDocument(url1);

            Elements links = html.getElementsByTag("a");

            for (Element y:links
            ) {
                if(y.toString().contains("ic-link tx-ln")){
                    return y.attr("abs:href");
                }
            }

        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        return null;
    }



    /*
    Return a list of vuggestuer from the search done by getBaseInformations
     */
    @Override
    public List<Vuggestue> getVuggestuer(String vej, String postNr) {
        this.vej = vej;
        this.postNr = postNr;
        //url = setUrl(vej, postNr);
        doc.createUrl(vej, postNr);
        //doc = Jsoup.connect(url).get();

        getBaseInformations(doc.createDocument(doc.getUrl()));

        return vuggestuer;
    }
}
