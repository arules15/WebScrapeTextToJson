package webscrape;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;



public class TextToJson {
	public void convertToJson() throws IOException {
		String name = "C:\\Users\\Abdul\\Documents\\courses0.txt";
		File file = new File(name);
		//Scanner used to read file
		Scanner input = new Scanner(file);
		//PrintWriter used to write to file
		PrintWriter printWriter = new PrintWriter(new FileWriter("C:\\Users\\Abdul\\Documents\\courseJson.txt"));
		while (input.hasNextLine()) {
		    String line = input.nextLine();
		    /*split each line at the / pertaining to the seperator of faculty and department,
		    data is in the form FACULTY/DEPARTMENT COURSENAME, only split once, hence the 2 limit*/
		    String part[] = line.split("/", 2);
		    //dummy array to avoid parsing "/" in course descriptions
		    String dummy[] = {};
		    if(line.startsWith("[")) {
		    	part = dummy;
		    }
		    if(line.equals("[N/A]")) {
		    	/*(do nothing) kek, actually need to create a }
		    	if there is no description, simply close the json object*/
		    	System.out.println("}");
		    	printWriter.println("}");
		    }
		    else if (part.length == 2) {
		    	/*if part is an array of size 2 (here is where the dummy comes into good use)
		    	then it means were looking at a line with course name and department, so output
		    	as following*/
		    	String parts[] = part[1].split("\\s");// get the department name
		    	System.out.println("{" + "\n" + "\"Department\": " + "\"" + parts[0] + "\", " + "\n" +
		    	"\"Course\": " + "\"" +  part[1] + "\", ");
		    	printWriter.println("{" + "\n" + "\"Department\": " + "\"" + parts[0] + "\", " + "\n" +
				    	"\"Course\": " + "\"" +  part[1] + "\", ");
		    } else if(line.startsWith("[")) {
		    	//if line starts with '[' means we are looking at a description, output as shown below
		    	System.out.println("\"Description\": " + "\"" + line + "\", " + "\n" + "}");
		    	printWriter.println("\"Description\": " + "\"" + line + "\", " + "\n" + "}");
		    }
		}
		input.close();
		printWriter.close();
	}
	
	public static void main(String[] args) throws IOException{
		TextToJson a = new TextToJson();
		a.convertToJson();
	}
}
