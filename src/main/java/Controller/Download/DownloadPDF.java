package Controller.Download;

import Controller.TesxtExtraction.OCR;
import Model.DTO.Institutions.Vuggestue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;




public class DownloadPDF {

    public DownloadPDF(){}

    public void download(String adress, String filename, String path, Vuggestue vuggestue) {

        String nyfilename=filename.concat(endFileType(filename));
        nyfilename=cleanUpFilename(nyfilename);
        //Indsætter file og pathname til senere brug
        vuggestue.addTilsynsPath("./"+path+"/"+nyfilename);
        try {
            createDirectory(path);
            System.out.println("opening connection");
            URL url = new URL(adress);
            InputStream in = url.openStream();
            FileOutputStream fos = new FileOutputStream(new File("./"+path+"/"+nyfilename));

            System.out.println("reading from resource and writing to file...");

            //So that it is empty in the bit array
            int length = -1;



            byte[] buffer = new byte[1024];// buffer for portion of data from connection
            while ((length = in.read(buffer)) > -1) {

                fos.write(buffer, 0, length);
            }


            fos.close();
            in.close();
            System.out.println("File downloaded");

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void createDirectory(String directoryName){


        File file = new File(directoryName);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }

    private String endFileType(String link){

        //TODO:Sikrer at en filepath ikke bliver til ..pdf eller ..docx
        if(link.contains(".docx")||link.contains(".pdf")){
            return "";
        }
        else{
            return ".pdf";
        }
    }


    private String cleanUpFilename(String nyFirlename){
        String nyFilename = nyFirlename.replace(",","");
        return nyFilename;
    }
}

