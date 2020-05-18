package Models;

import Chatbot.JaraskusBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;

public class ChatBotModel { //what to do with the parsed code
  //  private File file = new File("src/Chatbot/Handsome.jpg");

    //__________CREATE BOT__________//
    public void createBot(){
        // Initialize Api Context
        ApiContextInitializer.init();
        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();
        //create new bot
        JaraskusBot jaraskusBot = new JaraskusBot();
        //set profile picture
        //SetChatPhoto chatPhoto = new SetChatPhoto(jaraskusBot.getBotToken(), file);
        // Register our bot
        try {
            botsApi.registerBot(jaraskusBot);
           //jaraskusBot.setChatPhoto(chatPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
