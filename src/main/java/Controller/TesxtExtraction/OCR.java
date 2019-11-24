package Controller.TesxtExtraction;

import Model.DTO.Institutions.Vuggestue;
import com.asprise.ocr.Ocr;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.File;
import java.io.IOException;

public class OCR {


    public static void CreatePdfWithTextDemo(Vuggestue vuggestue, int h) throws IOException {

        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine



            ocr.startEngine("eng", Ocr.SPEED_FAST); // English
            String s = ocr.recognize(new File[]{new File(vuggestue.getTilsynsPath().get(h))},
                    Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PDF, new Ocr.PropertyBuilder()
                            .setPdfOutputFile(alternatePath(vuggestue.getTilsynsPath().get(h)))
                            .setPdfTextVisible(true));
        String newPath = alternatePath(vuggestue.getTilsynsPath().get(h));
            vuggestue.setTilsynsPath(h,newPath);


            /*String s = ocr.recognize(new File[]{new File("C:\\Uddannelse\\Institution\\olympia\\Tilsynsrapport Olympia 2019.pdf")},
                    Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PDF, new Ocr.PropertyBuilder()
                            .setPdfOutputFile("C:\\Uddannelse\\Institution\\olympia\\OCRTilsynsrapport Olympia 2019.pdf")
                            .setPdfTextVisible(true)); // PLAINTEXT | XML | PDF | RTF*/


           // System.out.println("Result: " + s);


        ocr.stopEngine();

    }

  private static String alternatePath(String originalPath) {
        String newPath = originalPath.substring(0,originalPath.length()-4);
        newPath+="OCR.pdf";

        return newPath;

  }

}
