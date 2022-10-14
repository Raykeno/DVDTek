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


    private Client[] Client_existant = {
            new Client("Clement",20),
            new Client("Keke",20),
            new Client("Paul",14),
            new Client("Arthur",12)
    };

    private List<String> Support = new ArrayList<>(Arrays.asList(Support_Dispo));
    private List<String> Film = new ArrayList<>(Arrays.asList(Film_existant));
    private List<Client> ListClient = new ArrayList<>(Arrays.asList(Client_existant));


    private boolean isknow(Client client){
        for (int i = 0; i < this.ListClient.size(); i++) {
            if (this.ListClient.get(i).getNom() == client.getNom()) {
                return true;
            }
        }
        return false;
    }














}
