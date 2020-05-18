package Models;

import Parsers.*;

import java.io.IOException;
import java.util.Observable;

public class ParserModel extends Observable{
    private ActorParser actorParser = new ActorParser();
    private ActressesParser actressesParser = new ActressesParser();
    private MoviesParser moviesParser = new MoviesParser();
    private RatingsParser ratingsParser = new RatingsParser();
    private GenresParser genresParser = new GenresParser();
    private RunningTimeParser runningTimeParser = new RunningTimeParser();

    //__________PARSES LIST FILES TO CSV WITH NEEDED INFORMATION__________//
    public void parseFiles() throws IOException {
        actorParser.parse();
        actressesParser.parse();
        moviesParser.parse();
        ratingsParser.parse();
        genresParser.parse();
        runningTimeParser.parse();
    }
}
