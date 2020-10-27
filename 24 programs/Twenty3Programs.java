package implementation;
//Week2 Homework Problems
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;

public class Homework {
	public static void main(String[] args) {
		
		
		//HelloWorld(); //#1
		//addTwo(); //#2
		//operators(); //#3
		//calculate(); //#4 , Redo following 10/2/2020 class.
		//mult(); //#5
		//divisibility(); //#6
		//kMaxArray(); //#7
		//tempConvert(); //#8
		//daysOfMonth(); //#9
		//sortArray(); //#10
		//maxMinValues(); //#11
		//compareString(); //#12
		//getMonth(); //#13
		//countVowels(); //#14
		//countStrings(); //#15
		//listFiles(); //#16
		//writeFile(); //#17
		//arrayList(); //#18
		//hashMapIterator(); #19
		//bubbleSort(); //#20
		//binarySearch(); //#21
		//linearSearch(); //#22
		fibonacciNumbers(); //#23
	}
	
	//1. Write a Java program that prints 'Hello' on the console and then prints your name on a separate line.
	public static void HelloWorld() {
		System.out.println("Hello\n"+"Veronica Gonzalez");
	}
	
	//2. Write a Java program that prints the sum of two numbers.
	public static void addTwo() {
		Scanner input = new Scanner(System.in);
		int x=0 , y= 0, sum=0;
		
		System.out.print("Enter an integer for x: ");
		x=input.nextInt();
		System.out.print("Enter an integer for y: ");
		y=input.nextInt();
		
		sum = x+y;
		System.out.print("Sum of the two numbers are: "+sum);
		
		input.close();
	}
	
	//3. Write a Java program that prints the result of the following operations.
	public static void operators() {
		int a=-5+8*6;
		int b=(55+9)%9;
		int c=20+-3*5/8;
		int d= 5+15/3*2-8%3;
		System.out.println("a. Result of operation, -5+8*6 = "+a);
		System.out.println("b. Result of operation, (55+9)%9 = "+b);
		System.out.println("c. Result of operation, 20+-3*5/8 = "+c);
		System.out.println("d. Result of operation, 5+15/3*2-8%3 = "+d);
	}
	
	//4. Complete the logic of the Calculate method that we developed in class to account for the missed conditions for the multiplication, division and subtraction.
	public static void calculate() {
		Scanner input = new Scanner(System.in);
		int x=0 , y= 0;
		float div=0;
		
		//Get user input for x and y.
		System.out.print("Enter an integer for x: ");
		x=input.nextInt();
		System.out.print("Enter an integer for y: ");
		y=input.nextInt();
		
		//Calculate subtraction, multiplication, division
		div=(float)x/y;
		
		System.out.println("Results for subtraction: "+Math.subtractExact(x, y));
		System.out.println("Result for multiplication: "+Math.multiplyExact(x,y));
		System.out.println("Results for division: "+div);
		
		input.close();
	}
	
	//5. Write a Java program that takes a number as input and prints its multiplication table (up to a length of 10). 
	public static void mult() {
		int res=0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int x=input.nextInt();
		for(int i=0;i<10;i++) {
			res=x*(i+1);
			System.out.println(x+" x "+(i+1)+" = "+res);
		}
		input.close();
	}
	
	//6. Write a Java program that prints the numbers between 1 and 100 which are divisible by 3 and/or 5.
	public static void divisibility() {
		for(int i=1; i<101;i++) {
			if(i%3==0 || i%5==0)
				System.out.println("The number between 1 and 100 which is divisible by 3 and/or 5: "+i);
		}
	}
	
	//7. Write a Java program that finds the k largest elements in a given array. 
	public static void kMaxArray() {
		int[] arr = {1,4,17,7,25,3,100}; 
		int largestThree=0;
		
		Arrays.sort(arr);
		for(int k=0;k<3;k++) { 
			largestThree = arr.length-(k+1);
		  	System.out.println(arr[largestThree]);
		}
	}
	
	//8. Write a Java program that converts temperatures from Fahrenheit to Celsius. 
	public static void tempConvert() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter temperature in Fahrenheit: ");
		int tempFahr = input.nextInt();
		float tempCels = (float)tempFahr-32;
		tempCels = (float) (tempCels/1.8);

		System.out.println(tempFahr+" degrees Fahrenheit = "+tempCels+ " in Celsius.");
		
		input.close();
	}
	
	//9. Write a Java program that finds the number of days in a month. 
	public static void daysOfMonth() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a month number: ");
		int month = input.nextInt();
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		
		int numberOfDays=0;
		
		switch(month) {
		case 1:
			numberOfDays=31;
			System.out.println("January "+year+" has "+numberOfDays+" days.");
			break;
		case 2:
			if(((year%4 == 0) && (year%100 != 0)) || (year%400 == 0))
					numberOfDays=29;
			else numberOfDays=28;
			System.out.println("February "+year+" has "+numberOfDays+" days.");
			break;
		case 3:
			numberOfDays=31;
			System.out.println("March "+year+" has "+numberOfDays+" days.");
			break;
		case 4:
			numberOfDays=30; 
			System.out.println("April "+year+" has "+numberOfDays+" days.");
			break;
		case 5:
			numberOfDays=31;
			System.out.println("May "+year+" has "+numberOfDays+" days.");
			break;
		case 6:
			numberOfDays=30;
			System.out.println("June "+year+" has "+numberOfDays+" days.");
			break;
		case 7:
			numberOfDays=31;
			System.out.println("July "+year+" has "+numberOfDays+" days.");
			break;
		case 8:
			numberOfDays=31;
			System.out.println("August "+year+" has "+numberOfDays+" days.");
			break;
		case 9:
			numberOfDays=30;
			System.out.println("September "+year+" has "+numberOfDays+" days.");
			break;
		case 10:
			numberOfDays=31;
			System.out.println("October "+year+" has "+numberOfDays+" days.");
			break;
		case 11:
			numberOfDays=30;
			System.out.println("November "+year+" has "+numberOfDays+" days.");
			break;
		case 12:
			numberOfDays=31;
			System.out.println("December "+year+" has "+numberOfDays+" days.");
			break;
		default: 
			System.out.println("Invalid Month.");
			
		input.close();
		}
	}
	
	//10. Write a Java program that sorts a numeric array and a string array
	public static void sortArray() {
		int[] arr = {2,16,9,5,13,10,4};
		String[] strArr= {"Apple", "String", "Zebra", "Dance", "Fog", "Cup", "Coffee"};
		System.out.println("Contents of integer array: {2,16,9,5,13,10,4}");
		System.out.println("Contents of integer array: {\"Apple\", \"String\", \"Zebra\", \"Dance\", \"Fog\", \"Cup\", \"Coffee\"}");
		
		Arrays.sort(arr);
		System.out.print("Sorted integer array: ");
		for(int i=0; i<arr.length;i++) 
			System.out.printf(arr[i]+" ");
			
		Arrays.sort(strArr);
		System.out.print("\nSorted String array elements: ");
		System.out.printf(Arrays.toString(strArr)+" ");
	}
	
	//11. Write a Java program that finds the maximum and minimum value of an array
	public static void maxMinValues() {
		int[] arr = {2,16,9,5,13,10,4};
		System.out.println("Contents of integer array: {2,16,9,5,13,10,4}");
		
		Arrays.sort(arr);
		int min=arr[0];
		int max=arr[arr.length-1];
		System.out.println("Min Value: "+min+"\nMax Value: "+max);
	}
	
	//12. Write a Java program that compares a given string to the specified string buffer.
	public static void compareString() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a String to compare to \"example.com\": ");
		String str = input.nextLine();
		
		StringBuffer s = new StringBuffer("example.com");
		//StringBuffer does not override equals method. Have to convert to string.
		String str2 = s.toString(); 
		
		boolean compare=str.equals(str2);
		System.out.println(str+" compared to \"example.com\": "+compare);
		
		input.close();
	}
	//13.Write a Java program that gets the information of the current/given month
	public static void getMonth() {
		LocalDate current = LocalDate.now();
		//Month
		int currentMonth = current.getMonthValue();
		System.out.println("Integer value of the current month: "+currentMonth);
		//Days
		int days = current.lengthOfMonth();
		System.out.println("Length of month: "+days);
		
		//max days in month
		Month month = Month.OCTOBER;
		int maxDays=month.maxLength();
		System.out.println("Maximum length of month: "+maxDays);
		System.out.println("First month of the Quarter: "+month.firstMonthOfQuarter());
		
	}
	
	//14. Write a Java method that counts all the vowels in a string
	public static void countVowels() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String str = input.nextLine();
		int count=0;
		char vowel;
		for(int i=0; i<str.length();i++) {
			vowel=(char)str.charAt(i);
			if(vowel=='a'||vowel=='e'||vowel=='i'||vowel=='o'||vowel=='u'||vowel=='A'||vowel=='E'||vowel=='I'||vowel=='O'||vowel=='U')
				count++;
		}
		System.out.println("Number of Vowels in the string: "+count);
		input.close();
	}
	
	//15:Write a Java method that counts all words in a string
	public static void countStrings() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a String: ");  //The quick brown fox jumps over the lazy dog.
		String str = input.nextLine();
		String[] words = str.split("\\s"); //split by whitespace("\\s")into substrings.
		
		int count=words.length;
		System.out.println("There are "+count+" words in the string.");
		
		input.close();
	}
	//16. Write a Java program that gets a list of all the names of the files/directories that exist under a directory (ex: C://Documents)
	public static void listFiles() {
		
		String [] files= {};
		try {
			File fileObj = new File("C:\\Users\\Vero\\Documents");
			files=fileObj.list();
			for(int i=0;i<files.length;i++)
				System.out.println(files[i]);
		}
		catch(Exception file) {
			System.out.println("File Path error, cannot read files.");
			file.printStackTrace();
		}
	}
	//17. Write a Java program that writes and reads a plain text file. 
	public static void writeFile() {
		try {
			FileWriter writerObj = new FileWriter("src/newfile.txt");
				writerObj.write("Writing to my new file.");
				writerObj.close();
				System.out.println("Writing to new file completed.");
		}catch(IOException file) {
			System.out.println("Error, cannot write to file.");
			file.printStackTrace();
		}
	}
	
	//18: Write a Java program that iterates through all elements in a array list.
	public static void arrayList() {
		List<Integer> list = Arrays.asList(1,6,3,5,7,8,2,9);
		for(int i=0; i<list.size();i++)
			System.out.println("element "+i+" in array list: "+list.get(i));
	}
	
	//19: Write a Java program that iterates through all elements in a hash map.
	public static void hashMapIterator() {
		HashMap<String, Integer> dogs = new HashMap<String, Integer>();
		//add items to dogs hashmap
		dogs.put("shihtzu", 300);
		dogs.put("chihuahua",100);
		dogs.put("Maltese",400);
		dogs.put("bulldog",800);
		
		System.out.println("Hash Map named dogs: "+dogs);
		Iterator <?>nextHash = dogs.entrySet().iterator();
		
		int price=0;
		//Iterate through the hash map.
		while(nextHash.hasNext()) {
			Map.Entry<String, Integer> element = (Map.Entry)nextHash.next();
			price = (int)element.getValue();
			System.out.println(element.getKey()+" = $"+price);
		}
	}
	
	//20. Write a Java program that sorts an array of given integers using the Bubble Sort
	public static void bubbleSort() {
		int[] arr = {2,16,9,5,13,10,4};
		System.out.println("Contents of integer array: {2,16,9,5,13,10,4}");
		
		int temp=0;
		for(int i=0; i<arr.length-1;i++) {
			for(int j=0; j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					//swap
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		//Print sorted array.
			System.out.printf("Bubble sorted array: "+Arrays.toString(arr));
	}
	
	//21. Write a Java program that finds a specified element in a given array of elements using Binary Search. 
	public static void binarySearch() {
		int[] arr = {2,16,9,5,13,10,4};
		System.out.println("Contents of integer array: {2,16,9,5,13,10,4}");
		
		Arrays.sort(arr);
		System.out.println("Sorted array: "+Arrays.toString(arr));
		
		int value=13;
		
		int returnValue = Arrays.binarySearch(arr, value);
		
		System.out.println("Searching for index of integer 13 using binarySearch: "+returnValue);
	}
	//22. Write a Java program that finds a specified element in a given array of elements using Linear Search. 
	public static void linearSearch() {
		int[] arr = {2,16,9,5,13,10,4};
		System.out.println("Contents of integer array: {2,16,9,5,13,10,4}");
		
		int keyElement = 10;
		System.out.println("Searching for key integer 10 using linear search.");
		int keyIndex=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==keyElement)
				keyIndex=i;
		}
		if(keyIndex==0)
			System.out.print("key integer not found.");
		else 
			System.out.print("key integer found at index: "+keyIndex);	
	}
	
	//23. Create a java program that creates Fibonacci numbers then write unit tests to check the correct/incorrect behaviors
	public static ArrayList<Integer> fibonacciNumbers() {
		int n=8;
		int firstNum=0;
		int secondNum=1;
		int sum=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			System.out.print(firstNum+" + ");
			list.add(firstNum);
			sum=firstNum + secondNum;
			firstNum = secondNum;
			secondNum=sum;
		}
		return list;
	}
	
}

