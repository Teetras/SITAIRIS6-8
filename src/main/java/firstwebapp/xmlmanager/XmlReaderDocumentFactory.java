package firstwebapp.xmlmanager;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class XmlReaderDocumentFactory implements XmlReader<Pair<Integer, List<Product>>> {

    private final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    @Override
    public Pair<Integer, List<Product>> readFromFile(String filePath) {
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(filePath));

            Element root = doc.getDocumentElement();

            NodeList productNodes = root.getElementsByTagName("product");

            List<Product> products = new ArrayList<>();

            for (int i = 0; i < productNodes.getLength(); i++) {
                Element productElement = (Element) productNodes.item(i);
                String name = productElement.getElementsByTagName("name").item(0).getTextContent();
                String description = productElement.getElementsByTagName("description").item(0).getTextContent();
                int price = Integer.parseInt(productElement.getElementsByTagName("price").item(0).getTextContent());
                String group = productElement.getElementsByTagName("group").item(0).getTextContent();

                Product product = new Product(name, description, price, group);
                products.add(product);
            }

            AtomicInteger totalSize = new AtomicInteger();

            products.forEach(product -> {
                // Assuming Product class has a getSize() method
                totalSize.addAndGet(product.getPrice());
            });

            return new MutablePair<>(totalSize.get(), products);
        } catch (Exception e) {
            return new MutablePair<>(0, Collections.emptyList());
        }
    }
}