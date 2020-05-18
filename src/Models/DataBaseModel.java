package Models;

import Database.DatabaseConnection;
import Database.DatabaseInsert;

import java.io.IOException;
import java.util.Observable;

public class DataBaseModel extends Observable {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private DatabaseInsert databaseInsert = new DatabaseInsert();

    //__________CONNECT TO DATABASE__________//
    public void connect(){
        databaseConnection.getConnection();
    }

    //__________INSERT CSV FILES INTO DATABASE__________//
    public void insert() throws IOException { databaseInsert.insert();
    }
    //__________INSERT QUESTION QUERIES INTO DATABASE __________//
    public void askQuestions(){
        setChanged();   //gives a signal to observer that statement has been executed
        notifyObservers(); //sends it over to the observer
    }
}
