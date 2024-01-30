package org.example.Task2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParserXML {
    private File file;

    public ParserXML() {
        String projectBaseDir = System.getProperty("user.dir");
        String fileName = "results.xml"; // Replace with the actual file name
        Path filePath = Paths.get(projectBaseDir, fileName);
        String absolutePath = filePath.toAbsolutePath().toString();
        this.file = new File(absolutePath);
    }

    public ParserXML(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Package> parser() throws IOException, SAXException, ParserConfigurationException {

        List<Package> packagess = new ArrayList<>();
        if(file.exists() && file.getAbsolutePath().endsWith(".xml")) {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList packages = doc.getElementsByTagName("Package");

            for (int i = 0; i < packages.getLength(); i++) {
                Package pko = new Package();
                Node pk = packages.item(i);

                if (pk.getNodeType() == Node.ELEMENT_NODE) {

                    Element pk_element = (Element) pk;

                    if(pk_element.getAttribute("name") != ""){
                        pko.setName(pk_element.getAttribute("name"));
                        NodeList pk_detail = pk.getChildNodes();

                        for (int j = 0; j < pk_detail.getLength(); j++) {

                            Node detail = pk_detail.item(j);

                            if(detail.getNodeType() == Node.ELEMENT_NODE){

                                Element detail_element = (Element) detail;
                                switch (detail_element.getTagName()){
                                    case "Stats":
                                        Stats stats = new Stats();
                                        NodeList detail_element2 = detail_element.getChildNodes();

                                        for (int k = 0; k < detail_element2.getLength(); k++) {

                                            Node detail2 = detail_element2.item(k);

                                            if(detail2.getNodeType() == Node.ELEMENT_NODE){
                                                switch (detail2.getNodeName()){
                                                    case "TotalClasses":
                                                        stats.setTotalClasses(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    case "ConcreteClasses":
                                                        stats.setConcreteClasses(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    case "AbstractClasses":
                                                        stats.setAbstractClasses(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    case "Ca":
                                                        stats.setCa(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    case "Ce":
                                                        stats.setCe(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    case "A":
                                                        stats.setA(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    case "I":
                                                        stats.setI(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    case "D":
                                                        stats.setD(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    case "V":
                                                        stats.setV(Float.parseFloat(detail2.getTextContent()));
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                        }
                                        pko.setStats(stats);
                                        break;
                                    case "AbstractClasses":
                                        List<String> abstractClasses = new ArrayList<>();
                                        NodeList detail_element3 = detail_element.getChildNodes();

                                        for (int k = 0; k < detail_element3.getLength(); k++) {

                                            Node detail2 = detail_element3.item(k);

                                            if (detail2.getNodeType() == Node.ELEMENT_NODE) {
                                                abstractClasses.add(detail2.getTextContent());
                                            }
                                        }
                                        pko.setAbstractClasses(abstractClasses);
                                        break;
                                    case "ConcreteClasses":
                                        List<String> concreteClasses = new ArrayList<>();
                                        NodeList detail_element4 = detail_element.getChildNodes();

                                        for (int k = 0; k < detail_element4.getLength(); k++) {

                                            Node detail2 = detail_element4.item(k);

                                            if (detail2.getNodeType() == Node.ELEMENT_NODE) {
                                                concreteClasses.add(detail2.getTextContent());
                                            }
                                        }
                                        pko.setConcreteClasses(concreteClasses);
                                        break;
                                    case "DependsUpon":
                                        List<String> dependsUpon = new ArrayList<>();
                                        NodeList detail_element5 = detail_element.getChildNodes();

                                        for (int k = 0; k < detail_element5.getLength(); k++) {

                                            Node detail2 = detail_element5.item(k);

                                            if (detail2.getNodeType() == Node.ELEMENT_NODE) {
                                                dependsUpon.add(detail2.getTextContent());
                                            }
                                        }
                                        pko.setDependsUpon(dependsUpon);
                                        break;
                                    case "UsedBy":
                                        List<String> usedBy = new ArrayList<>();
                                        NodeList detail_element6 = detail_element.getChildNodes();

                                        for (int k = 0; k < detail_element6.getLength(); k++) {

                                            Node detail2 = detail_element6.item(k);

                                            if (detail2.getNodeType() == Node.ELEMENT_NODE) {
                                                usedBy.add(detail2.getTextContent());
                                            }
                                        }
                                        pko.setUsedBy(usedBy);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                }
                if(pko.getName() != null) {
                    packagess.add(pko);
                }
            }
        }
        return packagess;
    }
}
