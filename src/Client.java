import java.util.ArrayList;
import java.util.List;

public class Client {



    private String nom;
    private int age;

    private Agence agence;
    private List<String> Films = new ArrayList<>();
    private List<String> Support = new ArrayList<>();
    private List<String> DuréeLocation = new ArrayList<>();



    public Client(String nom,int age){
        this.nom = nom;
        this.age = age;
    }

    public void loue(String filmDemander){
        this.Films.add(filmDemander);
    }
}
