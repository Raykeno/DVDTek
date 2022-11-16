import MoyenDePaiement.CarteBancaire;

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

    public void init() {

        Random random = new Random();

        agence = new Agence();
        client = agence.randomClientFromList();
        support = agence.clientChooseRandomSupport();
        film = support.getFilm();

        GlobalVals.durees dureeRandom = randomDuree(random);
        int dureeInt = getDuree(dureeRandom);
        String dureeStr = Integer.toString(dureeInt);

        int[] dateEnTab = calculDate(dureeStr);

        Calendar cDate = new GregorianCalendar();
        // Calendar.DATE+getDuree(dureeRandom)
        cDate.set(dateEnTab[0], dateEnTab[1], dateEnTab[2]);

        // On rajoute la location dans notre liste actuel de duration


        agence.clientEntreDansAgence(client, true);

        // Scénario 1 : Le client arrive dans l'agence et demande plusieurs films et leurs durées
        System.out.println("\nScenario 1");
        // Méthode envoyer une list de film a Agence

        agence.isAnyMovieAvailablePrint();
        if (!agence.isAnyMovieAvailable()) {
            return;
        }

        agence.printLocalFilmList();

        // Si le client prend un film indisponible, il prend un autre film
        System.out.println("");

        while (agence.isFilmAvailableToBePicked(film)) {
            agence.isFilmAvailablePrint(film);
            film = agence.clientChooseRandomFilm();
        }

        agence.isFilmAvailablePrint(film);

        System.out.println("\nLe client choisi " + film.getTitre() + "\n");

        Location location = new Location(GlobalVals.durees.DUREE_1, cDate, 0, 0);

        location.setDuree(dureeRandom);
        int dureeChoisi = location.getDuree();



        /*
        if (!support.estDisponible()) {
            System.out.println("Le client a choisi un film avec un support qui n'est pas disponible");
            System.out.println("Le client quitte le magasin...");
            return;
        }

         */

        Facturation facturation = new Facturation(GlobalVals.typePaiement.CB, location, support);

        location.calculerPenalite(0);
        facturation.calculerPrixFinal();

        System.out.println("Le client a choisi ce film pour une durée de : " + dureeChoisi + " h");
        System.out.println("Prix Total : " + facturation.getPrixFinal() + " euros");

        // Print pour vérifier le calcul
        System.out.println(
                "(" + support.getPrixTypeSupport() + " eur support, " + film.getPrix() + " eur film, " + location.getPrixDuree()
                        + " eur duree, " + film.getPrixCategorie() + "eur categorie)\n");

        boolean didTheyPay = agence.payerLaFacture(client, facturation, new CarteBancaire(), support, location);

        if (didTheyPay) {
            System.out.println("\nle client devra revenir le " + location.getDateRetourToString() + " , pour ne pas avoir de penalité");

            if (random.nextBoolean()) {
                System.out.println("\nle client dispose d'un compte prépayé.");
                if (random.nextBoolean()) {
                    System.out.println("\nLe client rend le film en avance.");
                    int avance = new Random().ints(1, 1, 60).findFirst().getAsInt();
                    System.out.println(avance + "h d'avance !");
                    float remboursement = (facturation.getPrixFinal() / 12) * avance / 24; // avance en j
                    System.out.println("Remboursement : " + remboursement + "euros.");
                } else {
                    System.out.println("\nLe client rend le film en retard.");
                    int retard = new Random().ints(1, 1, 5).findFirst().getAsInt();
                    System.out.println(retard + "jour(s) de retard...");
                    System.out.println("Pénalité : " + location.getPenalite() + "euros.");
                }
            } else {
                System.out.println("\nLe client ne dispose pas d'un compte prépayé.");
                if (random.nextBoolean()) {
                    System.out.println("\nLe client rend le film à l'heure.");
                } else {
                    int retard = new Random().ints(1, 1, 5).findFirst().getAsInt();
                    System.out.println(retard + "jour(s) de retard...");
                    System.out.println("Pénalité : " + location.getPenalite() + "euros.");
                }
            }
        }
    }

    public static GlobalVals.durees randomDuree(Random random) {
        GlobalVals.durees[] durees = GlobalVals.durees.values();
        return durees[random.nextInt(durees.length)];
    }

    public static int getDuree(GlobalVals.durees duree) {
        return switch (duree) {
            case DUREE_1 -> GlobalVals.TEMPS_DUREE_1;
            case DUREE_2 -> GlobalVals.TEMPS_DUREE_2;
            case DUREE_3 -> GlobalVals.TEMPS_DUREE_3;
        };
    }

    // -1 dans le mois parce qu'on compte depuis 0 les mois, ex : Janvier -> 0, Février -> 1
    public static int[] calculDate(String duree) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime retour = now.plusHours(Long.parseLong((duree)));

        int retourYear = Integer.parseInt(DateTimeFormatter.ofPattern("yyyy").format(retour));
        int retourMonth = Integer.parseInt(DateTimeFormatter.ofPattern("MM").format(retour));
        int retourDay = Integer.parseInt(DateTimeFormatter.ofPattern("dd").format(retour));

        int[] dateTabReturn = {retourYear, retourMonth - 1, retourDay};
        return dateTabReturn;
    }
}
