package Inicio.Menu.Classes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.PriorityQueue;


public class ExportarFile {

    private static PriorityQueue<Task> catalago = new PriorityQueue<>();
    private static PriorityQueue<Task> porHacer = new PriorityQueue<>();
    private static PriorityQueue<Task> enProgreso = new PriorityQueue<>();
    private static PriorityQueue<Task> porVerificar =  new PriorityQueue<>();
    private static PriorityQueue<Task> hecho = new PriorityQueue<>();

    public  static void importFile() throws ParserConfigurationException, IOException, SAXException {

        File file = new File("ImplementacionAED_proyect02_colas.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        NodeList catalogoNodes = document.getElementsByTagName("Catalago");
        for (int i = 0; i < catalogoNodes.getLength(); i++){
            Node catalogoNode = catalogoNodes.item(i);
            if (catalogoNode.getNodeType() == Node.ELEMENT_NODE){
                Element catalogoElement = (Element) catalogoNode;
                NodeList nodos = catalogoElement.getChildNodes();
                for (int j = 0; j < nodos.getLength(); j++){
                    Node taskNode = nodos.item(j);
                    if (taskNode.getNodeType() == Node.ELEMENT_NODE){
                        Task task = createTasks((Element) taskNode);
                        catalago.add(task);
                    }
                }
            }
        }

        NodeList porHacerNodes = document.getElementsByTagName("PorHacer");
        for (int i = 0; i < porHacerNodes.getLength(); i++){
            Node porHacerNode = porHacerNodes.item(i);
            if (porHacerNode.getNodeType() == Node.ELEMENT_NODE){
                Element porHacerElement = (Element) porHacerNode;
                NodeList nodosPorhacer= porHacerElement.getChildNodes();
                for (int j = 0; j < nodosPorhacer.getLength(); j++){
                    Node taskNode = nodosPorhacer.item(j);
                    if (taskNode.getNodeType() == Node.ELEMENT_NODE){
                        Task task = createTasks((Element) taskNode);
                        porHacer.add(task);
                    }
                }
            }
        }

        NodeList enProgresoNodes = document.getElementsByTagName("enProgreso");
        for (int i = 0; i < enProgresoNodes.getLength(); i++){
            Node enProgresoNode = enProgresoNodes.item(i);
            if (enProgresoNode.getNodeType() == Node.ELEMENT_NODE){
                Element enProgresoElement = (Element) enProgresoNode;
                NodeList nodosEnProgreso= enProgresoElement.getChildNodes();
                for (int j = 0; j < nodosEnProgreso.getLength(); j++){
                    Node taskNode = nodosEnProgreso.item(j);
                    if (taskNode.getNodeType() == Node.ELEMENT_NODE){
                        Task task = createTasks((Element) taskNode);
                        enProgreso.add(task);
                    }
                }

            }
        }

        NodeList porVerificarNodes = document.getElementsByTagName("porVerificar");
        for (int i = 0; i < porVerificarNodes.getLength(); i++){
            Node porVerificarNode = porVerificarNodes.item(i);
            if (porVerificarNode.getNodeType() == Node.ELEMENT_NODE){
                Element porVerificarElement = (Element) porVerificarNode;
                NodeList nodosPorVerificar= porVerificarElement.getChildNodes();
                for (int j = 0; j < nodosPorVerificar.getLength(); j++){
                    Node taskNode = nodosPorVerificar.item(j);
                    if (taskNode.getNodeType() == Node.ELEMENT_NODE){
                        Task task = createTasks((Element) taskNode);
                        porVerificar.add(task);
                    }
                }
            }
        }

        NodeList HechoNodes = document.getElementsByTagName("Hecho");
        for (int i = 0; i < HechoNodes.getLength(); i++){
            Node hechoNode = HechoNodes.item(i);
            if (hechoNode.getNodeType() == Node.ELEMENT_NODE){
                Element hechoElement = (Element) hechoNode;
                NodeList nodosHecho= hechoElement.getChildNodes();
                for (int j = 0; j < nodosHecho.getLength(); j++){
                    Node taskNode = nodosHecho.item(j);
                    if (taskNode.getNodeType() == Node.ELEMENT_NODE){
                        Task task = createTasks((Element) taskNode);
                        hecho.add(task);
                    }
                }
            }
        }

        System.out.println("\nCatalago");
        System.out.println(catalago);
        System.out.println("\nporHacer");
        System.out.println(porHacer);
        System.out.println("\nenProgreso");
        System.out.println(enProgreso);
        System.out.println("\nporVerificar");
        System.out.println(porVerificar);
        System.out.println("\nhecho");
        System.out.println(hecho);

    }

    public static PriorityQueue<Task> getCatalago() {
        return catalago;
    }

    public static PriorityQueue<Task> getPorHacer() {
        return porHacer;
    }

    public static PriorityQueue<Task> getEnProgreso() {
        return enProgreso;
    }

    public static PriorityQueue<Task> getPorVerificar() {
        return porVerificar;
    }

    public static PriorityQueue<Task> getHecho() {
        return hecho;
    }

    private static Task createTasks(Element element) {
        int numTasks = Integer.parseInt(element.getElementsByTagName("NumeroTarea").item(0).getTextContent());
        String nameTask = element.getElementsByTagName("NombreTarea").item(0).getTextContent();
        LocalDateTime startTime = LocalDateTime.parse(element.getElementsByTagName("HoraLlegada").item(0).getTextContent());
        State statusTask = State.valueOf(element.getElementsByTagName("EstadoTarea").item(0).getTextContent());
        int priorityTask = Integer.parseInt(element.getElementsByTagName("Prioridad").item(0).getTextContent());
        String assignedUserName = element.getElementsByTagName("UsuarioEncargado").item(0).getTextContent();

        return new Task(numTasks,assignedUserName,statusTask,nameTask,priorityTask,startTime);
    }
    public static void exportFile(PriorityQueue<Task> catalago,PriorityQueue<Task> porHacer,PriorityQueue<Task> enProgreso,PriorityQueue<Task> porVerificar,
                                  PriorityQueue<Task> hecho) throws ParserConfigurationException, TransformerException, IOException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentoBuilder = factory.newDocumentBuilder();
        Document documentxml = documentoBuilder.newDocument();

        Element rootElement = documentxml.createElement("KanbanBoard");
        documentxml.appendChild(rootElement);

        Element elementsCatalogo = documentxml.createElement("Catalago");
        rootElement.appendChild(elementsCatalogo);
        for (Task task : catalago){
            Element element = crearELementTarea(documentxml, task);
            elementsCatalogo.appendChild(element);
        }

        Element elementsPorHacer = documentxml.createElement("PorHacer");
        rootElement.appendChild(elementsPorHacer);
        for (Task task : porHacer){
            Element element = crearELementTarea(documentxml, task);
            elementsPorHacer.appendChild(element);
        }

        Element elementENproceso = documentxml.createElement("enProgreso");
        rootElement.appendChild(elementENproceso);
        for (Task task : enProgreso){
            Element element = crearELementTarea(documentxml, task);
            elementENproceso.appendChild(element);
        }

        Element ElementsporVerificar = documentxml.createElement("porVerificar");
        rootElement.appendChild(ElementsporVerificar);
        for (Task task : porVerificar){
            Element element = crearELementTarea(documentxml, task);
            ElementsporVerificar.appendChild(element);
        }

        Element ElementsHecho = documentxml.createElement("Hecho");
        rootElement.appendChild(ElementsHecho);
        for (Task task : hecho){
            Element element = crearELementTarea(documentxml, task);
            ElementsHecho.appendChild(element);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(documentxml);
        StreamResult result = new StreamResult(new FileWriter("archivos\\comoadse"+".xml"));
        transformer.transform(source, result);

    }

    private static Element crearELementTarea(Document docXml,Task task){
        Element taskELements = docXml.createElement("Tareas");

        Element numTaskElement = docXml.createElement("NumeroTarea");
        numTaskElement.appendChild(docXml.createTextNode(String.valueOf(task.getId())));
        taskELements.appendChild(numTaskElement);

        Element nameTask = docXml.createElement("NombreTarea");
        nameTask.appendChild(docXml.createTextNode(String.valueOf(task.getName())));
        taskELements.appendChild(nameTask);

        Element startTime = docXml.createElement("HoraLlegada");
        startTime.appendChild(docXml.createTextNode(String.valueOf(task.getStartTime())));
        taskELements.appendChild(startTime);

        Element statusTask = docXml.createElement("EstadoTarea");
        statusTask.appendChild(docXml.createTextNode(String.valueOf(task.getState())));
        taskELements.appendChild(statusTask);

        Element priorityTask = docXml.createElement("Prioridad");
        priorityTask.appendChild(docXml.createTextNode(String.valueOf(task.getPriority())));
        taskELements.appendChild(priorityTask);

        Element userTask = docXml.createElement("UsuarioEncargado");
        userTask.appendChild(docXml.createTextNode(String.valueOf(task.getUser())));
        taskELements.appendChild(userTask);


        return taskELements;
    }

}
