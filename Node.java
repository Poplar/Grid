import java.util.*;
import java.io.*;
class Node {
	private Value val;
	private Node down, right;
	
	Node (Value valIn, Node downIn, Node rightIn){
		val = valIn;
		down = downIn;
		right = rightIn;
	}
	
	Node(){
		val = new Value();
		down = null;
		right = null;
	}
	
	Node right(){
		return right;
	}
	Node down(){
		return down;
	}
	
	Node setRight(Node input){
		right = input;
		return input;
	}
	
	Node settRight(Node input){ //for use when adding nodes
		right = input;
		return this; 
	}
	
	Node setDown(Node input){
		down = input;
		return input;
	}
	
	Node settDown(Node input){
		down = input;
		return this;
	}
	Value getValue(){
		return val;
	}
	void setValue(Value inVal){
		val = inVal;
	}
	
	public String toString(){
		return val.toString();
	}
}