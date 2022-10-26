import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Statistique {
    //Stat

    private String[] Support_Pref = {
            "DVD",
            "Blue-Ray",
            "K7"
    };

    private String[] Genres ={
            "Action",
            "Comédie",
            "Horreur",
            "Romance",
    };

    private String[] Categories ={
            "Récent",
            "Ancien",

    };

    private List<String> Support = new ArrayList<>(Arrays.asList(Support_Pref));
    private List<String> Genre = new ArrayList<>(Arrays.asList(Genres));
    private List<String> Categorie = new ArrayList<>(Arrays.asList(Categories));



}
