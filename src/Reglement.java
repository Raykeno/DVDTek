public class Reglement {

    private Client client;
    private Facturation facturation;

    public Reglement( Client client, Facturation facturation) {
        this.client = client;
        this.facturation = facturation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facturation getFacturation() {
        return facturation;
    }

    public void setFacturation(Facturation facturation) {
        this.facturation = facturation;
    }
}
