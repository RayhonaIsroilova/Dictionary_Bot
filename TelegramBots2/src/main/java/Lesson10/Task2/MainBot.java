package Lesson10.Task2;

import Lesson10.Task2.model.DefItem;
import Lesson10.Task2.model.DictResult;
import Lesson10.Task2.model.TrItem;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainBot extends TelegramLongPollingBot {
    static String BotUsername ="@DICTIONARY_RIM_bot";
    static String BotToken ="1617588611:AAGLxL2bWl24Anl3pIIORrNqER8pRVbPGis";

    @Override
    public String getBotUsername() {
        return BotUsername;
    }

    @Override
    public String getBotToken() {
        return BotToken;
    }

    int level = 0;
    String language = "";
    TelegramBotImpl telegramBot = new TelegramBotImpl();
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        Long chatId;
        String text;
        if (update.hasMessage()) {
            chatId = update.getMessage().getChatId();
            text = update.getMessage().getText();

            if (text.equals("/start")) {
                level = 0;
            }
            else if (text.equals(Constants.ENGLISH_TO_RUSSIAN)  ||
                    text.equals(Constants.ENGLISH_TO_TURKISH)) {
                language = text;
                sendMessage.setText(Constants.ENTER);
                level = 3;
            }

            else if (text.equals(Constants.RUSSIAN_TO_ENGLISH)  ||
                    text.equals(Constants.RUSSIAN_TO_TURKISH)) {
                language = text;
                sendMessage.setText(Constants.ENTER);
                level = 3;
            }

            else if (text.equals(Constants.TURKISH_TO_RUSSIAN)  ||
                    text.equals(Constants.TURKISH_TO_ENGLISH)) {
                sendMessage.setText(Constants.ENTER);
                language = text;

                level = 3;
            }

            else if (text.equals(Constants.ENGLISH)){
                sendMessage.setChatId(chatId);
                getEnglish(sendMessage);
                level = 2;
            }
            else if (text.equals(Constants.RUSSIAN)){
                sendMessage.setChatId(chatId);
                getRussian(sendMessage);
                level = 2;
            }
            else if (text.equals(Constants.TURKISH)){
                sendMessage.setChatId(chatId);
                getTurkish(sendMessage);
                level = 2;
            }
            else if (text.equalsIgnoreCase(Constants.BACK)){
                sendMessage.setChatId(chatId);
                level =0;
            }
            else {
                level = 3;
            }
            sendMessage.setChatId(chatId);
            switch (level) {
                case 0:
                    execute(telegramBot.firstMenu(update));
                    level = 1;
                    break;
                case 1:
                    getResult(sendMessage);
                    level = 2;
                    break;
                case 2:
                    sendMessage.setText(Constants.MENU_FOR_CHOOSING);
                    sendMessage.setChatId(chatId);
                    level = 3;
                    break;
                case 3:
                    StringBuilder stringBuilder = new StringBuilder();
                    DictResult result = YandexUitl.lookUp(language, text);
                    List<DefItem> def = result.getDef();
                    for (DefItem defItem : def) {
                        List<TrItem> tr = defItem.getTr();
                        for (TrItem trItem : tr) {
                            stringBuilder.append( trItem.getText()).append("\n");
                        }
                    }
                    sendMessage.setChatId(chatId);
                    sendMessage.setText(String.valueOf(stringBuilder));
                    break;
                case 4:
                    execute(telegramBot.firstMenu(update));
                    break;
            }
        }
       execute(sendMessage);

    }
    public void getEnglish(SendMessage sendMessage) throws IOException {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        String[] langs = YandexUitl.getLangs();
        for (int i = 0; i < langs.length; i++) {
            if (langs[i].equals(Constants.ENGLISH_TO_TURKISH) ||  langs[i].equals(Constants.ENGLISH_TO_RUSSIAN)) {
                KeyboardRow keyboardRow = new KeyboardRow();
                keyboardRow.add(new KeyboardButton(langs[i]));
                keyboardRows.add(keyboardRow);
            }
        }
        KeyboardRow key = new KeyboardRow();
        key.add(new KeyboardButton(Constants.BACK));
        keyboardRows.add(key);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

    }
    public void getRussian(SendMessage sendMessage) throws IOException {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        String[] langs = YandexUitl.getLangs();
        for (int i = 0; i < langs.length; i++) {
            if (langs[i].equals(Constants.RUSSIAN_TO_TURKISH) || langs[i].equals(Constants.RUSSIAN_TO_ENGLISH)){
                KeyboardRow keyboardRow = new KeyboardRow();
                keyboardRow.add(new KeyboardButton(langs[i]));
                keyboardRows.add(keyboardRow);
            }
        }
        KeyboardRow key = new KeyboardRow();
        key.add(new KeyboardButton(Constants.BACK));
        keyboardRows.add(key);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
    }
    public void getTurkish(SendMessage sendMessage) throws IOException {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        String[] langs = YandexUitl.getLangs();
        for (int i = 0; i < langs.length; i++) {
            if (langs[i].equals(Constants.TURKISH_TO_ENGLISH) || langs[i].equals(Constants.TURKISH_TO_RUSSIAN)){
                KeyboardRow keyboardRow = new KeyboardRow();
                keyboardRow.add(new KeyboardButton(langs[i]));
                keyboardRows.add(keyboardRow);
            }
        }
        KeyboardRow key = new KeyboardRow();
        key.add(new KeyboardButton(Constants.BACK));
        keyboardRows.add(key);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
    }
    public void getResult(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton(Constants.ENGLISH));
        keyboardRow.add( new KeyboardButton(Constants.RUSSIAN));
        keyboardRow.add(new KeyboardButton(Constants.TURKISH));
        keyboardRows.add(keyboardRow);
        KeyboardRow key = new KeyboardRow();
        key.add(new KeyboardButton(Constants.BACK));
        keyboardRows.add(key);
        replyKeyboardMarkup.setKeyboard(keyboardRows);



    }

   



}
