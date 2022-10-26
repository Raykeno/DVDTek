import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Agence {

    private Film[] Film_connu = {
            new Film(15,"Harry Potter 7", GlobalVals.categories.Ancien, GlobalVals.genres.ScienceFiction),
            new Film(20,"Plancha", GlobalVals.categories.Recent, GlobalVals.genres.Comedie),
            new Film(2,"Transformers 1", GlobalVals.categories.Ancien, GlobalVals.genres.ScienceFiction),
            new Film(5,"Transporteur 3", GlobalVals.categories.Ancien, GlobalVals.genres.Action)
    };


    private Client[] Client_connu = {
            new Client("Clement", 20),
            new Client("Keke", 20),
            new Client("Paul", 14),
            new Client("Arthur", 12)
    };


    public Film[] getFilm_connu() {
        return Film_connu;
    }

    public List<Client> getListClient() {
        return ListClient;
    }



    private List<Film> ListFilm = new ArrayList<>(Arrays.asList(Film_connu));
    private List<Client> ListClient = new ArrayList<>(Arrays.asList(Client_connu));


    private boolean clientIsKnown(Client client) {
        for (int i = 0; i < this.ListClient.size(); i++) {
            if (this.ListClient.get(i).getNom() == client.getNom()) {
                System.out.println("Client connu");
                return true;
            }
        }
        System.out.println("Nouveau client ajouté a la bdd client");
        this.ListClient.add(client);
        return false;
    }
//
    private boolean filmIsKnown(Film film) {
        for (int i = 0; i < this.ListFilm.size(); i++) {
            if (this.ListClient.get(i).getNom() == film.getTitre()) {
                System.out.println("Film connu");
                return true;
            }
        }
        System.out.println("Film inconnu dans notre agence");
        return false;
    }
}
