package Controllers;

import Models.ChatBotModel;
import Models.DataBaseModel;
import Models.ParserModel;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class MainController implements Observer {
    private ParserModel parserModel;
    private ChatBotModel chatBotModel;
    private DataBaseModel dataBaseModel;

    public MainController(ParserModel parserModel, ChatBotModel chatBotModel, DataBaseModel dataBaseModel) throws IOException {
        this.parserModel = parserModel;
        this.chatBotModel = chatBotModel;
        this.dataBaseModel = dataBaseModel;

        parserModel.parseFiles();
        chatBotModel.createBot();
        dataBaseModel.connect();
        dataBaseModel.insert();

        this.dataBaseModel.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
