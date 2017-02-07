/*
 * Name: Jacob Bindl
 * Course: Data Structures
 * Date: 2/3/16
 * Class: ListNode class to create a LinkedList for Project1
 */
package Project1;

public class TitanicListNode {

	private Object data;
	private TitanicListNode nextNode;
	

	/* Create a constructor of ListNode that takes a new data 
	 * (with Object data type) as input. In this constructor, initialize
	 *  the nextNode to null and assign data to the input object */
	
	//Constructor
	public TitanicListNode(Object data){
		nextNode = null;
		this.data = data;
	}
		
	/* Create a constructor of ListNode that takes two inputs: a new 
	 * data (with Object data type), and a new nextNode 
	 * (with ListNode data type). In this constructor, initialize the 
	 * class variables to the input data and the nextNode accordingly */
	
	//Constructor
	public TitanicListNode(Object data, TitanicListNode nextNode){
		this.data = data;
		this.nextNode = nextNode;
	}
	
	//Getters and Setters for nextNode and data items.

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the nextNode
	 */
	public TitanicListNode getNextNode() {
		return nextNode;
	}

	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(TitanicListNode nextNode) {
		this.nextNode = nextNode;
	}

}
