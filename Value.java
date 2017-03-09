import java.util.*;
import java.io.*;
class Value{
	private double dval;
	private String sval,tag;
	
	Value(){
		dval = 0;
		tag = "STRING";
		sval = null;
	}
	
	Value(String svalIn, String tagIn, double dvalIn){
		dval = dvalIn;
		tag = tagIn;
		sval = svalIn;
	}
	
	public void setValue(String input){
		if(input.charAt(0) == '\"'){
			sval = input.substring(1);
			tag = "STRING";
		}
		else{
			dval = Double.parseDouble(input);
			tag = "DBL";
		}
	}
	public String getTag(){
		return tag;
	}
	public void setDouble(double dvalIn){
		dval = dvalIn;
		tag = "DBL";
	}
	public double getDouble(){
		return dval;
	}
	
	public String getString(){
		return sval;
	}
	
	public Value minus(Value input){
		if(tag.equals("DBL") && input.getTag().equals("DBL"))
			return new Value(null, "DBL", (dval - input.getDouble()));
		else
			return new Value(null, "INVALID", 0);
	}

	public Value plus(Value input){
		if(tag.equals("DBL") && input.getTag().equals("DBL"))
			return new Value(null, "DBL", (dval + input.getDouble()));
		else
			return new Value(null, "INVALID", 0);
	}
	
	public Value star(Value input){
		if(tag.equals("DBL") && input.getTag().equals("DBL"))
			return new Value(null, "DBL", (dval * input.getDouble()));
		else
			return new Value(null, "INVALID", 0);
	}
	
	public Value slash(Value input){
		if(tag.equals("DBL") && input.getTag().equals("DBL")){
			if(input.getDouble() == 0.0){
				System.out.println("DIV BY 0");
				return new Value(null,"INVALID", 0);
			}
			else
			return new Value(null, "DBL", (dval / input.getDouble()));
		}
		else
			return new Value(null, "INVALID", 0);
	}
	
	public String toString(){
		if(tag.equals("DBL"))
			return String.format("%10.4f", dval);
		else
			return String.format("%10s", sval);
	}
}