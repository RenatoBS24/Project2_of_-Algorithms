package Inicio.Menu.Classes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ImportProject {
    public static void Import(File file, JTable table) throws ParserConfigurationException, IOException, SAXException {
        DefaultTableModel model = new DefaultTableModel();
        DocumentBuilderFactory document = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = document.newDocumentBuilder();
        Document doc = documentBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("valores");
        if(nList.getLength() > 0) {
            Element element = (Element) nList.item(0);
            model.addColumn(String.valueOf(element.getElementsByTagName("Catalogo").item(0).getTextContent()));
            model.addColumn(String.valueOf(element.getElementsByTagName("Por_hacer").item(0).getTextContent()));
            model.addColumn(String.valueOf(element.getElementsByTagName("En_proceso").item(0).getTextContent()));
            model.addColumn(String.valueOf(element.getElementsByTagName("Por_verificar").item(0).getTextContent()));
            model.addColumn(String.valueOf(element.getElementsByTagName("Hecho").item(0).getTextContent()));
        }
        table.setModel(model);
    }
}
