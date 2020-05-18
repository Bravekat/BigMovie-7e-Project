package com.company;

import Controllers.MainController;
import Models.ChatBotModel;
import Models.DataBaseModel;
import Models.ParserModel;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //__________Controllers__________//
        new MainController(new ParserModel(), new ChatBotModel(), new DataBaseModel()); //COMMENT SUGGESTED AT PARSEMODEL!! if you don't have any csv files yet. may take a while :)
   }
}
