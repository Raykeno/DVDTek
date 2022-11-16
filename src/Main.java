import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        new Scenario().init();
        System.out.println("\n\n |--------- Scenario 2 ---------| \n\n");
        new Scenario2().init();
        System.out.println("\n-----------clement test----------");
        BddAgence bddAgence = new BddAgence();
        //System.out.println(bddAgence.read_data_basic("id"));
        //bddAgence.Read_FilmsDejaEmprunter(0);
        bddAgence.NewRead();
        bddAgence.WriteNewClient(new Client("Pauline",12, 0.0f));

    }

}
