public class URLGenerator {
    private Parser parser;
    private DataValidator dataValidator;

    public URLGenerator() {
        parser = new Parser();
        dataValidator = new DataValidator();
    }

    public String createURL(String txt){
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=";
        String[] parsedCommand = parser.parseCommand(txt);
        String date = dataValidator.getDate(parsedCommand);
        System.out.println("checkdate = " + date);
        if (date.equalsIgnoreCase("invalidData")){
            return "invalidData";
        }else if (date.equalsIgnoreCase("future")){
            return "future";
        }
        else{ return url + date;}
    }

}



