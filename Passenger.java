/*
 * Name: Jacob Bindl
 * Course: Data Structures
 * Date: 2/3/16
 * Class: Passenger for creating objects to store in the LinkedList
 */
package Project1;

public class Passenger {
	private String index;
	private String passClass;
	private String age;
	private String sex;
	private String survive;
	
	//Constructor
	public Passenger(String index, String passClass, String age, String sex, String survive){
		this.index = index;
		this.passClass = passClass;
		this.age = age;
		this.sex = sex;
		this.survive = survive;
	}
	
	//Getters and Setters
	public String getIndex(){
		return index;
	}
	
	public String getPassClass(){
		return passClass;
	}
	
	public String getAge(){
		return age;
	}
	
	public String getSex(){
		return sex;
	}
	
	public String getSurvive(){
		return survive;
	}
	
	public void setIndex(String index){
		this.index = index;
	}
	
	public void setPassClass(String passClass){
		this.passClass = passClass;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public void setSurvive(String survive){
		this.survive = survive;
	}
	
	//Overriding toString() method
	public String toString(){
		return index + " , " + passClass + " , " + age + " , " + sex + " , " + survive;
	}
	
}
