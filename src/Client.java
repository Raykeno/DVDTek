
public class Client {

    private String nom;

    private int age;

    private float argent;

    private GlobalVals.genres genrePreferee;

    public Client(String nom, int age, float argent) {
        this.nom = nom;
        this.age = age;
        this.argent = argent;
    }

    // Client de base pour une MockData
    public Client() {
        this("Ewan", 20, 24.6f);
    }

    public float getArgent() {
        return argent;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }
}