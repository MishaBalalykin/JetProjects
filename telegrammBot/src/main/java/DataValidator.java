public class DataValidator {
    public String getCorrectFormat(String[] parsedCommand){
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
}
