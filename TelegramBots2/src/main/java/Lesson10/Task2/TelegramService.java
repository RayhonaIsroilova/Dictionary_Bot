package Lesson10.Task2;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramService {
    SendMessage firstMenu (Update update);
    SendMessage englishDictionary(Update update);
    SendMessage russianDictionary(Update update);
    SendMessage turkishDictionary(Update update);

}
