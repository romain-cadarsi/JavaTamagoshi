package testPackage;

import java.util.ArrayList;
import java.util.TreeSet;

import mesObjets.Salarie;
import mesObjets.SalarieComparatorByNom;
import mesObjets.SalarieComparatorBySalaire;
import mesObjets.SalarieComparatorBySalaireAndName;

public class TestList {
	
	  public static ArrayList<Salarie> trierParSalaire(ArrayList list){
		  SalarieComparatorBySalaire comparator = new SalarieComparatorBySalaire();
		  TreeSet<Salarie> sortedArray = new TreeSet<Salarie>(comparator);
		  sortedArray.addAll(list);
		  return new ArrayList(sortedArray.descendingSet());
	    }
	  
	  public static ArrayList<Salarie> trierParNom(ArrayList list){
		  SalarieComparatorByNom comparator = new SalarieComparatorByNom();
		  TreeSet<Salarie> sortedArray = new TreeSet<Salarie>(comparator);
		  sortedArray.addAll(list);
		  return new ArrayList(sortedArray);
	    }
	  
	  public static ArrayList<Salarie> trierParNomEtSalaire(ArrayList list){
		  SalarieComparatorBySalaireAndName comparator = new SalarieComparatorBySalaireAndName();
		  TreeSet<Salarie> sortedArray = new TreeSet<Salarie>(comparator);
		  sortedArray.addAll(list);
		  return new ArrayList(sortedArray.descendingSet());
	    }
	
	public static void main(String[] args) {
		
		ArrayList<Salarie> liste = new ArrayList<Salarie>();
	    liste.add(new Salarie("Pierre","Gold n Gold",60000));
	    liste.add(new Salarie("Jacques", "Clean n Dry",1000));
	    liste.add(new Salarie("Jules", "Clean n Dry",1000));
	    liste.add(new Salarie("Albert", "No where", 2000));
	    liste.add(new Salarie("Zizou", "RMCF", 60000));
	    liste.add(new Salarie("Charles","Dad n Son", 5000));
	    
	  
	    
	    System.out.println(liste);
	    ArrayList listeTrie = TestList.trierParSalaire(liste);
	    System.out.println(listeTrie);
	    
	   ArrayList listeAlphabetic = TestList.trierParNom(liste);
	   System.out.println(listeAlphabetic);

	   ArrayList listeTrieSalaireAndName = TestList.trierParNomEtSalaire(liste);
	   System.out.println(listeTrieSalaireAndName);
	    
	   
	    
		
	}

}
