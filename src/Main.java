public class Main {

    public static void main(String[] args) {

        new Scenario().init();
        System.out.println("\n\n |--------- Scenario 2 ---------| \n\n");
        new Scenario2().init();
        System.out.println("\n-----------clement test----------");
        BddAgence bddAgence = new BddAgence();
    }

}
