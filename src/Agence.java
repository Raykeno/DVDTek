import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// verbose cela veut dire que la fonction fait des prints pour indiquer certains états
// Sa ce peut que je mette ce boolean pour certaines fonctions, il faut juste mettre false si on ne veut pas de prints

public class Agence {

    private Client clientActuel;
    private List<Location> ListLocation = new ArrayList<>();

    // MockData pour tester
    private final Film[] Film_connu = {
            new Film(15,"Harry Potter 7", GlobalVals.categories.Ancien, GlobalVals.genres.ScienceFiction),
            new Film(20,"Plancha", GlobalVals.categories.Recent, GlobalVals.genres.Comedie),
            new Film(2,"Transformers 1", GlobalVals.categories.Ancien, GlobalVals.genres.ScienceFiction),
            new Film(5,"Transporteur 3", GlobalVals.categories.Ancien, GlobalVals.genres.Action)
    };

    private final Support[] Support_connu = {
            new Support(true, Film_connu[0], GlobalVals.typeSupport.DVD),
            new Support(true, Film_connu[1], GlobalVals.typeSupport.BluRay),
            new Support(true, Film_connu[2], GlobalVals.typeSupport.DVD),
            new Support(true, Film_connu[3], GlobalVals.typeSupport.BluRay)
    };

    private final Client[] Client_connu = {
            new Client("Clement", 20, 10f),
            new Client("Keke", 20, 78f),
            new Client("Paul", 14, 72.5f),
            new Client("Arthur", 12, 8.9f)
    };

    private List<Film> ListFilm = new ArrayList<>(Arrays.asList(Film_connu));
    private List<Client> ListClient = new ArrayList<>(Arrays.asList(Client_connu));

    private List<Support> ListSupport = new ArrayList<>(Arrays.asList(Support_connu));

    public List<Client> getListClient() {
        return ListClient;
    }

    public List<Film> getListFilm() {
        return ListFilm;
    }

    public List<Support> getListSupport() {
        return ListSupport;
    }

    // ------------- Fonction de base pour rajouter des elements dans chacune des listes ----------------

    public void addFilmToList(Film film){
        this.ListFilm.add(film);
    }

    public void addClientToList(Client client){
        this.ListClient.add(client);
    }

    public void addLocationToList(Location location){
        this.ListLocation.add(location);
    }

    // ------------------------- getters spécifiques ---------------------------------------------

    public List<Film> getFilmListFromGenre(GlobalVals.genres genre, boolean verbose){
        List<Film> returnFilmList = new ArrayList<>();
        for (Film film: this.ListFilm) {
            if (film.getGenre() == genre){
                returnFilmList.add(film);
            }
        }
        if (returnFilmList.size() == 0){
            if (verbose) {
                System.out.println("Il n'y a pas de film de " +genre+ " dans notre agence");
            }
        }
        return returnFilmList;
    }

    public void getFilmListFromGenrePrint(GlobalVals.genres genre){
        List<Film> genreListFilm = getFilmListFromGenre(genre, false);
        if (genreListFilm.size() == 0) {
            System.out.println("Il n'y a pas de film de " +genre+ " dans notre agence");
        }
        printFilmList(genreListFilm);
    }

    // -------------------------- Fonctions pour print les listes -------------------------------------

    public void printFilmList(@NotNull List<Film> filmList){
        for (Film film: filmList) {
            System.out.println(film.getTitre() + " -> " + film.getPrix() + " €");
        }
    }

    public void printLocalFilmList(){
        System.out.println("Voici une liste de tout nos film avec leurs prix");
        printFilmList(this.ListFilm);
    }

    public void printClientList(@NotNull List<Client> clientList){
        for (Client client: clientList) {
            System.out.println(client.getNom() + " , " + client.getAge() + " ans");
        }
    }

    public void printLocationList(@NotNull List<Location> locationList){
        for (Location location: locationList) {
            System.out.println(location.getDuree() + ", " + location.getDateRetourToString());
        }
    }

    // ---------------------------------- Fonctions de Test si connu -----------------------------------

    // Il faudrait tester avec un système d'ID plutot
    private boolean clientIsKnown(Client client) {
        for (Client cli : this.ListClient) {
            if (Objects.equals(cli.getNom(), client.getNom())) {
                return true;
            }
        }
        System.out.println("Nouveau client ajouté a la bdd client");
        this.ListClient.add(client);
        return false;
    }

    // Pas vraiment besoin d'ID par là
    private boolean filmIsKnown(String film) {
        for (Film fi : this.ListFilm) {
            if (Objects.equals(fi.getTitre(), film)) {
                return true;
            }
        }
        System.out.println("Film inconnu dans notre agence");
        return false;
    }

    // --------------------------- Fonctions pour scénario --------------------------------------

    public void clientEntreDansAgence(Client client, boolean verbose){
        this.clientActuel = client;
        if (verbose) {
            System.out.println("Le client " + client.getNom() + " entre dans le magasin, il a " + client.getArgent() + " €");
        }
        if (clientIsKnown(client)){
            if (verbose) {
                System.out.println("Le client n'est pas connu dans notre agence, on l'ajoute à notre liste de client connu");
            }
            addClientToList(client);
        }
    }
}
