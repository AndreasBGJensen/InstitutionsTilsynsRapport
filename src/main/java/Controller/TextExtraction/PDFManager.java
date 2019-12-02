package Controller.TesxtExtraction;

import java.io.File;
import java.io.IOException;

import Model.DTO.Institutions.Indstser;
import Model.DTO.Institutions.Vuggestue;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFManager {

    List<Vuggestue> vuggestuer;
    private PDFParser parser;
    private PDFTextStripper pdfStripper;
    private PDDocument pdDoc;
    private COSDocument cosDoc;

    private String Text;
    private String filePath;
    private File file;
    public ArrayList<String> indsatser = new ArrayList<String>();
    public ArrayList<String> kriterier = new ArrayList<String>();



    int  countDown = 0;

    public PDFManager(){}
    public PDFManager(List<Vuggestue> vuggestuer){

        this.vuggestuer = vuggestuer;

        String ins = "barn/voksenkontakten";
        String uns2 = "Inklusion og fællesskab  ";
        String uns3 = "Sprogindsatsen";
        String uns6 = "Forældresamarbejde";
        String uns4 = "Sammenhæng og overgange";
        String uns5 = "Krav om refleksion og metodisk systematik i den pædagogiske praksis";
        kriterier.add(ins);
        kriterier.add(uns2);
        kriterier.add(uns3);
        kriterier.add(uns6);
        kriterier.add(uns4);
        kriterier.add(uns5);


        String a = "Vedligeholdelse af indsats";
        String b = "Tilpasning af indsats";
        indsatser.add(a);
        indsatser.add(b);

        getIndsatser();
    }


    public String toText() throws IOException {
       try {
           this.pdfStripper = null;
           this.pdDoc = null;
           this.cosDoc = null;

           file = new File(filePath);
           parser = new PDFParser(new RandomAccessFile(file, "r")); // update for PDFBox V 2.0

           parser.parse();
           cosDoc = parser.getDocument();
           pdfStripper = new PDFTextStripper();
           pdDoc = new PDDocument(cosDoc);
           pdDoc.getNumberOfPages();
           pdfStripper.setStartPage(0);
           pdfStripper.setEndPage(pdDoc.getNumberOfPages());
           Text = pdfStripper.getText(pdDoc);


           return Text;
       }catch (IOException e){
           System.out.println("Kunne ikke læse fil");
           e.printStackTrace();

           return "";
       }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    private void getIndsatser(){

        Indstser indsats;


        for (Vuggestue a:vuggestuer) {//Looping through all institutions
            for (int h = 0; h < a.getTilsynsPath().size(); h++) { // Looping through all the tilsyn
                indsats = new Indstser();
                indsats.setTilsyn(a.getTilsynsPath().get(h));

                setFilePath(a.getTilsynsPath().get(h));
                a.addIndsts(indsats);
                System.out.println(a.getNavn());
                try {

                    String text = toText();
                    setFilePath(text);
                    //pdfManager.indsatsExist(text);

                    System.out.println(indsats.toString());

                    String[] testIndex = text.split("\\r\\n");
                    //String[] testIndex = text.split("\\n");//Dette er til, hvis pdffilen er ocr behandlet af tess4J

                    for (int i = 0; i < testIndex.length; i++) {
                        String test = testIndex[i];

                        //This filters all the kriteria
                        if (test.contains("Krav om refleksion") || test.contains("Krav om refleksion og")||test.contains("Refleksion og metodisk systematik")
                                || test.contains(" Inklusion og fællesskab ") || test.contains("Inklusion og fællesskab") || test.contains("Inklusion og faellesskab") || test.contains("Inklusion og fællesskab")
                                || test.contains("Forældresamarbejde") || test.contains("Foraeldresamarbejde")
                                || test.contains(" Sammenhæng og overgange") || test.contains("Sammenhæng og overgange") || test.contains("Sammenhaeng og") || test.contains("Sammenhæng og overgange") || test.contains(" Sammenhæng og ") || test.contains("Sammenhang og")
                                || test.contains("Sprogindsatsen")||test.contains("Sprogindsats")||test.contains("Sprogindsat")
                                || test.contains("barn/voksenkontakten")||test.contains("Sociale relationer – barn/voksen kontakten"))  {
                            System.out.println();

                            for (int j = i; j < j + 17; j++) {

                                //Ensure that we do not have a index out of bound exception
                                if (j == testIndex.length) {
                                    break;
                                }

                                //This filtrates alle the status remarks
                                if (testIndex[j].contains("Vedligeholdelse af indsats")||
                                        testIndex[j].contains("Tilpasning af indsats")||testIndex[j].contains("tilpasning af indsats")||
                                        testIndex[j].contains("Indsats Behov for ny/ændret indsats")||testIndex[j].contains("behov for ny og ændre indsats")) {
                                    System.out.println("\t\t" + testIndex[j]);
                                    indsats.addIndsats(testIndex[i], testIndex[j]);
                                    break;
                                }
                            }


                        }

                    }
                    if(a.getIndsats(h).getIndsatser().size()==0){
                        //TODO: Make sure that it will extract text from the OCR pdf
                       // Controller.TesxtExtraction.OCR.CreatePdfWithTextDemo(a,h);

                    }

                } catch (IOException ex) {
                    Logger.getLogger(PDFManager.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public static void main(String[] args) {
        HashMap<String,String> indsats = new HashMap<String, String>();
        PDFManager pdfManager = new PDFManager();

        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\prinsessethyra\\asprise-ocr-2019_11_08-00_42_26_048.pdf");//Virker OCR behandlet
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\olympia\\OCRTilsynsrapport Olympia 2019.pdf");//Virker OCR behandlet
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\kaalormen\\OCRTilsyn 2018.pdf");//Virker OCR behandlet
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\kaalormen\\OCRTilsynsrapport.pdf");//Virker OCR behandlet
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\dronninglouisesasyl\\Tilsynsrapport 2018.pdf");//Virker
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\fix-karreen\\Tilsyn 2019.pdf");//Virker
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\cismofytten\\tilsynsrapport 2019.pdf");//Virker
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\cismofytten\\tilsynsrapport 2017.pdf");//Virker i f�rste fors�g
        //pdfManager.setFilePath("C:\\Uddannelse\\ASPRISE\\\\asprise-ocr-2019_11_12-19_52_57_539.pdf");//Fil er OCR og er testet og virker
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\dengroennegiraf\\Tilsyns rapport.pdf");//Test virker med denne metode;
        //pdfManager.setFilePath("C:\\Uddannelse\\Institution\\carolinehaven\\Tilsynsrapport 2018.pdf");//Test virker med denne metode
        //pdfManager.setFilePath("C:\\Uddannelse\\InstitutionsTilsynsRapport\\klerkegade\\191031 ny tilsyn Klerkegade (002).pdf");//Test virker med denne metode
        // pdfManager.setFilePath("C:\\Uddannelse\\InstitutionsTilsynsRapport\\kongehatten\\Pædagogisk tilsyn 2019.pdf");//Test virker med denne metode
        pdfManager.setFilePath("C:\\Uddannelse\\InstitutionsTilsynsRapport\\boernejunglen\\Tilsynsrapport 2017.pdf");


        try {
            //String text = resultFromOcr;//Fors�g med tess4J
            String text = pdfManager.toText();
            pdfManager.setFilePath(text);
            //pdfManager.indsatsExist(text);

            System.out.println(indsats.toString());

            String[] testIndex = text.split("\\r\\n");
            //String[] testIndex = text.split("\\n");//Dette er til, hvis pdffilen er ocr behandlet af tess4J

            for(int i=0;i<testIndex.length;i++){
                String test = testIndex[i];
                if(test.contains("Krav om refleksion") || test.contains("Krav om refleksion og")||test.contains("Refleksion og metodisk systematik")
                        || test.contains(" Inklusion og fællesskab ") || test.contains("Inklusion og fællesskab") || test.contains("Inklusion og faellesskab") || test.contains("Inklusion og fællesskab")
                        || test.contains("Forældresamarbejde") || test.contains("Foraeldresamarbejde")
                        || test.contains(" Sammenhæng og overgange") || test.contains("Sammenhæng og overgange") || test.contains("Sammenhaeng og") || test.contains("Sammenhæng og overgange") || test.contains(" Sammenhæng og ") || test.contains("Sammenhang og")
                        || test.contains("Sprogindsatsen")||test.contains("Sprogindsats")||test.contains("Sprogindsat")
                        || test.contains("barn/voksenkontakten")||test.contains("Sociale relationer – barn/voksen kontakten"))  {
                    System.out.println(testIndex[i]);


                    for(int j = i;j<j+testIndex.length;j++){

                        //Ensure that we do not have a index out of bound exception
                        if(j==testIndex.length){
                            break;
                        }
                        if(testIndex[j].contains("Vedligeholdelse af indsats")||
                                testIndex[j].contains("Tilpasning af indsats")||testIndex[j].contains("tilpasning af indsats")||
                                testIndex[j].contains("Indsats Behov for ny/ændret indsats")||testIndex[j].contains("behov for ny og ændre indsats")){
                            System.out.println("\t\t"+testIndex[j]);
                            break;
                        }
                    }


                }

            }


/*||test.contains(" Inklusion og f�llesskab ")||test.contains("Inklusion�og�f�llesskab")
                    ||test.contains("For�ldresamarbejde")
                    ||test.contains(" Sammenh�ng og overgange")||test.contains("Sammenh�ng�og�overgange")*/

        } catch (IOException ex) {
            Logger.getLogger(PDFManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




}
