import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MessageCreator {
    private URLGenerator urlGenerator = new URLGenerator();
    private ServiceRequest serviceRequest = new ServiceRequest();

    public String getMessage(String txt, Parser parser) {
        String answer = " ";
        String url = urlGenerator.createURL(txt);
        System.out.println("url = "+url);
        if (url.equalsIgnoreCase("invalidData")) {
            answer = "You have entered incorrect date";
        }else if (url.equalsIgnoreCase("future")){
            answer = "I can not say anything about the future except who will be the next president of Russia"+System.lineSeparator()+
            "if you want to know who send command \"/nextPresidentOfRussia\"";
        }
        else {
            serviceRequest.createRequest(url);
            try {
                answer = parser.getParsedText();
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        }
        return answer;
    }
}
