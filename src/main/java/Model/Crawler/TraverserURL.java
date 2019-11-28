package Model.Crawler;

import Controller.Download.DownloadPDF;
import Model.DTO.Institutions.Vuggestue;
import Model.Util.ValidateContentAttay;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TraverserURL {
    List<Vuggestue> vuggestuer;
    documentURL doc;
    DownloadPDF pdfWriter = new DownloadPDF();
    static int i; //TODO: Hvorfor skal denne v�re global?

    ConcurrentHashMap<String,String> existingUrl = new ConcurrentHashMap<String, String>();
    ConcurrentHashMap<String,String> checker = new ConcurrentHashMap<String, String>();


    public TraverserURL(documentURL doc, List<Vuggestue> vuggestuer){
        this.doc = doc;
        this.vuggestuer = vuggestuer;
        startTraversing();

    }

    private void startTraversing(){
        /*
        This loope is made for test purpes only. It will ensure that there will be only one element of vuggestuer
         */
        // for(int j=1;j<vuggestuer.size();j=1){
        //   vuggestuer.remove(j);

        //}

        /*
        This loop ensures traversing through all vuggestuer
         */
        for(i = 0; i<vuggestuer.size();i++){
            traverseLinks(vuggestuer.get(i).getBaseLink());
        }
    }


    private String stringFormat(String url){
        String[] fragment;

        if(containsWWWString(url)) {

            fragment = separateDot(url);
            return fragment[1].concat(".kbhbarn.kk.dk/FrontEnd");

        }
        return null;

    }


    private String[] separateDot(String url){
        String[] fragment;
        fragment = url.split("\\.");
        return fragment;

    }


    private boolean containsWWWString(String url){
        if(url.contains("www")){
            return true;
        }else {
            return false;
        }

    }
    /*
    Filtrere alle mulige mærkelige url fra eks. Mails kalender osv.
     */
    private boolean urlAccess(String url){
        String[] badKeyWords = {"mail","kalender", "txt"};
        for(int i = 0; i<badKeyWords.length;i++) {
            if (url.contains(badKeyWords[i])){
                System.out.println("URLACCESS: "+false );
                return false;
            }
        }
        System.out.println("URLACCESS: "+true );
        return true;
    }








    private void goToOmInstitutione(String url) throws NullPointerException{
        Document html = doc.createDocument(url);


            /*
            Extracting all links from the URL page
             */
        Elements links = html.getElementsByTag("a");

        for (Element yy : links

        ) {
            if (vorthyURL(yy.attr("abs:href"))) {
                if(!validateAddress(yy.attr("abs:href"))) {
                    existingUrl.put(yy.attr("abs:href"), yy.attr("abs:href"));
                    checker.put(yy.attr("abs:href"), yy.attr("abs:href"));
                }
            }
        }

        for (Element y : links
        ) {
            getTilsysnrapport(y);

        }
    }


    private boolean vorthyURL(String url){


        System.out.println(url);
        String base2 = stringFormat(vuggestuer.get(i).getBaseLink());
        System.out.println(url);
        System.out.println("url fragment :"+ url+", Base2: " + base2);

        //TODO: Lav en funktion der sammenligner

        try {
            if(url.contains(base2)&&urlAccess(url)){
                System.out.println("URL CONTAINS: "+url.contains(base2));


                return true;
            }
        }catch (IndexOutOfBoundsException e){
            if(url.equals("")){
                return false;
            }
        }




        return false;

    }

    private boolean validateAddress(String url){
        try {
            if (checker.get(url).equals(url)) {
                return true;
            }
            return false;
        }catch (NullPointerException e){
            return false;
        }
    }

    /*
    This method
     */
    private void traverseLinks(String url) {
        if(url!=null) {
            existingUrl.put(url, url);
            checker.put(url, url);
            Iterator iter = existingUrl.entrySet().iterator();
            do {

                Map.Entry entry = (Map.Entry) iter.next();
                System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
                if (entry.getKey().equals("") || entry.getValue().equals("")) {
                    System.out.println("EMPTY ADRESS I HashMap");
                } else {
                    try {
                        goToOmInstitutione((String) entry.getKey());
                    } catch (NullPointerException e) {
                    }
                }
                iter.remove();
                iter = existingUrl.entrySet().iterator();
            } while (iter.hasNext());
        }
    }


    private void getTilsysnrapport(Element y ){
        if(y.toString().contains("tilsyn")||y.toString().contains("Tilsyn")){
            if(doc.createDocument(y.attr("abs:href"))==null){
                if(ValidateContentAttay.validateContent(vuggestuer.get(i).getLink(),y.attr("abs:href"))) {
                    vuggestuer.get(i).addLink(y.attr("abs:href"));
                    //TODO: Denne skla med, hvis der skal downloades en pdf.
                    pdfWriter.download(y.attr("abs:href"), y.text(), separateDot(vuggestuer.get(i).getBaseLink())[1], vuggestuer.get(i));
                }
            }
        }
    }

}
