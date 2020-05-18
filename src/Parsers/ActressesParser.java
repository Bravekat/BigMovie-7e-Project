package Parsers;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActressesParser extends Parser {
    private String regex = "(.+?), (.+?)\\t+(.+?) \\((.+?)\\).*|\\t+(.+?) \\((.+?)\\).*";
    private Matcher matcher;
    private Pattern pattern;
    private FileWriter writer;
    private String currentActorFrontName ;
    private String currentActorLastName;

    @Override
    public void parse() throws IOException {
        File file = new File("src/csv-files/Actresses.csv");

        if (!file.isFile()) {
            writer = new FileWriter(file, false);
            System.out.println("The csv 'Actresses.csv' has not been parsed yet!");
            System.out.println("Parsing...");
            BufferedReader br = new BufferedReader(
                                    new InputStreamReader(
                                        new FileInputStream("src/ListFiles/actresses.list")));
            br.lines().forEach(s -> {
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(s);

                if (matcher.find()) {
                    try {
                        if (matcher.group(1) != null) {
                            currentActorFrontName = matcher.group(2);
                            currentActorLastName = matcher.group(1);

                            writer.append(matcher.group(2) + "|" + matcher.group(1) + "|" + matcher.group(3) + "|" + matcher.group(4) + "F" +"\n");
                        }
                        if (matcher.group(5) != null) {
                            writer.append(currentActorFrontName + "|" + currentActorLastName + "|" + matcher.group(5) + "|" + matcher.group(6) + "F" +"\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            writer.close();
            System.out.println("Done!");
        }
        else {
            System.out.println("Super Lucky! The file 'Actresses.csv' has already been parsed");
        }
    }
}
