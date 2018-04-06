import java.io.*;
import java.util.Collection;

public class ReaserFile {
    static String string = "";

    private static void create(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true))) {
            bufferedWriter.write("jet jet jet");
            bufferedWriter.write(System.lineSeparator()+"jet");
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void read(){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"))){
            while (bufferedReader.ready()){
                string += bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void write(){
        System.out.println(string);
    }

    public static void main(String[] args) {
        create();
        read();
        write();
    }
}
