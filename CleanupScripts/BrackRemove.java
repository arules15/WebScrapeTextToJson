package webscrape;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;



public class BrackRemove {
	public void removeBrack() throws IOException {
		String name = "C:\\Users\\Abdul\\Documents\\courseJson.txt";
		File file = new File(name);
		//Scanner used to read file
		Scanner input = new Scanner(file);
		//PrintWriter used to write to file
		PrintWriter printWriter = new PrintWriter(new FileWriter("C:\\Users\\Abdul\\Documents\\noBracks.txt"));
		BufferedReader buff = new BufferedReader(new FileReader(file));
		while (input.hasNextLine()) {
		    String line = input.nextLine();
		    /*split each line at the / pertaining to the seperator of faculty and department,
		    data is in the form FACULTY/DEPARTMENT COURSENAME, only split once, hence the 2 limit*/
		    if (line.contains("[") || line.contains("]")) {
		    	String lines = line.substring(0, 16);
		    	String lines2 = line.substring(17, line.length() - 2);
		    	String lines3 = line.substring(line.length() -1, line.length());
		    	System.out.println(lines + lines2 + lines3 );
		    	printWriter.println(lines + lines2 + lines3 );
		    }
		    else {
		    	System.out.println(line );
		    	printWriter.println(line );
		    }
//		    String line2 ="";
//		    if(line.contains("Description") && line.contains(",")) {
//		    	line2 = line.substring(0, line.length()-2) + line.substring(line.length());
//		    	System.out.println(line2);
//		    	printWriter.println(line2);
//		    }else {
//		    	System.out.println(line);
//		    	printWriter.println(line);
//		    }
//		}
		}
		input.close();
		printWriter.close();
	}
	
	public static void main(String[] args) throws IOException{
		BrackRemove a = new BrackRemove();
		a.removeBrack();
	}
}
