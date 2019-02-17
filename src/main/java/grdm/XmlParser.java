package grdm;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

public class XmlParser {

    File stylesheet;

    public XmlParser(File stylesheet) {
        this.stylesheet = stylesheet;
    }


    public void parse(File xmlSource , File output) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlSource);

        StreamSource styleSource = new StreamSource(this.stylesheet);
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer(styleSource);
        Source source = new DOMSource(document);
        Result outputTarget = new StreamResult(output);
        transformer.transform(source, outputTarget);

    }
}
