//============ TO DO ============
// COMPLETE THE methods in the SList class and the needed testing condition 
// in the main method (the driver)
// DOCUMENT and COMMENT the code appopriately.
/////////////////////////////////////////////////////

/**
 * The Node class to encapsulate the data and reference of a data structure 
 * node. This class is an independent class, so we need setters and getters 
 * @author Ken Nguyen
 * @version 1 - Node class is independent
 */
class Node<T>{
	private T data;
	private Node<T> next;
	
	public Node(T data){ //initialize the attributes
		this.data = data;
		this.setNext(null);
	}
	
	/**
	 * 
	 * @return the data field stored in the node
	 */
	public T getData(){
		return this.data;
	}
	/**
	 * set the given data to the data attribute
	 * @param data
	 */
	public void setData(T data){
		this.data = data;
	}
	/**
	 * 
	 * @return the reference to the next node
	 */
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}

/** ========== COMPLETE THE FOLLOWING CLASS==========
 * An INCOMPLETE template for a generic type singly linked list class - 
 * You should complete this class and create a driver to test it
 */
public class SList<T> { //note: T is a a placeholder for a data type 
	//attributes
	private Node<T> head;
	private int size;
	
	/**
	 * Default constructor
	 */
	public SList(){ //default constructor
		this.head = null;
		this.size = 0;
	}
   
	
	/**
	 * add the given data as a node to the end of the list
	 * @param data - data to be added to the end of the list
	 * @return - the reference to the newly added Node object containing 
	 *           the data in the list
	 */
	public Node<T> addLast(T data){
		//empty list, create it as the first node
		if(this.head == null){
			return this.addFirst(data);
		}
		
		//processing non-empty list
		Node<T> newNode = new Node<T>(data); // new tail node
		Node<T> curr = this.head; // place holder
		while(curr.getNext() != null){ // traverse through the list 
			curr = curr.getNext();
		}
	   curr.setNext(newNode);
      size++; // increment after adding a new node		
		return newNode; 
	}
	/**
	 * add the given data as the first node of the list
	 * @param data - data to be added as the first node to the list
	 * @return - the reference to the newly added Node object containing
	 *           the data in the list
	 */
	public Node<T> addFirst(T data){
		Node<T> newNode = new Node<T>(data);
		if(this.head !=null) // new node stays before the existing first node
			newNode.setNext(this.head);	

			this.head = newNode; // head points at the new element
			this.size++;
		return this.head;
		
	}
	/**
	 * remove the first node of the list
	 */
	public void removeFirst(){
		if(this.head != null) {
         Node<T> curr = this.head.getNext(); // place holder
         this.head.setNext(null); // points to null
         this.head = curr; // point the head to the next node     
         size--;    // decrement size
      }
         
	}
	
	/**
	 * remove the last node of the list
	 */
	public void removeLast(){
	
//TO BE COMPLETED 
// still unhappy with this. There has to be a better way to remove the last
      Node<T> curr = this.head;
      while(curr.getNext() != null){
         curr = curr.getNext();
      }
      curr.setData(null);
      size--; 
         	
	}
	
	/**
	 * @return a string representing the list
	 */
	public String toString(){
		Node<T> temp = this.head;
		String output = "";
		while(temp != null){
		  output += temp.getData() + " " ;
		  temp = temp.getNext();
		}
		return output;
	}
	
	/**
	 * 
	 * @return the number of nodes in the list
	 */
	public int getSize() {
		return size;
	}
	
	//=============================================================
	//==== A DRIVER to test the SList class - 
    // REMOVE THE DRIVER BEFORE RELEASE                        ====
	//=============================================================
	public static void main(String args[]){

         //== Add code to test all functionalities of the SList class==
         
           //create a list of intergers
	   SList <Integer> myList = new SList <Integer>();
	   myList.addFirst(5); //add avalue
	 
	   myList.addLast(10);
	   myList.addFirst(1);
	   myList.addLast(2);
	 	  
	   System.out.println("List size: " + myList.getSize());
	   System.out.println(myList);
	   myList.removeFirst();
	   	   
	   System.out.println("List size: " + myList.getSize());
	   System.out.println(myList);
	   myList.removeLast();
	   System.out.println("List size: " + myList.getSize());
	   System.out.println(myList);
	 
//TO BE COMPLETED
	   //1. add code to invoke removeFirst and removeLast from an empty list
	   
	}
	//==== END of the DRIVER =============	
}


