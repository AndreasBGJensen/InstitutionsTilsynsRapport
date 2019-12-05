package Controller.CrawlerController;


import Controller.TextExtraction.PDFManager;
import Model.Crawler.TraverserURL;
import Model.Crawler.documentURL;
import Model.Crawler.soegningURL;
import Model.DTO.Institutions.Vuggestue;
import Model.IBaseURL;

import java.util.List;

public class ControllerGETTilsynsrapport {
    documentURL doc = new documentURL();
    IBaseURL getbaseUrl = new soegningURL(doc);
    TraverserURL traversering;
    List<Vuggestue> vuggestuer;
    PDFManager extractPdf;

    public ControllerGETTilsynsrapport() {
    }

    /*
   Retrives Tilsynsrapporter from kk webside.
    */
    public List<Vuggestue> getTilsynsrapport(String searchAddress, String keyword) {

        vuggestuer = getbaseUrl.getVuggestuer(searchAddress, keyword);
        traversering = new TraverserURL(doc, vuggestuer);    //Adding the links to the vuggestue.
        extractPdf = new PDFManager(vuggestuer);
        return vuggestuer;
    }


    /*
    Returns a list of institutions without retriving all the tilsynsrapports.
     */
    public List<Vuggestue> getInstitutions(String searchAddress, String keyword) {
        return vuggestuer = getbaseUrl.getVuggestuer(searchAddress, keyword);
    }

}
