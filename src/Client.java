import java.util.ArrayList;
import java.util.List;

public class Client {

    private String nom;

    private int age;

    private float argent;

    public float getArgent() {
        return argent;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public Client(String nom, int age, float argent) {
        this.nom = nom;
        this.age = age;
        this.argent = argent;
    }

    public Client() {
        this("Ewan", 20, 24.6f);
    }
}