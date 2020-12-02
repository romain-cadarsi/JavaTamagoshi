package tamagoshi.jeu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import tamagoshi.exceptions.InvalidNumberOfTamagoshi;
import tamagoshi.tamagoshis.Tamagoshi;

public class TamaGame {

	public ArrayList<Tamagoshi> listeDebut;

	public ArrayList<Tamagoshi> listeActuelle;

	public ArrayList<Tamagoshi> listeMorts;


	public TamaGame() {
		this.listeDebut = new ArrayList<Tamagoshi>();
		this.listeActuelle = new ArrayList<Tamagoshi>();
		this.listeMorts = new ArrayList<Tamagoshi>();
	}

	public String saisirClavier() {
		return Utilisateur.saisieClavier();
	}

	public void initialisation() {
		System.out.println("Entrez le nombre de tamagoshi desiré : ");
		boolean valid = false;
		int numberOfTamagoshi = 0;
		do {
			try {
				numberOfTamagoshi = Integer.valueOf(Utilisateur.saisieClavier());
				if(numberOfTamagoshi < 1) {
					throw new InvalidNumberOfTamagoshi();
				}
				valid = true;

			}catch (InvalidNumberOfTamagoshi | NumberFormatException e ) {
				System.out.println("Votre saisie n'est pas valide, recommencez");
				valid = false;
			}
		}while(!valid);

		for(int i = 0 ; i < numberOfTamagoshi ; i++) {
			System.out.println("Entre le nom du Tamagoshi " + i);
			this.listeDebut.add(new Tamagoshi(saisirClavier()));
		}

		Iterator<Tamagoshi> iterator = this.listeDebut.iterator();

		while(iterator.hasNext()) {
			Tamagoshi tamagoshi = iterator.next();
			listeActuelle.add(tamagoshi);
		}
	}


	public void play() {
		initialisation();
		int tour = 0;
		boolean valid = false;
		while(tour < 10) {
			System.out.println("--------- Cycle N°" + tour + "---------------- ");
			for(Tamagoshi tamagoshi : this.listeActuelle) {
				tamagoshi.parle();
			}
			System.out.println("Nourrir quel Tamagoshi ? ");
			for(Tamagoshi tamagoshi : this.listeActuelle) {
				System.out.print("[" + this.listeActuelle.indexOf(tamagoshi) + "]" + tamagoshi.getName() + "     ");
			}

			do {

				try {
					Tamagoshi tamagoshi = this.listeActuelle.get(Integer.parseInt(saisirClavier()));
					System.out.print(tamagoshi.getName() + " : ");
					tamagoshi.mange();
					valid = true;
				}catch (IndexOutOfBoundsException e) {
					System.out.println("Votre saisie n'est pas valide, recommencez");
					valid = false;
				}
			} while(valid != true);

			Iterator<Tamagoshi> iterator = this.listeActuelle.iterator();
			
			while(iterator.hasNext()) {
				Tamagoshi tamagoshi = iterator.next();
				if(tamagoshi.consommeEnergie() == false) {
					System.out.print(tamagoshi.getName() + " : ");
					this.listeMorts.add(tamagoshi);
					iterator.remove();
				}
				if(tamagoshi.viellir() == false) {
					iterator.remove();
				}
			}

			tour += 1 ; 
		}
		finish();

	}



	public void finish() {
		System.out.println("--------- fin de partie !! ---------------- ");
		System.out.println("-------------bilan------------ ");

		int score = score();
		for(Tamagoshi tamagoshi : this.listeDebut) {
			if(this.listeMorts.contains(tamagoshi)) {
				System.out.println(tamagoshi.getName() + " n'est pas arrivé au bout et ne vous félicite pas :( ");
			}
			else {
				System.out.println(tamagoshi.getName() + " a survécu et vous remercie :) ");
			}
		}

		System.out.println("Score obtenu : " + score);


	}


	public int score() {
		int score = 0 ; 
		int maxAge = 0;
		for(Tamagoshi tamagoshi : this.listeDebut) {
			score += tamagoshi.getAge();
			maxAge = tamagoshi.getLifeTime();
		}
		score = (score / (maxAge * this.listeDebut.size())) * 100;
		return score;
	}


	public static void main(String[] args) {
		TamaGame jeu = new TamaGame();
		jeu.play();

	}


}
