package firstwebapp.xmlmanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String filePath = "D:\\SITAIRIS_6\\src\\main\\resources\\test.xml";

            XmlReader<Pair<Integer, List<Product>>> reader = new XmlReaderDocumentFactory();
            XmlManager<Pair<Integer, List<Product>>> manager = new XmlManagerImpl(filePath,reader);



            request.setAttribute("product", manager.readFromFile());


            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("error", "An error occurred while processing the XML file.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
