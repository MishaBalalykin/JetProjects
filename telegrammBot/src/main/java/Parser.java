import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

class Parser {
    void getParsedText() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        final String fileName = "kurs.xml";

        DefaultHandler handler = new DefaultHandler() {
            boolean name = false;
            boolean value = false;
            boolean data = false;

            // ����� ���������� ����� SAXParser "����������" �� ������ ����
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (qName.equals("ValCurs")) {
                    System.out.println();
                    System.out.println("���������� �� ������: " + attributes.getValue("Date"));
                    System.out.println();
                    data = true;
                }
                if (qName.equals("Name")) {//���� ��� � ������ Name, �� ������ ����
                    name = true;
                }
                if (qName.equals("Value")) {
                    value = true;
                }
            }

            // ����� ���������� ����� SAXParser ��������� ����� ����� ������
            @Override
            public void characters(char ch[], int start, int length) {
                // ���� ����� ���� �� ��������, ��� ��� ���� Name - ������ ��� ���� ����� ������������.
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


