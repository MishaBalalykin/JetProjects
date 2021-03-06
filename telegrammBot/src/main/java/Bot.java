import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "USER";
        //возвращаем юзера
    }

    @Override
    public void onUpdateReceived(Update e) {
        Message msg = e.getMessage(); // Это нам понадобится
        String txt = msg.getText();
        Parser parser = new Parser();
        MessageCreator messageCreator = new MessageCreator();
        String txtCopy = txt;
        if (txt.equalsIgnoreCase("/start")) {
            sendMsg(msg, "Hi, i'm valuta bot! Please look at list of my comand"+System.lineSeparator()+
                    "If you want to get exchange rates for chosen date send date in format \"/valuta/XX.XX.XXXX\"");

        }
        else if (txt.equalsIgnoreCase("/nextPresidentOfRussia")){
            sendMsg(msg, "Vladimir Vladimirovich Putin");
        }
        else if (parser.parse(txtCopy).equalsIgnoreCase("valuta")){
            sendMsg(msg, messageCreator.getMessage(txt, parser));
        }else sendMsg(msg, "I don't know such command");
    }

    @Override
    public String getBotToken() {
        return "562944867:AAHs-QFWWy0UxXRufagfAbcbrnv177oJlz8";
        //Токен бота
    }

    @SuppressWarnings("deprecation") // Означает то, что в новых версиях метод уберут или заменят
    private void sendMsg(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception
            sendMessage(s);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}