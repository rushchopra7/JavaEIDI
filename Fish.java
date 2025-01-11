package pgdp.expedition;

public class Fish {
    private String type;
    private String preparation;
    private int amount;

    public String getType() {
        return type;
    }

    public String getPreparation() {
        return preparation;
    }

    public int getAmount() {
        return amount;
    }

    public Fish(String type) {
        this.type = type;
        preparation = "fresh";
        amount = 1;
    }

    public Fish(String type, String preparation) {
        this.type = type;
        this.preparation = preparation;
        amount = 1;
    }
    @Override
    public String toString(){
        return preparation + " " + type;
    }

    public void prepare(String preparation){
        setPreparation(preparation);
    }
    public int add(Fish fish){
       return this.amount += fish.amount;
    }
    public int eat(){
        amount = amount - 1;
        return amount ;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }
}
