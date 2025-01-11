package pgdp.expedition;


public class Backpack {
    private final String fishPreparation;
    private String fishType;
    //private String pickaxe;
    //private String fishingRod;
    private Tool fishingRod;
    private Tool pickaxe;
    private Fish provisions;


    public Tool getFishingRod() {
        return fishingRod;
    }



    public Tool getPickaxe() {
        return pickaxe;
    }

    public String getFishPreparation() {
        return fishPreparation;
    }

    public String getFishType() {
        return fishType;
    }





    public Scepter getScepter() {
        return scepter;
    }

    public Backpack(String fishType, String fishPreparation){
        this.fishType = fishType;
        this.fishPreparation = fishPreparation;
        this.provisions = new Fish(fishType,fishPreparation);
        this.pickaxe = new Tool("pickaxe");
        this.fishingRod = new Tool("fishingRod");
        //this.provisions = fishType + fishPreparation;
        this.scepter = null;

    }




    public Fish getProvisions() {
        return provisions;
    }



    private Scepter scepter;



    public void putScepterIntoBackpack(Scepter scepter){
        this.scepter = scepter;
    }
    public Scepter steal(Entdeckuin stealer){
        Scepter sc = this.scepter;
        sc.steal(stealer);
        this.scepter = null;
        return sc;
    }





}
