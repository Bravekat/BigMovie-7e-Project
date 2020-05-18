package Parsers;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoviesParser extends Parser {
    private String regex = "\\\"(.+?)\\\"\\s\\(([0-9\\?]{4})";
    private Matcher matcher;
    private Pattern pattern;
    private FileWriter writer;

        @Override
        public void parse() throws IOException {
            File file = new File("src/csv-files/Movies.csv");

            if (!file.isFile()) {
                writer = new FileWriter(file, false);
                System.out.println("The csv 'Movies.csv' has not been parsed yet!");
                System.out.println("Parsing...");
                BufferedReader br = new BufferedReader(
                                            new InputStreamReader(
                                                new FileInputStream("src/ListFiles/movies.list")));
                br.lines().forEach(s -> {
                    pattern = Pattern.compile(regex);
                    matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        try {
                            writer.append(matcher.group(1) + "|" + matcher.group(2) + "\n");

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                });
                writer.close();
                System.out.println("Done!");
            }
            else {
                System.out.println("Lucky! The file 'Movies.csv' has already been parsed!");
            }
        }
}
