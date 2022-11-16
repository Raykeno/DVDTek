import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        new Scenario().init();
        System.out.println("\n\n |--------- Scenario 2 ---------| \n\n");
        new Scenario2().init();


    }

}
