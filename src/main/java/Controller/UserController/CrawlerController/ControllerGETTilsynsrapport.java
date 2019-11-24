package Controller.UserController.CrawlerController;



import Model.Downloader.DownloadPDF;
import Model.ExtractTextFromPdf.PDFManager;
import Model.GetBaseUrl.IBaseURL;
import Model.Vuggestue;

import javax.ws.rs.core.Response;
import java.util.List;

public class ControllerGETTilsynsrapport {
    documentURL doc = new documentURL();
    IBaseURL getbaseUrl = new soegningURL(doc);
    TraverserURL traversering;
    List<Vuggestue> vuggestuer;
    PDFManager extractPdf;

    public ControllerGETTilsynsrapport(){}

    public Response getTilsynsrapport(String searchAddress, String keyword){

        vuggestuer = getbaseUrl.getVuggestuer(searchAddress,keyword);
        traversering = new TraverserURL(doc,vuggestuer);    //Adding the links to the vuggestue.
        extractPdf = new PDFManager(vuggestuer);
        return Response.ok().entity(vuggestuer).build();
    }




}

