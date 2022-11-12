import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Scenario {

    public Agence agence;
    public Client client;
    public Film film;
    public Support support;

    public void init(){

        Random random = new Random();

        agence = new Agence();
        client = agence.getListClient().get(random.nextInt(agence.getListClient().size()));
        support = agence.getListSupport().get(random.nextInt(agence.getListSupport().size()));
        film = support.getFilm();

        GlobalVals.durees dureeRandom = randomDuree(random);
        int dureeInt = getDuree(dureeRandom);
        String dureeStr = Integer.toString(dureeInt);

        int[] dateEnTab = calculDate(dureeStr);

        Calendar cDate = new GregorianCalendar();
        // Calendar.DATE+getDuree(dureeRandom)
        cDate.set(dateEnTab[0], dateEnTab[1], dateEnTab[2]);

        // On rajoute la location dans notre liste actuel de duration
        Location location = new Location(GlobalVals.durees.DUREE_1, cDate, 0, 0);
        agence.addLocationToList(location);
        Facturation facturation = new Facturation(GlobalVals.typePaiement.CB, location, support);

        location.setDuree(dureeRandom);
        int dureeChoisi = location.getDuree();


        agence.clientEntreDansAgence(client, true);

        // Scénario 1 : Le client arrive dans l'agence et demande plusieurs films et leurs durées
        System.out.println("\nScenario 1 \n");
        // Méthode envoyer une list de film a Agence

        // Agence va utiliser des méthodes pour vérifier si les films en question existe et répond en conséquences
        agence.printLocalFilmList();

        System.out.println("\nLe client choisi " + film.getTitre()+"\n");

        location.calculerPenalite(0);
        facturation.calculerPrixFinal();

        System.out.println("Le client a choisi ce film pour une durée de : " + dureeChoisi + " h");
        System.out.println("Prix Total : " + facturation.getPrixFinal() + " euros");

        // Print pour vérifier le calcul
        System.out.println(
                "(" + support.getPrixTypeSupport() + " eur support, " + film.getPrix() + " eur film, " + location.getPrixDuree()
                + " eur duree, " + film.getPrixCategorie() + " eur categorie)");

        System.out.println("le client devra revenir le " + location.getDateRetourToString() + " , pour ne pas avoir de penalité");
    }

    public static GlobalVals.durees randomDuree(Random random)  {
        GlobalVals.durees[] durees = GlobalVals.durees.values();
        return durees[random.nextInt(durees.length)];
    }

    public static int getDuree(GlobalVals.durees duree){
        return switch (duree) {
            case DUREE_1 -> GlobalVals.TEMPS_DUREE_1;
            case DUREE_2 -> GlobalVals.TEMPS_DUREE_2;
            case DUREE_3 -> GlobalVals.TEMPS_DUREE_3;
        };
    }

    // -1 dans le mois parce qu'on compte depuis 0 les mois, ex : Janvier -> 0, Février -> 1
    public static int[] calculDate(String duree){

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime retour = now.plusHours(Long.parseLong((duree)));

        int retourYear = Integer.parseInt(DateTimeFormatter.ofPattern("yyyy").format(retour));
        int retourMonth = Integer.parseInt(DateTimeFormatter.ofPattern("MM").format(retour));
        int retourDay = Integer.parseInt(DateTimeFormatter.ofPattern("dd").format(retour));

        int[] dateTabReturn = {retourYear, retourMonth-1, retourDay};
        return dateTabReturn;
    }
}
