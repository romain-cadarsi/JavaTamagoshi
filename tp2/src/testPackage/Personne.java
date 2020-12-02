package testPackage;

public class Personne {

	  private String name;
	  
	  public Personne(String nom) {
	    name = nom;
	  }
	 
	  @Override
	  public String toString() {
	    return super.toString()+"  -> name = \""+name+"\"";
	  }

	  /**
	   * @param name the name to set
	   */
	  public void setName(String name) {
	    this.name = name;
	  }
	  
	  public Personne clone() {
		  return new Personne(this.name);
	  }

}
