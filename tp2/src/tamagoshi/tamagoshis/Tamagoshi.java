package tamagoshi.tamagoshis;

import java.util.Random;

public class Tamagoshi {
	
	private int age;
	
	private int maxEnergy;
	
	private int energy;
	
	private String name;
	
	static int lifeTime = 10;
	
	private Random random = new Random();

	public Tamagoshi(String name) {
		super();
		this.name = name;
		this.age = 0;
		this.maxEnergy = this.random.nextInt(4) + 5 ;
		this.energy = this.random.nextInt(4) + 3;
	}
	
	public boolean parle() {
		System.out.println(this.name + " est mon nom, je suis " + (this.energy > 4 ? "heureux" : "affamé"));
		return this.energy >4;
	}
	
	public boolean mange() {
		int valMange = 0;
		boolean peutManger = false;
		if(this.energy < this.maxEnergy) {
			valMange = this.random.nextInt(2) + 1;
			if(valMange < this.maxEnergy - this.energy) {
				this.energy += valMange;
				peutManger = true;
			}
		}
		System.out.println(peutManger ? ("Miam, +"+valMange) : ("JE N'AI PAS FAIM ARRETEZ DE ME GAVER COMME UNE OIE"));
		return peutManger;
	}
	
	
	/**
	 * Si il peut consommer de l'energie sans mourir, renvoie true sinon renvoie false
	 * @return
	 */
	public boolean consommeEnergie() {
		boolean vivant = false;
		if(this.energy-1 > 0) {
			vivant = true; 
			this.energy -= 1;
		}
		System.out.println(vivant ? "" : "Arrrrghhhhh vous ne m'avez pas nourri, abandonnez moi la, Je suis KO");
		return vivant;
	}

	@Override
	public String toString() {
		return "Tamagoshi [age=" + age + ", maxEnergy=" + maxEnergy + ", energy=" + energy + ", name=" + name
				+ ", random=" + random + "]";
	}
	
	/**
	 * Getter 
	 * @return
	 */
	public int getLifeTime() {
		return Tamagoshi.lifeTime;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	
	/**
	 * Si le tamagoshi peut vieillir , alors il renvoie true et vieillit, sinon il renvoie false
	 * @return
	 */
	public boolean viellir() {
		if(this.age +1 < Tamagoshi.lifeTime) {
		  this.age += 1;
		  return true;
		}
		else {
			return false;
		}
	}
	
	
	

}
