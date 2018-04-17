import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Parser {
    public void getParsedText() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        final String fileName = "kurs.xml";

        DefaultHandler handler = new DefaultHandler() {
            boolean name = false;
            boolean value = false;
            boolean data = false;

            // Метод вызывается когда SAXParser "натыкается" на начало тэга
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("ValCurs")) {
                    //valueis=attributes.getValue("Date");
                    System.out.println();
                    System.out.println("Информация на момент: " + attributes.getValue("Date"));
                    System.out.println();
                    data = true;
                }
                if (qName.equals("Name")) {//Если тег с именем Name, то ставим флаг
                    name = true;
                }
                if (qName.equals("Value")) {
                    value = true;
                }
            }

            // Метод вызывается когда SAXParser считывает текст между тэгами
            @Override
            public void characters(char ch[], int start, int length) {
                // Если перед этим мы отметили, что имя тэга Name - значит нам надо текст использовать.
                if (name) {
                    System.out.print(new String(ch, start, length) + " ");
                    name = false;
                }
                if (value) {
                    System.out.println(new String(ch, start, length));
                    value = false;
                }
            }
        };
        parser.parse(fileName, handler);
    }
}


