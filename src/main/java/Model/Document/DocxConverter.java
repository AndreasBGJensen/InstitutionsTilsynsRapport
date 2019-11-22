package Model.Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hslf.record.CString;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocxConverter {
    public static void main(String[] args) {
        DocxConverter docxC = new DocxConverter();
        docxC.convertDocxToPdf("C:/git/dtu/e19/InstitutionsTilsynsRapport/src/main/java/Model/Document/testDoc.docx", "C:/git/dtu/e19/InstitutionsTilsynsRapport/src/main/java/Model/Document/testDoc.pdf");
    }

    public void convertDocxToPdf(String fromPath, String toPath) {
        try {
            InputStream docx = new FileInputStream(new File(fromPath));
            XWPFDocument xwpfDoc = new XWPFDocument(docx);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(toPath));
            PdfConverter.getInstance().convert(xwpfDoc, out, options);
        } catch (IOException IOEx) {
            System.out.println(IOEx.getMessage());
        }
    }
}
