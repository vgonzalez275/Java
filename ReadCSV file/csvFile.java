import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class csvFile {
	public static void main(String[] args) {
		
		ArrayList<String> column1 = new ArrayList<String>();
		ArrayList<String> column2 = new ArrayList<String>();
		ArrayList<String> column3 = new ArrayList<String>();
		ArrayList<String> column4 = new ArrayList<String>();
		
		//Open file, catch exception for no file
		String data;
		String[] dataArray= {};
		try {
			File fileObj = new File("src/Data.csv");
			Scanner reader = new Scanner(fileObj);
			 
			while (reader.hasNextLine()) {
				data =reader.nextLine();
				dataArray=data.split(",");
				
				column1.add(dataArray[0]);
				column2.add(dataArray[1]);
				column3.add(dataArray[3]);
				column4.add(dataArray[4]);
			}
			System.out.println("Data in column 1: "+column1);
			System.out.println("Data in column 2: "+column2);
			System.out.println("Data in column 3: "+column3);
			System.out.println("Data in column 4: "+column4);
			
			reader.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		}
	}
}
