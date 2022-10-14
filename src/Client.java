import java.util.ArrayList;
import java.util.List;

public class Client {



    private String nom;
    private int age;

    private Agence agence;
    private List<String> Films = new ArrayList<>();
    private List<String> Support = new ArrayList<>();
    private List<Integer> DuréeLocation = new ArrayList<>();



    public Client(String nom,int age){
        this.nom = nom;
        this.age = age;
    }

    public void loue(String filmDemandé, String supportDemandé, int duréeDemandé){
        this.Films.add(filmDemandé);
        this.Support.add(supportDemandé);
        this.DuréeLocation.add(duréeDemandé);
    }
}
