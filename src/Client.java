import java.util.ArrayList;
import java.util.List;

public class Client {

    private String nom;
    private int age;

    private float argent;

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public Client(String nom, int age, float argent){
        this.nom = nom;
        this.age = age;
    }

    public Client(){
        this("John", 20, 10f);
    }

}


