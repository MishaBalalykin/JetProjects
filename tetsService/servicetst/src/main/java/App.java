public class App {
    private static ServiceRequest serviceRequest = new ServiceRequest();
    private static Parser parser = new Parser();
    public static void main(String[] args) throws Exception {
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=17/04/2018";
        //String url = "http://localhost:8080/greeting";
        serviceRequest.createRequest(url);
        parser.getParsedText();

    }
}

