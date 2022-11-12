import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
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
        Calendar date = new GregorianCalendar();
        date.set(2022, Calendar.MARCH, 20);

        Location location = new Location(GlobalVals.durees.DUREE_1, date, 10, 10 );
        Facturation facturation = new Facturation(GlobalVals.typePaiement.CB, location, film);

        agence.clientEntreDansAgence(client, true);

        // Scénario 1 : Le client arrive dans l'agence et demande plusieurs films et leurs durées
        System.out.println("Scenario 1 \n");
        // Méthode envoyer une list de film a Agence

        // Agence va utiliser des méthodes pour vérifier si les films en question existe et répond en conséquences
        System.out.println("Il y a " + agence.getListFilm().size() + " film dans notre agence");
        System.out.println("Liste des films avec prix :");
        for (Film film : agence.getListFilm()) {
            System.out.println(film.getTitre() + " -> " + film.getPrix() + " €");
        }

        System.out.println("\nLe client choisi " + film.getTitre()+"\n");


        int dureeChoisi = GlobalVals.DUREE_1;

        location.calculerPenalite(2);
        facturation.calculerPrixFinal();

        System.out.println("Le client a choisi ce film pour une durée de : " + dureeChoisi + " h");
        System.out.println("Prix Total : " + facturation.getPrixFinal() + "?");
    }

}
