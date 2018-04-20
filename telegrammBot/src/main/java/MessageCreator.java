import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MessageCreator {
    URLGenerator urlGenerator = new URLGenerator();
    ServiceRequest serviceRequest = new ServiceRequest();

    public String getMessage(String txt, Parser parser) {
        String answer = " ";
        String url = urlGenerator.createURL(txt);
        if (url.equalsIgnoreCase("error")) {
            answer = "Error";
        } else {
            serviceRequest.createRequest(url);
            try {
                answer = parser.getParsedText();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return answer;
    }
}
