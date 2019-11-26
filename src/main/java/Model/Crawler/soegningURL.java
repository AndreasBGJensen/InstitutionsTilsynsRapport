package Model.Crawler;

import Model.Downloader.DownloadPDF;
import Model.IBaseURL.IBaseURL;
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
    This method retrives all the base informations for the kk hjemmeside. And puts all vuggestuer in a list.
    The getTilsynLink retrives all the links were the tilsyn are located.
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
