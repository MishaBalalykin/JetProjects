public class URLGenerator {
    private Parser parser;

    public URLGenerator() {
        parser = new Parser();
    }

    private String checkCorrectCommand(String[] parsedCommand){
        String stringFormat;
        stringFormat = String.format("%02d/%02d/%d", Integer.parseInt(parsedCommand[0]), Integer.parseInt(parsedCommand[1]), Integer.parseInt(parsedCommand[2]));
        System.out.println("stringFormat = " + stringFormat);
        return  stringFormat;
    }

    private String getDate(String[] parsedCommand){
        String date = "";
        for (int i = 0; i < parsedCommand.length; i++) {
            date += parsedCommand[i];
            if (i < parsedCommand.length - 1) {
                date += "/";
            }
        }
        System.out.println("date = " + date);
        return date;
    }



    public String createURL(String txt){
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=";
        String[] parsedCommand = parser.parseCommand(txt);
        String date = getDate(parsedCommand);
        String formatter = checkCorrectCommand(parsedCommand);

        if (formatter.equals(date)){
            return url + date;
        } else return "Error";
    }

}



