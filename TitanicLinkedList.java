/*
 * Name: Jacob Bindl
 * Course: Data Structures
 * Date: 2/3/16
 * Class: LinkedList for project 1
 */
package Project1;

import java.util.ArrayList;

public class TitanicLinkedList {
	//Class variable declaration
	
		private TitanicListNode firstNode;
		private TitanicListNode lastNode;
		private String listName;
		private int size;
		
		/* First constructor of the LinkedList class */
		public TitanicLinkedList() {
			/* Initialize listName as “new list”, size as 0, firstNode 
			 * and lastNode are all null */
			listName = "new list";
			size = 0;
			firstNode = lastNode = null;
		}
		
		/**
		 * This method named size() returns the number of elements in 
		 * this linked list
		 * @return an integer representing the number of elements that 
		 * are in this linked list */
		
		public int size(){
			return size;
		}
		
		/**
		 * This method named isEmpty() determines if the linked list is 
		 * empty
		 * @return true if the linked list is empty and return false 
		 * otherwise
		 */
		
		public boolean isEmpty(){
			if(size == 0)
				return true;
			else
				return false;
		}
		
		/**
		 * Method: insertAtHead
		 * This method insert an object at front of the linked list
		 * Algorithm:
		 * 	 if the list is empty then
		 * 		the first node and the last node point to the same new node
		 * 		Note: When using ListNode constructor, please use the 
		 * 		constructor with one parameter
		 * 	 else
		 * 		first node point to the new node.
		 * 		Note: When using ListNode constructor, please use the 
		 * 		constructor with two parameters
		 *   increase the size of the list by 1
		 * @param item
		 * 		item: the new object being inserted
		 */
		
		public void insertAtHead(Object item){
			
			if(isEmpty()){
				TitanicListNode newNode = new TitanicListNode(item);
				firstNode = lastNode = newNode;
			}
			else{
				TitanicListNode newNode = new TitanicListNode(item, firstNode);
				firstNode = newNode;
			}
			
			size++;
		}
		
		/**
		 * Method: insertAtTail
		 * This method insert an object at the back of the linked list
		 * Algorithm:
		 *   if the list is empty then	
		 *			the first node and the last node point to the same new 
		 *			node
		 * 			Note: When using ListNode constructor, please use the 
		 * 			constructor with one parameter
		 * 	 else
		 * 			last node point to the new node and new node become 
		 * 			last node
		 * 			Note: When using ListNode constructor, please use 
		 * 			the constructor with two parameters
		 *  increase the size of the list by 1
		 * @param item
		 */
		
		public void insertAtTail(Object item){
			TitanicListNode newNode = new TitanicListNode(item);
			
			if(isEmpty()){
				firstNode = lastNode = newNode;
			}
			else{
				lastNode.setNextNode(newNode);
				lastNode = newNode;
			}
			size++;
		}
		
		
		
		/**
		 * Method: removeFromHead
		 * This method is to remove a node from front of the list
		 * Algorithm:
		 *    if the list is empty then
		 *         throw EmptyListException
		 *    else
		 *    	   Get the data of the first node (which is deleted) and store it somewhere
		 *    	   if first node points to the last node then
		 *              first node and last node both point to null
		 *         else 
		 *              first node point to the next node (neigboring node of the first node)
		 *         decrease the size of the list by 1
		 *         return the object that contains the data of the old first node (been stored somewhere)         
		 * 
		 * @throws EmptyListException
		 */
		
		public Object removeFromHead() throws EmptyListException{
			
			if(isEmpty())
				throw new EmptyListException();
			else{
				Object tempData = firstNode.getData();
				if(firstNode == lastNode)
					firstNode = lastNode = null;
				else
					firstNode = firstNode.getNextNode();
					size--;
					return tempData;
			}
		}
		

		/**
		 * Method: removeFromTail
		 * This method removes the last element in the LinkedList
		 * Algorithm:
		 * 
		 *    if the list is empty then
		 *         throw EmptyListException
		 *    else
		 *    	  Store the data of the current last node somewhere
		 *        Starting from the first node of the linked list, go to the 
		 *        node before the last node of this list (hint: using a while loop)
		 * 		  update the reference of the last node so that it now points to the node right before it	
		 * 		  set the next node of the new last node to null
		 * 		  decrease the size of the list by 1
		 * 		  Return the data of the old last node (being stored somewhere)
		 * 
		 */
		
		public Object removeFromTail() throws EmptyListException{
			
			if(isEmpty())
				throw new EmptyListException();
			else{
				Object tempData;
				if(firstNode == lastNode){
					tempData = lastNode.getData();
					firstNode = lastNode = null;
				}
				else{
					TitanicListNode current = firstNode;
					while(current.getNextNode() != lastNode)
						current = current.getNextNode();
					tempData = lastNode.getData();
					lastNode = current;
					lastNode.setNextNode(null);
				}
				size--;
				return tempData;
			}
		}
		
		/**
		   Method: printList
		   This method prints the list content on the screen
	*/
		
		public void printList(){
			TitanicListNode current = firstNode;
			
			while(current != null){
				System.out.println(current.getData().toString());
				current = current.getNextNode();
			}
		}
		
		//Method to count number of survivors
		public int getAmountSurvived(){
			TitanicListNode current = firstNode;
			int total = 0;
			
			while(current != null){
				if(((Passenger) current.getData()).getSurvive().equals("yes")){
					total = total + 1;
				}
				current = current.getNextNode();
			}
			return total;
		}
		
		//Method to count number of non-survivors
		public int getAmountNotSurvived(){
			TitanicListNode current = firstNode;
			int total = 0;
			
			while(current != null){
				if(((Passenger) current.getData()).getSurvive().equals("no")){
					total = total + 1;
				}
				current = current.getNextNode();
			}
			return total;
		}
		
		//Method to count number men who did not survive
		public int getAmountMenNotSurvived(){
			TitanicListNode current = firstNode;
			int total = 0;
			
			while(current != null){
				if(((Passenger) current.getData()).getSex().equals("man") && 
						((Passenger) current.getData()).getSurvive().equals("no") &&
						((Passenger) current.getData()).getAge().equals("adults")){
					total = total + 1;
				}
				current = current.getNextNode();
			}
			return total;
		}
		
		//Method to count number of women who did not survive
		public int getAmountWomenNotSurvived(){
			TitanicListNode current = firstNode;
			int total = 0;
			
			while(current != null){
				if(((Passenger) current.getData()).getSex().equals("women") && 
						((Passenger) current.getData()).getSurvive().equals("no") &&
						((Passenger) current.getData()).getAge().equals("adults")){
					total = total + 1;
				}
				current = current.getNextNode();
			}
			return total;
		}
		
		//Method to count the number of children who did not survive
		public int getAmountChildNotSurvived(){
			TitanicListNode current = firstNode;
			int total = 0;
			
			while(current != null){
				if(((Passenger) current.getData()).getAge().equals("child") && 
						((Passenger) current.getData()).getSurvive().equals("no")){
					total = total + 1;
				}
				current = current.getNextNode();
			}
			return total;
		}
		
		//Method to count the number of survivors by passenger's class
		public int getClassSurvived(int index){
			TitanicListNode current = firstNode;
			int[] count = new int[3];
			
			while(current != null){
				if(((Passenger) current.getData()).getPassClass().equals("1st class") &&
						((Passenger) current.getData()).getSurvive().equals("yes")){
					count[0] = count[0] + 1;
				}
				else if(((Passenger) current.getData()).getPassClass().equals("2nd class") &&
						((Passenger) current.getData()).getSurvive().equals("yes")){
					count[1] = count[1] + 1;
				}
				else if(((Passenger) current.getData()).getPassClass().equals("3rd class") &&
						((Passenger) current.getData()).getSurvive().equals("yes")){
					count[2] = count[2] + 1;
				}
				current = current.getNextNode();
			}
			return count[index];
		}
		
		//This method sorts the the list by survived, then age, then class and adds it to a new Linked List
		//and returns that new list
		public TitanicLinkedList sortList(){
			TitanicLinkedList list = new TitanicLinkedList();
			TitanicListNode current = firstNode;
			
			ArrayList tempYes = new ArrayList();
			ArrayList tempNo = new ArrayList();
			ArrayList tempYesAdults = new ArrayList();
			ArrayList tempYesChild = new ArrayList();
			ArrayList tempNoAdults = new ArrayList();
			ArrayList tempNoChild = new ArrayList();
			
			//Separate survived from not survived and store in temporary ArrayList
			while(current!= null){
				if(((Passenger) current.getData()).getSurvive().equals("yes")){
					tempYes.add((Passenger) current.getData());
				}
				else{
					tempNo.add((Passenger) current.getData());
				}	
				current = current.getNextNode();
			}
			
			//Separate SURVIVED adults from child and store in temporary ArrayList
			for(int j = 0; j< tempYes.size(); j++){
				if(((Passenger) tempYes.get(j)).getAge().equals("adults")){
					tempYesAdults.add(tempYes.get(j));
				}
				else{
					tempYesChild.add(tempYes.get(j));
				}
			}
			
			//Now sort the temporary ArrayLists and put into LinkedList by class
			
			//Adults 1st class
			for(int j = 0; j < tempYesAdults.size(); j++){
				if(((Passenger) tempYesAdults.get(j)).getPassClass().equals("1st class")){
					list.insertAtTail(tempYesAdults.get(j));
				}
			}
			
			//Adults 2nd class
			for(int j = 0; j < tempYesAdults.size(); j++){
				if(((Passenger) tempYesAdults.get(j)).getPassClass().equals("2nd class")){
					list.insertAtTail(tempYesAdults.get(j));
				}
			}
			
			//Adults 3rd class
			for(int j = 0; j < tempYesAdults.size(); j++){
				if(((Passenger) tempYesAdults.get(j)).getPassClass().equals("3rd class")){
					list.insertAtTail(tempYesAdults.get(j));
				}
			}
			
			//Child first class
			for(int j = 0; j < tempYesChild.size(); j++){
				if(((Passenger) tempYesChild.get(j)).getPassClass().equals("1st class")){
					list.insertAtTail(tempYesChild.get(j));
				}
			}
			
			//Child 2nd class
			for(int j = 0; j < tempYesChild.size(); j++){
				if(((Passenger) tempYesChild.get(j)).getPassClass().equals("2nd class")){
					list.insertAtTail(tempYesChild.get(j));
				}
			}
			
			//Child 3rd class
			for(int j = 0; j < tempYesChild.size(); j++){
				if(((Passenger) tempYesChild.get(j)).getPassClass().equals("3rd class")){
					list.insertAtTail(tempYesChild.get(j));
				}
			}
			
			//Sort non-survived adults and child and store in temporary ArrayList
			for(int j = 0; j < tempNo.size(); j++){
				if(((Passenger) tempNo.get(j)).getAge().equals("adults")){
					tempNoAdults.add(tempNo.get(j));
				}
				else{
					tempNoChild.add(tempNo.get(j));
				}
			}
			
			//Sort sort these temporary ArrayLists and add them to the LinkedList by CLASS
			
			//Adults 1st class
			for(int j = 0; j < tempNoAdults.size(); j++){
				if(((Passenger) tempNoAdults.get(j)).getPassClass().equals("1st class")){
					list.insertAtTail(tempNoAdults.get(j));
				}
			}
			
			//Adults 2nd class
			for(int j = 0; j < tempNoAdults.size(); j++){
				if(((Passenger) tempNoAdults.get(j)).getPassClass().equals("2nd class")){
					list.insertAtTail(tempNoAdults.get(j));
				}
			}
			
			//Adults 3rd class
			for(int j = 0; j < tempNoAdults.size(); j++){
				if(((Passenger) tempNoAdults.get(j)).getPassClass().equals("3rd class")){
					list.insertAtTail(tempNoAdults.get(j));
				}
			}
			
			//Child 1st class
			for(int j = 0; j < tempNoChild.size(); j++){
				if(((Passenger) tempNoChild.get(j)).getPassClass().equals("1st class")){
					list.insertAtTail(tempNoChild.get(j));
				}
			}
			
			//Child 2nd class
			for(int j = 0; j < tempNoChild.size(); j++){
				if(((Passenger) tempNoChild.get(j)).getPassClass().equals("2nd class")){
					list.insertAtTail(tempNoChild.get(j));
				}
			}
			
			//Child 3rd class
			for(int j = 0; j < tempNoChild.size(); j++){
				if(((Passenger) tempNoChild.get(j)).getPassClass().equals("3rd class")){
					list.insertAtTail(tempNoChild.get(j));
				}
			}

			return list;	
		}
		
		//this method sorts the list by non-survived then by class and adds it to a new LinkedList
		//and returns that new list
		public TitanicLinkedList sortList2(){
			TitanicLinkedList list = new TitanicLinkedList();
			TitanicListNode current = firstNode;
			
			ArrayList tempYes = new ArrayList();
			ArrayList tempNo = new ArrayList();
			
			//Separate survived from not survived and store in temporary ArrayList
			while(current!= null){
				if(((Passenger) current.getData()).getSurvive().equals("yes")){
					tempYes.add((Passenger) current.getData());
				}
				else{
					tempNo.add((Passenger) current.getData());
				}	
				current = current.getNextNode();
			}
			
			//Sort the non-survived ArrayList temporary ArrayLists and add them to the LinkedList by CLASS
			
			//1st class
			for(int j = 0; j < tempNo.size(); j++){
				if(((Passenger) tempNo.get(j)).getPassClass().equals("1st class")){
					list.insertAtTail(tempNo.get(j));
				}
			}
			
			//2nd class
			for(int j = 0; j < tempNo.size(); j++){
				if(((Passenger) tempNo.get(j)).getPassClass().equals("2nd class")){
					list.insertAtTail(tempNo.get(j));
				}
			}
			
			//3rd class
			for(int j = 0; j < tempNo.size(); j++){
				if(((Passenger) tempNo.get(j)).getPassClass().equals("3rd class")){
					list.insertAtTail(tempNo.get(j));
				}
			}
			//Sort the survived from temporary ArrayList by class and store in LinkedList
			
			//1st class
			for(int j = 0; j < tempYes.size(); j++){
				if(((Passenger) tempYes.get(j)).getPassClass().equals("1st class")){
					list.insertAtTail(tempYes.get(j));
				}
			}
			
			//Adults 2nd class
			for(int j = 0; j < tempYes.size(); j++){
				if(((Passenger) tempYes.get(j)).getPassClass().equals("2nd class")){
					list.insertAtTail(tempYes.get(j));
				}
			}
			
			//Adults 3rd class
			for(int j = 0; j < tempYes.size(); j++){
				if(((Passenger) tempYes.get(j)).getPassClass().equals("3rd class")){
					list.insertAtTail(tempYes.get(j));
				}
			}
			
			return list;
		}
		
		//Getters and Setters
		public TitanicListNode getFirstNode() {
			return firstNode;
		}
		
		public TitanicListNode getLastNode() {
			return lastNode;
		}

		public void setFirstNode(TitanicListNode top) {
			firstNode = top;
		}
		public void setLastNode(TitanicListNode last) {
			lastNode = last;
		}
		public int getSize() {
			return size;
		}

}
