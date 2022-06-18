package reports;

import forms.TableToXML;
import org.apache.fop.apps.*;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;

public class ReportBuilder {
    public static void main(String[] args) throws FOPException, IOException, TransformerException {

    }

    public static void getReport(String tableName)
    {
        TableToXML table = new TableToXML(tableName);
        try {
            String answer = table.getTableData();
            InputStream is = new ByteArrayInputStream(answer.getBytes(StandardCharsets.UTF_8));
            StreamSource xmlSource = new StreamSource(is);
            ReportBuilder report = new ReportBuilder();
            report.convertToPDF(xmlSource, tableName);
            showMessageDialog(null, "Отчет сформирован");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (FOPException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (TransformerException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void convertToPDF(StreamSource xmlSource, String xslFileName)  throws IOException, FOPException, TransformerException
    {
        File xsltFile = new File("src//main//resources//reports//" + xslFileName + ".xsl");

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        OutputStream out;
        out = new java.io.FileOutputStream("src//main//resources//reports//test.pdf");
        try
        {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, res);
        }
        finally
        {
            out.close();
        }
    }
}
