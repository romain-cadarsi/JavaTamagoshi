package testPackage;

public class Bidule {


    private int valeur;
    private Personne personne;
    private int compteur;

    public Bidule(int valeur) {
  this.valeur = valeur;
  personne = new Personne("toto " + valeur);
  compteur = 0;
    }

    @Override
    public String toString() {
  return super.toString() + " contient -> value = " + valeur + " ; pers = " + personne;
    }

    public void incrementCompteur() {
  compteur++;
    }
    
    public Bidule clone() {
    	Bidule biduleRetour = new Bidule(this.getValeur());
    	biduleRetour.setCompteur(this.getCompteur());
    	biduleRetour.setPersonne(this.getPersonne().clone());
    	return biduleRetour;
    }

    
    public boolean equals(Object o) {
    	if(o instanceof Bidule) {
    		Bidule biduleTmp = (Bidule)o;
    		return (this.getCompteur() == biduleTmp.getCompteur() && this.getPersonne() == biduleTmp.getPersonne() && this.getValeur() == biduleTmp.getValeur());
    	}
    	else return false;
    }
    /**
     * @param value
     *            the value to setz
     */
    public void setValeur(int value) {
  this.valeur = value;
    }
    
    public int getValeur() {
    	return this.valeur;
    }
    
    public int getCompteur() {
    	return this.compteur;
    }
    
    public void setCompteur( int compteur) {
    	this.compteur = compteur;
    }
    
    public void setPersonne(Personne personne) {
    	this.personne = personne;
    }
    
    /**
     * @return the pers
     */
    public Personne getPersonne() {
  return personne;
    }

    
    

    public static void main(String[] args) throws CloneNotSupportedException {
  Bidule bidule1 = new Bidule(2);
  System.out.println("bidule1 = " + bidule1);
  System.out.println();
  bidule1.incrementCompteur();

  Bidule bidule2 = new Bidule(4);

  System.out.println("bidule2 = " + bidule2);

  System.out.println("\n----------clonage de bidule1 dans bidule2------------\nRésultat :\n");

  bidule2 = (Bidule) bidule1.clone();

  System.out.println("bidule1 = " + bidule1);

  System.out.println("\nbidule2 = " + bidule2);
  System.out.println("\nbidule1.equals(bidule2) apres clonage (doit retourne vrai) -> " + bidule1.equals(bidule2) + "\n");

  System.out.println("----------manipulation du clone bidule2 sur value :  --- bidule2.setValeur(9); ---\nRésultat :\n");

  bidule2.setValeur(9);

  System.out.println("bidule1 = " + bidule1);
  System.out.println("\nbidule2 = " + bidule2);

  System.out.println("\nbidule1.equals(bidule2) apres manipulation (doit retourne faux) -> " + bidule1.equals(bidule2) + "\n");

  System.out.println("\n\n-----manipulation du clone bidule2 sur personne : --- bidule2.getPersonne().setName(\"bidule\"); ---\nRésultat :\n");

  bidule2.getPersonne().setName("bidule");

  System.out.println("bidule1 = " + bidule1);
  System.out.println("\nbidule2 = " + bidule2);

    }
}
