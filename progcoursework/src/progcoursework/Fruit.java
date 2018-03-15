package progcoursework;

public class Fruit 	      	     	   	  	   	         	
{

  /* NOOBLAB READONLY */
  /* You cannot (and are not supposed to) change this class. */

  private String name;
  private String colour;
  private String country;

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return this.name;
  }

  public void setColour(String colour)
  {
    this.colour = colour;
  }

  public String getColour()
  {
    return this.colour;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getCountry()
  {
    return this.country;
  }

  /* IGNORE THE CODE BELOW THIS LINE!
     DO *NOT* REMOVE THE CODE BELOW THIS LINE! */

  public static java.util.ArrayList<Fruit> allFruits;

  public Fruit()
  {
  	if (allFruits == null) allFruits = new java.util.ArrayList();
  	allFruits.add(this);
  }
}
