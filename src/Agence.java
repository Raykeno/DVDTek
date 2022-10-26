import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Agence {

    private Film[] Film_connu = {
            new Film(15,"Harry Potter 7", "Ancien","SF"),
            new Film(20,"Plancha", "Récent","Comedie"),
            new Film(2,"Transformers 1", "Ancien","SF"),
            new Film(5,"Transporteur 3", "Ancien","Action")
    };


    private Client[] Client_connu = {
            new Client("Clement", 20),
            new Client("Keke", 20),
            new Client("Paul", 14),
            new Client("Arthur", 12)
    };


    public List<Film> getFilm() {
        return Film;
    }

    public List<Client> getListClient() {
        return ListClient;
    }



    private List<Film> Film = new ArrayList<>(Arrays.asList(Film_connu));
    private List<Client> ListClient = new ArrayList<>(Arrays.asList(Client_connu));
//tes

    private boolean isknow(Client client) {
        for (int i = 0; i < this.ListClient.size(); i++) {
            if (this.ListClient.get(i).getNom() == client.getNom()) {
                return true;
            }
        }
        return false;
    }


}
