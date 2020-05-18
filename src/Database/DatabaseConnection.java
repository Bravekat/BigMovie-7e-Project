package Database;

import com.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection connection = ConnectionConfiguration.getConnection();
    public void getConnection(){

        try{
            if (connection != null){
                System.out.println("Database has been launched!");
            }

        }catch(Exception se){
            //Handle errors for JDBC
            se.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

 public Connection dbConnection() {
        return connection;
 }
}
