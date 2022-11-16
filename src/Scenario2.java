import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Scenario2 {
    public Agence agence;

    public void init() throws IOException, ParseException {

        agence = new Agence();

        agence.printLocalSupportList();
        System.out.println("");
        agence.printLocalFilmList();
        System.out.println("");
        agence.printLocalClientList();
        System.out.println("");
        agence.getFilmListFromGenrePrintRandom();
        System.out.println("");
        agence.getFilmListFromSupportPrintRandom();
        System.out.println("");
        agence.denombrerToutGenre();
        System.out.println();
        agence.denombrerToutSupport();

        System.out.println("\n-----------BDD test----------");
        BddAgence bddAgence = new BddAgence();

        System.out.println("Liste des clients enregistré dans la bdd : " + bddAgence.read_data_basic("nom"));

        bddAgence.Read_FilmsDejaEmprunter(1);
        bddAgence.WriteNewMovieClient(1, "Avengers", "sf");

    }
}
