package mesObjets;

import java.util.Comparator;

public class SalarieComparatorByNom implements Comparator<Salarie>{

	@Override
	public int compare(Salarie arg0, Salarie arg1) {
		
			return arg0.getNom().compareTo(arg1.getNom());
	}

}
