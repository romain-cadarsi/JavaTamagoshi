package mesObjets;

import java.util.Comparator;

public class SalarieComparatorBySalaire implements Comparator<Salarie>{

	@Override
	public int compare(Salarie arg0, Salarie arg1) {
		
			return arg0.getSalaire() - arg1.getSalaire();
	}

}
