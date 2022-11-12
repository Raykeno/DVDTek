import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Scenario2 {


    public Agence agence;
    public Client client;
    public Film film;
    public Support support;

    public void init(){

        Random random = new Random();

        agence = new Agence();

        agence.printLocalSupportList();
        System.out.println("");
        agence.printLocalFilmList();
        System.out.println("");
        agence.printLocalClientList();


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
