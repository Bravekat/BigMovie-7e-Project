package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInsert {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private Statement statement;

    public  void insert(){
        Connection connection = databaseConnection.dbConnection();

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sqlRating = "LOAD DATA LOCAL INFILE 'src/csv-files/Ratings.csv' into table Ratings FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' ";
        String sqlMovie = "LOAD DATA LOCAL INFILE 'src/csv-files/Movies.csv' into table Movies FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' ";
        String sqlGenres = "LOAD DATA LOCAL INFILE 'src/csv-files/Genres.csv' into table Genres FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' ";
        String sqlActresses = "LOAD DATA LOCAL INFILE 'src/csv-files/Actresses.csv' into table Actresses FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' ";
        String sqlActors = "LOAD DATA LOCAL INFILE 'src/csv-files/Actors.csv' into table Actors FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' ";
        String sqlRunningTimes = "LOAD DATA LOCAL INFILE 'src/csv-files/RunningTimes.csv' into table RunningTime FIELDS TERMINATED BY '|' LINES TERMINATED BY '\n' ";

        String occasionRating = "SELECT count(*) AS result from ratings";
        String occasionMovie = "SELECT count(*) AS result from Movies";
        String occasionGenres = "SELECT count(*) AS result from Genres";
        String occasionActresses = "SELECT count(*) AS result from Actresses";
        String occasionActors = "SELECT count(*) AS result from Actors";
        String occasionRunningTimes = "SELECT count(*) AS result from RunningTime";

        try {
            ResultSet resultSet = statement.executeQuery(occasionRating);
            resultSet.next();
            int resultRating = resultSet.getInt(1);
            resultSet = statement.executeQuery(occasionMovie);
            resultSet.next();
            int resultMovie = resultSet.getInt(1);
            resultSet = statement.executeQuery(occasionGenres);
            resultSet.next();
            int resultGenres = resultSet.getInt(1);
            resultSet = statement.executeQuery(occasionActors);
            resultSet.next();
            int resultActors = resultSet.getInt(1);
            resultSet = statement.executeQuery(occasionActresses);
            resultSet.next();
            int resultActresses = resultSet.getInt(1);
            resultSet = statement.executeQuery(occasionRunningTimes);
            resultSet.next();
            int resultRunningTimes= resultSet.getInt(1);

            resultSet.close();

            if (resultRating <= 0) {
                System.out.println("Hmm.. The table 'Ratings' is currently empty");
                System.out.println("Adding data...");
                statement.execute(sqlRating);
                System.out.println("Done!");
            }
            else{
                System.out.println("All data from 'Ratings' has already been uploaded to the database!");
            }
            if (resultMovie <= 0){
                System.out.println("Hmm.. The table 'Movies' is currently empty");
                System.out.println("Adding data...");
                statement.execute(sqlMovie);
                System.out.println("Done!");
            }
            else{
                System.out.println("All data from 'Movies' has already been uploaded to the database!");
            }
            if (resultGenres <= 0){
                System.out.println("Hmm.. The table 'Genres' is currently empty");
                System.out.println("Adding data...");
                statement.execute(sqlGenres);
                System.out.println("Done!");
            }
            else{
                System.out.println("All data from 'Genres' has already been uploaded to the database!");
            }
            if (resultActresses <= 0){
                System.out.println("Hmm.. The table 'Actresses' is currently empty");
                System.out.println("Adding data...");
                statement.execute(sqlActresses);
                System.out.println("Done!");
            }
            else{
                System.out.println("All data from 'Actresses' has already been uploaded to the database!");
            }
            if (resultActors <= 0){
                System.out.println("Hmm.. The table 'Actors' is currently empty");
                System.out.println("Adding data...");
                statement.execute(sqlActors);
                System.out.println("Done!");
            }
            else{
                System.out.println("All data from 'Actors' has already been uploaded to the database!");
            }
            if (resultRunningTimes <= 0){
                System.out.println("Hmm.. The table 'RunningTimes' is currently empty");
                System.out.println("Adding data...");
                statement.execute(sqlRunningTimes);
                System.out.println("Done!");
            }
            else{
                System.out.println("All data from 'RunningTimes' has already been uploaded to the database!");
            }
            statement.close();
            connection.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}























//  String Bulk =  " BULK INSERT SchoolsTemp
//    FROM 'C:\CSVData\Schools.csv'
//    WITH
//            (
//                    FIRSTROW = 2,
//                    FIELDTERMINATOR = ',',  --CSV field delimiter
//                            ROWTERMINATOR = '\n',   --Use to shift the control to next row
//                            ERRORFILE = 'C:\CSVDATA\SchoolsErrorRows.csv',
//                    TABLOCK
//                    )

