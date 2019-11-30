package Controller.CrawlerController;



import Model.Crawler.TraverserURL;
import Model.Crawler.documentURL;
import Model.Crawler.soegningURL;
import Controller.TesxtExtraction.PDFManager;
import Model.IBaseURL;
import Model.DTO.Institutions.Vuggestue;

import java.util.List;

public class ControllerGETTilsynsrapport {
    documentURL doc = new documentURL();
    IBaseURL getbaseUrl = new soegningURL(doc);
    TraverserURL traversering;
    List<Vuggestue> vuggestuer;
    PDFManager extractPdf;

    public ControllerGETTilsynsrapport(){}

    public List<Vuggestue> getTilsynsrapport(String searchAddress, String keyword){

        vuggestuer = getbaseUrl.getVuggestuer(searchAddress,keyword);
        traversering = new TraverserURL(doc,vuggestuer);    //Adding the links to the vuggestue.
        extractPdf = new PDFManager(vuggestuer);
        return vuggestuer;
    }

    public List<Vuggestue> getInstitutions(String searchAddress, String keyword){
        return vuggestuer = getbaseUrl.getVuggestuer(searchAddress,keyword);
    }




}

