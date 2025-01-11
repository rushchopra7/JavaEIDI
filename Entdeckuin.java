package pgdp.expedition;

import static pgdp.PinguLib.write;

public class Entdeckuin {
	private String name;
	private int age;
	private Backpack backpack;

	public Entdeckuin(String name, int age,String favoriteFishType, String favoritePreparation){
		this.name = name;
		this.age = age;
		this.backpack = new Backpack(favoriteFishType, favoritePreparation);
	}
	public void addProvisions(Fish fish){
		String preparation = this.backpack.getProvisions().getPreparation();
		fish.setPreparation(preparation);
		this.backpack.getProvisions().add(fish);
		System.out.println(this + " " + preparation + " some " + fish.getType() + " and added it to their provisions.");
	}


   int durability;

	public Backpack getBackpack() {
		return backpack;
	}
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Fish fish(String type){
		Tool fishingRod =  this.backpack.getFishingRod();

		System.out.println(this.toString() + " used the " + fishingRod.toString() + " to catch some " + type + ".");
		fishingRod.use();
		System.out.println("It has " + fishingRod.getDurability() + " durability left.");
		Fish fisch = new Fish(type);
		return fisch;
	}

	public void eat(){
		Fish fisch = this.backpack.getProvisions();
		backpack.getProvisions().eat();
		System.out.println(this.toString() + " ate some " + fisch.toString() + ". There is " +
				backpack.getProvisions().getAmount() + " " + backpack.getProvisions().toString() + " provisions left.");
	}
	public void usePickaxe(){
		Tool pickaxe = this.backpack.getPickaxe();
		double dur = pickaxe.getDurability();
		pickaxe.use();
		System.out.println(this.toString() + " used the " + dur + " to crush some ice. It has " + pickaxe.getDurability() + " durability left." );
		//System.out.println("It has " + pickaxe.getDurability() + " durability left.");

	}
	public void findScepter() {
		// Überprüfe, ob das Zepter existiert
		Scepter sc = Scepter.getInstance();
		if (sc != null) {
			// Setze den Besitzer und lege das Zepter in den Rucksack
			sc.setOwner(this);
			this.backpack.putScepterIntoBackpack(sc);
			System.out.println(this + " found the scepter and put it into their backpack.");
		} else {
			// Falls das Zepter nicht vorhanden ist
			System.out.println("The scepter could not be found.");
		}
	}

	public void steal(Entdeckuin other){

		Scepter sc = other.getBackpack().getScepter();
		sc.setOwner(this);
		backpack.putScepterIntoBackpack(sc);
	}
	@Override
	public String toString(){
		return "Entdeckuin" + " " + name + "(" + age + ")";
	}

	public static void main(String[] args) {
		/*
		 * TODO: Remove the comment symbols and run the main-method for testing. You can
		 * change this method however you like!
		 */
        try {

	    Entdeckuin antonia = new Entdeckuin("Antonia", 5, "salmon", "salted");

		antonia.addProvisions(new Fish("salmon", "salted"));
		antonia.usePickaxe();
		antonia.findScepter();
		antonia.eat();
	}
		catch (Exception e){
			e.printStackTrace();
		}
} }
