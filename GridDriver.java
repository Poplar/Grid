import java.util.*;
import java.io.*;
public class GridDriver {
	public static void main(String[] args){
	Scanner console = new Scanner(System.in);
	int row1,col1,row2,col2,row3,col3; //temp variables to execute methods
	Grid grid = new Grid();
	String input = "", value = "";
	
	while(!input.equals("q")){

		System.out.println("Operations");
		System.out.println("  display           dis         assign cell       as");
		System.out.println("  fill              f           number            n");
		System.out.println("  add cells         a           subtract cells    s");
		System.out.println("  multiply cells    m           divide cells      d");
		System.out.println("  add rows          ar          subtract rows     sr");
		System.out.println("  multiply rows     mr          divide rows       dr");
		System.out.println("  add columns       ac          subtract columns  sc");
		System.out.println("  multiply columns  mc          divide columns    dc");
		System.out.println("  insert row        ir          insert column     ic");
		System.out.println("  delete row        delr        delete column     delc");
		System.out.println("  quit              q");
		System.out.print("-> ");
		input = console.next();
//		System.out.println(" "); LOTS OF COPYING AND PASTING
		switch(input){
			case "dis":
				grid.print();
				break;
			case "f":
				System.out.print("from row: ");
				row1 = console.nextInt();
				System.out.print("from column: ");
				col1 = console.nextInt();
				System.out.print("to row: ");
				row2 = console.nextInt();
				System.out.print("to column: ");
				col2 = console.nextInt();
				System.out.print("with value: ");
				value = console.next();
				grid.fill(row1, col1, row2, col2, value);
				break;
			case "n":
				System.out.print("from row: ");
				row1 = console.nextInt();
				System.out.print("from column: ");
				col1 = console.nextInt();
				System.out.print("to row: ");
				row2 = console.nextInt();
				System.out.print("to column: ");
				col2 = console.nextInt();
				grid.number(row1, col1, row2, col2);
				break;
			case "as":
				System.out.print("row:  ");
				row1 = console.nextInt();
				System.out.print("column: ");
				col1 = console.nextInt();
				System.out.print("with value: ");
				value = console.next();
				grid.fill(row1, col1, row1, col1, value);
				break;
			case "a":
				System.out.print("first row:  ");
				row1 = console.nextInt();
				System.out.print("first column: ");
				col1 = console.nextInt();
				System.out.print("second row: ");
				row2 = console.nextInt();
				System.out.print("second column: ");
				col2 = console.nextInt();
				System.out.print("target row: ");
				row3 = console.nextInt();
				System.out.print("target column: ");
				col3 = console.nextInt();
				grid.addNode(row1, col1, row2, col2, row3, col3);
				break;
			case "s":
				System.out.print("first row:  ");
				row1 = console.nextInt();
				System.out.print("first column: ");
				col1 = console.nextInt();
				System.out.print("second row: ");
				row2 = console.nextInt();
				System.out.print("second column: ");
				col2 = console.nextInt();
				System.out.print("target row: ");
				row3 = console.nextInt();
				System.out.print("target column: ");
				col3 = console.nextInt();
				grid.subNode(row1, col1, row2, col2, row3, col3);			
				break;
			case "m":
				System.out.print("first row:  ");
				row1 = console.nextInt();
				System.out.print("first column: ");
				col1 = console.nextInt();
				System.out.print("second row: ");
				row2 = console.nextInt();
				System.out.print("second column: ");
				col2 = console.nextInt();
				System.out.print("target row: ");
				row3 = console.nextInt();
				System.out.print("target column: ");
				col3 = console.nextInt();
				grid.mulNode(row1, col1, row2, col2, row3, col3);
				break;
			case "d":
				System.out.print("first row:  ");
				row1 = console.nextInt();
				System.out.print("first column: ");
				col1 = console.nextInt();
				System.out.print("second row: ");
				row2 = console.nextInt();
				System.out.print("second column: ");
				col2 = console.nextInt();
				System.out.print("target row: ");
				row3 = console.nextInt();
				System.out.print("target column: ");
				col3 = console.nextInt();
				grid.divNode(row1, col1, row2, col2, row3, col3);
				break;
			case "ar":
				System.out.print("first row:  ");
				row1 = console.nextInt();
				System.out.print("second row: ");
				row2 = console.nextInt();
				System.out.print("target row: ");
				row3 = console.nextInt();
				grid.addRow(row1, row2, row3);
				break;
			case "sr":
				System.out.print("first row:  ");
				row1 = console.nextInt();
				System.out.print("second row: ");
				row2 = console.nextInt();
				System.out.print("target row: ");
				row3 = console.nextInt();
				grid.subRow(row1, row2, row3);
				break;
			case "mr":
				System.out.print("first row:  ");
				row1 = console.nextInt();
				System.out.print("second row: ");
				row2 = console.nextInt();
				System.out.print("target row: ");
				row3 = console.nextInt();
				grid.mulRow(row1, row2, row3);
				break;
			case "dr":
				System.out.print("first row:  ");
				row1 = console.nextInt();
				System.out.print("second row: ");
				row2 = console.nextInt();
				System.out.print("target row: ");
				row3 = console.nextInt();
				grid.divRow(row1, row2, row3);
				break;
			case "ac":
				System.out.print("first column: ");
				col1 = console.nextInt();
				System.out.print("second column: ");
				col2 = console.nextInt();
				System.out.print("target column: ");
				col3 = console.nextInt();
				grid.addCol(col1, col2, col3);
				break;
			case "sc":
				System.out.print("first column: ");
				col1 = console.nextInt();
				System.out.print("second column: ");
				col2 = console.nextInt();
				System.out.print("target column: ");
				col3 = console.nextInt();
				grid.subCol(col1, col2, col3);
				break;
			case "mc":
				System.out.print("first column: ");
				col1 = console.nextInt();
				System.out.print("second column: ");
				col2 = console.nextInt();
				System.out.print("target column: ");
				col3	 = console.nextInt();
				grid.mulCol(col1, col2, col3);
				break;
			case "dc":
				System.out.print("first column: ");
				col1 = console.nextInt();
				System.out.print("second column: ");
				col2 = console.nextInt();
				System.out.print("target column: ");
				col3 = console.nextInt();
				grid.divCol(col1, col2, col3);
				break;
			case "ir":
				System.out.print("row: ");
				row1 = console.nextInt();
				grid.insRow(row1);
				break;
			case "ic":
				System.out.print("column: ");
				col1 = console.nextInt();
				grid.insCol(col1);
				break;
			case "delr":
				System.out.print("row: ");
				row1 = console.nextInt();
				grid.delRow(row1);
				break;
			case "delc":
				System.out.print("column: ");
				col1 = console.nextInt();
				grid.delCol(col1);
				break;
			case "q":
				break;
			
		}
	}
	console.close();
	}
}
	
