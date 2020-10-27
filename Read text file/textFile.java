import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*; //to support ArrayList.

public class textFile {
	public static void main(String[] args) {
		//Open file, catch exception for no file
		try {
			File fileObj = new File("src/Credentials.txt");
			Scanner myReader = new Scanner(fileObj);
			
			String data[]= {}; 
			ArrayList<String> pswrdData = new ArrayList<String>();
			ArrayList<String> userName = new ArrayList<String>();
			
			while (myReader.hasNextLine()) {
			
				String fileData = myReader.nextLine();
				data= fileData.split("	");  
				
				//Data structures to store username and password data
				userName.add(data[0]);
				pswrdData.add(data[1]); 
			}
			System.out.println("Username data stored in an Array List: "+userName);
			System.out.println("Password data stored in an Array List: "+pswrdData);
			
			myReader.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		}			
	}
}
