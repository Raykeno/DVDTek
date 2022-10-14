import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Agence {
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
    private List<String> ListClient = new ArrayList<>(Arrays.asList(Client_existant));


    private boolean isknow(Client client){
        for (int i = 0; i < this.ListClient.size(); i++) {
            if (this.ListClient.get(i) == client.getNom()) {
                return true;
            }
        }
        return false;
    }














}
