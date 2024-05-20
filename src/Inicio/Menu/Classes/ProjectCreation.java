package Inicio.Menu.Classes;

import Lists.MySinglyLinkedList.SinglyLinkedList;
import javax.swing.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ProjectCreation {
    private static SinglyLinkedList<Project> projects = new SinglyLinkedList<>();
    public static void Create (String name, String description, String user , File file, JLabel report) throws ParserConfigurationException, TransformerException {
        try {
            projects.add(new Project(name,description,user));
            DocumentBuilderFactory document = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = document.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();
            Element root = doc.createElement(name);
            doc.appendChild(root);
            Element valores = doc.createElement("valores");
            root.appendChild(valores);
            Element catologo = doc.createElement("Catalogo");
            catologo.appendChild(doc.createTextNode("Catologo"));
            valores.appendChild(catologo);
            Element PorHacer = doc.createElement("Por_hacer");
            PorHacer.appendChild(doc.createTextNode("Por_hacer"));
            valores.appendChild(PorHacer);
            Element EnProceso = doc.createElement("En_proceso");
            EnProceso.appendChild(doc.createTextNode("En proceso"));
            valores.appendChild(EnProceso);
            Element verificar = doc.createElement("Por_verificar");
            verificar.appendChild(doc.createTextNode("Por_verificar"));
            valores.appendChild(verificar);
            Element Hecho = doc.createElement("Hecho");
            Hecho.appendChild(doc.createTextNode("Hecho"));
            valores.appendChild(Hecho);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult fileResult = new StreamResult(file);
            transformer.transform(source, fileResult);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (DOMException e) {
            report.setText("Formato de nombre no valido");
            throw new RuntimeException(e);
        } catch (TransformerFactoryConfigurationError e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }

}
