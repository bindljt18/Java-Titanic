/*
 * Name: Jacob Bindl
 * Course: Data Structures
 * Date: 2/3/16
 * Class: Driver Class for Project 1
 */
package Project1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String [] args){
		
		//Create LinkedList
		TitanicLinkedList list = new TitanicLinkedList();
		
		//temporary line for reading
		String line;
		
		//store Titanic data into list
		try{
			FileReader fr = new FileReader("Titanic.txt");
			BufferedReader br = new BufferedReader(fr);
			
			//Then read the rest and insert it at the tail
			while((line = br.readLine()) != null){
				String[] split = line.split(",");
				list.insertAtTail(new Passenger(split[0].trim(), split[1].trim(), split[2].trim(), 
						split[3].trim(), split[4].trim()));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//remove the unneeded first line
		list.removeFromHead();
		
		//Print report of passengers by calling methods to count
		System.out.println("Number of passengers survived: " + list.getAmountSurvived());
		System.out.println("Number of passengers that did not survive: " + list.getAmountNotSurvived());
		System.out.println("Number of male passengers that did not survive: " + list.getAmountMenNotSurvived());
		System.out.println("Number of women passegers that did not survive: " + list.getAmountWomenNotSurvived());
		System.out.println("Number of children passengers that did not survive: " + list.getAmountChildNotSurvived());
		System.out.println("Number of 1st Class passengers that survived: " + list.getClassSurvived(0));
		System.out.println("Number of 2nd Class passengers that survived: " + list.getClassSurvived(1));
		System.out.println("Number of 3rd Class passengers that survived: " + list.getClassSurvived(2));
		
		
		//Print list sorted by survived first, then age, then class
		list.sortList().printList();
		
		//Line break
		System.out.println("**********************************************************");

		//Print list sorted by non-survived first then class
		list.sortList2().printList();
	}
	
}
