package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 5
 *  returns their name and a
 *  modified string 
 *  
 *  @author Bob
 *  @version 1.1
 */
public class Person5 {
  /** Holds the persons real name */
  private String name;
  	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
  public Person5(String pname) {
    name = pname;
  }
  	/**
	 * This method should take the string
	 * input and return its characters rotated
	 * 2 positions.
	 * given "gtg123b" it should return
	 * "g123bgt".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
	  private String calc(String input) {
>>>>>>> origin/master
          String newString = "";
          for (int i = 2; i < input.length(); i++) {
            newString += input.charAt(i);
          }
          newString += input.charAt(0);
          newString += input.charAt(1);
          return newString;
<<<<<<< HEAD
=======
        }
=======
	  String newString = "";
	  for (int i = 2; i < input.length(); i++) {
	    newString += input.charAt(i);
	  }
	  newString += input.charAt(0);
	  newString += input.charAt(1);
	  return newString;
>>>>>>> 7cc729f410ff150d38954a05be8a971e39cd9fb6
>>>>>>> origin/master
	}
	
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}

}
