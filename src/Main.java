import java.util.Random;
import java.util.random.*;
public class Main {

    public Agence agence;
    public Client client;
    public Film film;


    public static void main(String[] args) {
        new Main().init();
    }

    public void init(){

        Random random = new Random();
        agence = new Agence();
        client = agence.getListClient().get(0);
        film = agence.getListFilm().get(0);

        Location location = new Location(GlobalVals.durees.DUREE_1,"03/10/2022", 10, 10 );
        Facturation facturation = new Facturation(GlobalVals.typePaiement.CB, location, film);

        System.out.println("Le client " + client.getNom() + " entre dans le magasin, il a " + client.getArgent() + " €");
        // Scénario 1 : Le client arrive dans l'agence et demande plusieurs films et leurs durées
        System.out.println("Scenario 1 \n");
        // Méthode envoyer une list de film a Agence

        // Agence va utiliser des méthodes pour vérifier si les films en question existe et répond en conséquences
        System.out.println("Il y a " + agence.getListFilm().size() + " film dans notre agence");
        System.out.println("Liste des films avec prix :");
        for (Film film : agence.getListFilm()) {
            System.out.println(film.getTitre() + " -> " + film.getPrix() + " €");
        }

        System.out.println("");

        System.out.println("Le client choisi " + agence.getListFilm().get(random.nextInt(0, agence.getListFilm().size())).getTitre());

        System.out.println("");

        int dureeChoisi = GlobalVals.DUREE_1;

        System.out.println("Choisi la  Durée : " + dureeChoisi + " h");
        System.out.println("Prix Total : [ToutLesPrixFinalFilms]?");
    }

}
