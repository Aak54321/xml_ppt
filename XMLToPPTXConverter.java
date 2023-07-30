import org.apache.poi.xslf.usermodel.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class XMLToPPTXConverter {

    public static void main(String[] args) {
        try {
            // Load XML data from an external file
            String xmlFilePath = "sample.xml";
            InputStream xmlInputStream = new FileInputStream(xmlFilePath);

            // Create a new PowerPoint presentation
            XMLSlideShow ppt = new XMLSlideShow();

            // Parse the XML content and populate the slides
            NodeList slides = readXMLContent(xmlInputStream);
            for (int i = 0; i < slides.getLength(); i++) {
                Element slideElement = (Element) slides.item(i);
                String title = slideElement.getElementsByTagName("title").item(0).getTextContent();
                String content = slideElement.getElementsByTagName("content").item(0).getTextContent();

                XSLFSlide slide = ppt.createSlide();
                XSLFTextShape titleShape = slide.createTextBox();
                titleShape.setText(title);
                titleShape.setAnchor(new java.awt.Rectangle(50, 50, 500, 50));

                XSLFTextShape contentShape = slide.createTextBox();
                contentShape.setText(content);
                contentShape.setAnchor(new java.awt.Rectangle(50, 100, 500, 300));
            }

            // Save the PowerPoint presentation to a file
            String pptxOutputPath = "output.pptx";
            FileOutputStream out = new FileOutputStream(pptxOutputPath);
            ppt.write(out);
            out.close();

            System.out.println("XML to PPTX conversion completed successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Replace this method with your actual XML parsing logic
    private static NodeList readXMLContent(InputStream xmlInputStream) throws Exception {
        // Create a DocumentBuilder using DOM parser
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // Parse the XML content from the input stream
        Document doc = dBuilder.parse(xmlInputStream);

        // Optional: Normalize the XML document (ignores comments, whitespaces, etc.)
        doc.getDocumentElement().normalize();

        // Get the list of slide elements
        return doc.getElementsByTagName("slide");
    }
}
