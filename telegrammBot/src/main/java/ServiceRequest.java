import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.*;

class ServiceRequest {
    void createRequest(String url) {
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class); // �������� ����� �� ������� application/xml - MIME ����

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("kurs.xml"), "windows-1251")) {
            outputStreamWriter.write(response.getEntity(String.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}