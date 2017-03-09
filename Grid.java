import java.util.*;
import java.io.*;
class Grid{
	int rows, cols;
	Node head;
	Node temp, temp2;
	Grid(){
		rows = 10;
		cols = 6;
		head = new Node();
		temp = head;
		temp2 = head;
		for(int j = 1; j < rows; j++){ 
			temp = temp.setDown(new Node()); //first column
		}
		temp.setDown(head); //resets
		
		for(int i = 1; i < cols; i++){ 
			temp2 = temp2.setRight(new Node()); //shift temp2 as head of next column
			temp = temp2; //ready for next iteration
			for(int j = 1; j < rows; j++){
				temp = temp.setDown(new Node());
			}
			temp.setDown(temp2); //column complete
		}
		temp2.setRight(head); 
		temp2 = head;
		temp = temp2.right(); 
		for(int i = 0; i < cols; i++){
			for(int j = 0; j < rows; j++){
				temp2.down().setRight(temp.down());
				temp2 = temp2.down();
				temp = temp.down();
			}
			temp2 = temp2.right();
			temp = temp.right();
		}
	}
	
	
	void print(){
		temp2 = head;
		temp = head;
		System.out.print("       ");
		for(int i = 0; i < cols; i++){
			System.out.print("Column " + i + "  ");
		}
		System.out.println();
		for(int i = 0; i < rows; i++){
			System.out.print("row " + i );
			temp = temp2.right();
			System.out.print(temp2);
			while(temp != temp2){
				System.out.print(temp);
				temp = temp.right();
			}
			System.out.println();
			temp2 = temp2.down();
			temp = temp2;
		}
	}
	
	
	void number(int fromRow, int fromCol, int toRow, int toCol){
		if((fromCol >= 0 && fromRow >= 0) && (toCol <= cols-1 && toRow <= rows-1) & (fromCol <= toCol && fromRow <= fromCol)){
		double numbering = 0.0;
		temp2 = head;
		temp = head;
		for(int i = 0; i < fromRow; i++)
			temp2 = temp2.down(); 
		for(int j = 0; j < fromCol; j++) 
			temp2 = temp2.right();
		temp = temp2;
		for(int i = fromRow; i < toRow+1; i++){
			for(int j = fromCol; j < toCol+1; j++){
				temp.getValue().setValue(Double.toString(numbering));
				temp = temp.right();
				numbering++;
			}
			temp2 = temp2.down();
			temp = temp2;
		}
	}
	} 

	void fill(int fromRow, int fromCol, int toRow, int toCol, String inSval){
		if((fromCol >= 0 && fromRow >= 0) && (toCol <= cols-1 && toRow <= rows-1 ) && (fromCol <= toCol && fromRow <= fromCol)){
		temp2 = head;
		temp = head;
		for(int i = 0; i < fromRow; i++)
			temp2 = temp2.down(); 
		for(int j = 0; j < fromCol; j++) 
			temp2 = temp2.right();
		temp = temp2;
		for(int i = fromRow; i < toRow+1; i++){
			for(int j = fromCol; j < toCol+1; j++){
				temp.getValue().setValue(inSval);
				temp = temp.right();
			}
			temp2 = temp2.down();
			temp = temp2;
		}
		}

	}
	
	void delCol(int inCol){
		if(inCol < cols-1 && cols > 1){
		boolean reset = false;
		if(inCol == 0){
			reset = true;
			inCol+=cols;
		}
		temp2 = head; //sets to head
		for(int j = 0; j < inCol-1; j++) 
			temp2 = temp2.right(); //sets left of column to delete by one.
		temp = temp2; //sets traversing var to temp2
		do{ 
			temp.setRight(temp.right().right());
			temp = temp.down();
		}
		while(temp != temp2);
		cols--;
		if(reset)
			head = temp2.right();
		}
	}
	
	void insCol(int inCol){ 
		if(inCol >= 0 && inCol <= cols){
		boolean reset = false;
		if(inCol == 0){
			reset = true;
			inCol+=cols;
		}
		temp2 = head; //sets to head
		for(int j = 0; j < inCol-1; j++) //
			temp2 = temp2.right(); //sets left of column to delete by one.
		temp = temp2; //sets traversing var to temp2
		
		do{ 
			temp.setRight(new Node().settRight(temp.right())); 
			temp = temp.down();
		}
		while(temp != temp2);
		temp = temp2;
		do{
			temp.right().setDown( temp.down().right() );
			temp = temp.down();
		}
		while(temp != temp2);
		cols++;
		if(reset)
			head = temp2.right();
	}
	}
	
	void delRow(int inRow){ 
		if(inRow >= 0 && inRow <= rows){
		boolean reset = false;
		if(inRow == 0){
			reset = true;
			inRow+=rows;
		}
		temp2 = head; //sets to head
		for(int j = 0; j < inRow-1; j++) //
			temp2 = temp2.down(); //sets left of column to delete by one.
		temp = temp2; //sets traversing var to temp2
		do{ 
			temp.setDown(temp.down().down());
			temp = temp.right();
		}
		while(temp != temp2);
		rows--;
		if(reset)
			head = temp2.down();
		}
	}
	
		void insRow(int inRow){ 
		if(inRow >= 0 && inRow <= rows){
		boolean reset = false;
		if(inRow == 0){
			reset = true;
			inRow+=rows;
		}
		temp2 = head; //sets to head
		for(int j = 0; j < inRow-1; j++) //
			temp2 = temp2.down(); //sets left of column to delete by one.
		temp = temp2; //sets traversing var to temp2
		do{ 
			temp.setDown(new Node().settDown(temp.down()));
			temp = temp.right();
		}
		while(temp != temp2);
		temp = temp2;
		do{
			temp.down().setRight( temp.right().down() );
			temp = temp.right();
		}
		while(temp != temp2);
		rows++;
		if(reset)
			head = temp2.down();
	}
	}
	boolean validateNode(int inRow, int inCol){
		if((inRow >= 0 && inRow < rows) && (inCol >= 0 && inCol < cols))
			return true;
		else
			return false;
	}
	Node findNode(int inRow, int inCol){
		temp2 = head;
		temp = temp2;
		for(int i = 0; i < inRow; i++)
			temp = temp.down();
		for(int j = 0; j < inCol; j++)
			temp = temp.right();
		return temp;
	}
	
	void addNode(int inRow1, int inCol1, int inRow2, int inCol2, int outRow1, int outCol1){
		if(validateNode(inRow1, inCol1) && validateNode(inRow2, inCol2) && validateNode(outRow1, outCol1)){
			Value tempA = new Value();
			tempA = findNode(inRow1, inCol1).getValue().plus(findNode(inRow2, inCol2).getValue());
			if(tempA.getTag().equals("INVALID"));//do not assign
			else
				findNode(outRow1, outCol1).setValue(tempA);
				
		}
		else;
	}
	
	void subNode(int inRow1, int inCol1, int inRow2, int inCol2, int outRow1, int outCol1){
		if(validateNode(inRow1, inCol1) && validateNode(inRow2, inCol2) && validateNode(outRow1, outCol1)){
			Value tempA = new Value();
			tempA = findNode(inRow1, inCol1).getValue().minus(findNode(inRow2, inCol2).getValue());
			if(tempA.getTag().equals("INVALID"));//do not assign
			else
				findNode(outRow1, outCol1).setValue(tempA);
				
		}
		else;
	}
	
	void mulNode(int inRow1, int inCol1, int inRow2, int inCol2, int outRow1, int outCol1){
		if(validateNode(inRow1, inCol1) && validateNode(inRow2, inCol2) && validateNode(outRow1, outCol1)){
			Value tempA = new Value();
			tempA = findNode(inRow1, inCol1).getValue().star(findNode(inRow2, inCol2).getValue());
			if(tempA.getTag().equals("INVALID"));//do not assign
			else
				findNode(outRow1, outCol1).setValue(tempA);
				
		}
		else;
	}
	
	void divNode(int inRow1, int inCol1, int inRow2, int inCol2, int outRow1, int outCol1){
		if(validateNode(inRow1, inCol1) && validateNode(inRow2, inCol2) && validateNode(outRow1, outCol1)){
			Value tempA = new Value();
			tempA = findNode(inRow1, inCol1).getValue().slash(findNode(inRow2, inCol2).getValue());
			if(tempA.getTag().equals("INVALID"));//do not assign
			else
				findNode(outRow1, outCol1).setValue(tempA);
				
		}
		else;
	}
	//It would be faster to not use find, but this took like 5 minutes to write
	//and is so much more compact.
	void addCol(int inCol1, int inCol2, int outCol1){
		for(int i = 0; i < rows; i++)
		addNode(i, inCol1, i, inCol2, i, outCol1);
	}
	void subCol(int inCol1, int inCol2, int outCol1){
		for(int i = 0; i < rows; i++)
		subNode(i, inCol1, i, inCol2, i, outCol1);
	}
	void mulCol(int inCol1, int inCol2, int outCol1){
		for(int i = 0; i < rows; i++)
		mulNode(i, inCol1, i, inCol2, i, outCol1);
	}
	void divCol(int inCol1, int inCol2, int outCol1){
		for(int i = 0; i < rows; i++)
		divNode(i, inCol1, i, inCol2, i, outCol1);
	}
	void addRow(int inRow1, int inRow2, int outRow1){
		for(int i = 0; i < cols; i++)
		addNode(i, inRow1, i, inRow2, i, outRow1);
	}
	void subRow(int inRow1, int inRow2, int outRow1){
		for(int i = 0; i < cols; i++)
		subNode(i, inRow1, i, inRow2, i, outRow1);
	}
	void mulRow(int inRow1, int inRow2, int outRow1){
		for(int i = 0; i < cols; i++)
		mulNode(i, inRow1, i, inRow2, i, outRow1);
	}
	void divRow(int inRow1, int inRow2, int outRow1){
		for(int i = 0; i < cols; i++)
		divNode(i, inRow1, i, inRow2, i, outRow1);
	}
}