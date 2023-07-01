package uz.nazarovctrl.controller;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;
import uz.nazarovctrl.config.MyTelegramBot;

public class UpdateController {
    private final MessageController messageController;

    private final CallBackController callBackController;

    public UpdateController(MyTelegramBot myTelegramBot) {
        this.messageController = new MessageController(myTelegramBot);
        callBackController = new CallBackController(myTelegramBot);
    }

    public void handle(Update update) {
        if (update.hasMessage()) {
            messageController.handle(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            callBackController.handle(update.getCallbackQuery());
        } else if (update.hasPreCheckoutQuery()) {
            PreCheckoutQuery preCheckoutQuery = update.getPreCheckoutQuery();
        }
    }
}
