import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataValidator {
    private String getCorrectFormat(String[] parsedCommand){
        String date = "";
        for (int i = 1; i < parsedCommand.length; i++) {
            date += parsedCommand[i];
            if (i < parsedCommand.length - 1) {
                date += "/";
            }
        }
        System.out.println("date = " + date);
        return date;
    }
    private String isDateValid(String data){
        final String DATE_FORMAT = "dd/MM/yyyy";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(data);
            return data;
        } catch (ParseException e) {
            System.out.println("pars");
            return "invalidData";
        }
    }

    public String getDate(String[] parsedCommand){
        String date = isDateValid(getCorrectFormat(parsedCommand));
        Date docDate = null;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd/MM/yyyy");
        try {
            docDate= format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!date.equalsIgnoreCase("invalidData")){
            System.out.println("dateHear = " + date);
            if (docDate.compareTo(new Date())>0){
                return "future";
            }else return date;
        }else return "invalidData";
    }
}
