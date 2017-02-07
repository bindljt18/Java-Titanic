/*
 * Name: Jacob Bindl
 * Course: Data Structures
 * Date: 2/3/16
 * Class: Catches exceptions if the LinkedList is empty
 */
package Project1;

public class EmptyListException extends RuntimeException{
	
	public EmptyListException() {
		this("List");
	}
	
	public EmptyListException(String name) {
		super(name+" is empty");
	}
}
