import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Agence {

    //Agence Belfort
    private String[] Film_existant = {
            "Star wars",
            "Retour vers le futur",
            "Retour vers le futur 2",
            "Retour vers le futur",
            "Harry Potter"
    };
    private String[] Support_Dispo = {
            "DVD",
            "Blue-Ray",
            "K7"
    };

    private String[] Client_existant = {
            "Clément",
            "Kiwi",
            "Cailloux",
            "Caramel"
    };

    private List<String> Support = new ArrayList<>(Arrays.asList(Support_Dispo));
    private List<String> Film = new ArrayList<>(Arrays.asList(Film_existant));
    private List<String> Client = new ArrayList<>(Arrays.asList(Client_existant));

}
