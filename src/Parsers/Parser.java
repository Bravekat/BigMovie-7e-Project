package Parsers;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser {//used for all the parsers
    public abstract void parse() throws IOException; //parses the .csv to get the specific groups needed for the chatbot
}