package pgdp.expedition;

public class Scepter {
    private static Scepter instance ;
    private  Entdeckuin owner;
    private Scepter(){
        this.owner = null;
    }
    public static Scepter getInstance(){
        return instance;
    }
    public static Scepter findScepter(Entdeckuin newOwner){
        instance.setOwner(newOwner) ;
        System.out.println(instance.toString());
        return instance;
    }

    public static void setInstance(Scepter instance) {
        Scepter.instance = instance;
    }

    public Entdeckuin getOwner() {
        return owner;
    }

    public void setOwner(Entdeckuin owner) {
        this.owner = owner;
    }

    public Scepter steal(Entdeckuin newOwner){
        instance.setOwner(newOwner) ;
        System.out.println(instance.toString());
        return instance;
    }
    @Override
    public String toString(){
        return "The scepter of submission belongs to" + " " +  this.owner + " " + "now.";
    }


}
