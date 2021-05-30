package Lesson10.Task2;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class TelegramBotImpl implements TelegramService{

    @Override
    public SendMessage firstMenu(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long chatId = update.getMessage().getChatId();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add(new KeyboardButton(Constants.ENGLISH));
        row2.add(new KeyboardButton(Constants.RUSSIAN));
        row3.add(new KeyboardButton(Constants.TURKISH));
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setText(Constants.MENU);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public SendMessage englishDictionary(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long chatId = update.getMessage().getChatId();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add(new KeyboardButton(Constants.ENGLISH_TO_TURKISH));
        row2.add(new KeyboardButton(Constants.ENGLISH_TO_RUSSIAN));
        row3.add(new KeyboardButton(Constants.BACK));
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setText(Constants.MENU_FOR_CHOOSING);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public SendMessage russianDictionary(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long chatId = update.getMessage().getChatId();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add(new KeyboardButton(Constants.RUSSIAN_TO_ENGLISH));
        row2.add(new KeyboardButton(Constants.RUSSIAN_TO_TURKISH));
        row3.add(new KeyboardButton(Constants.BACK));
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setText(Constants.MENU_FOR_CHOOSING);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public SendMessage turkishDictionary(Update update) {
        SendMessage sendMessage = new SendMessage();
        Long chatId = update.getMessage().getChatId();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        row1.add(new KeyboardButton(Constants.TURKISH_TO_ENGLISH));
        row2.add(new KeyboardButton(Constants.TURKISH_TO_RUSSIAN));
        row3.add(new KeyboardButton(Constants.BACK));
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setText(Constants.MENU_FOR_CHOOSING);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

}
