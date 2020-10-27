/*
 * Test Case1: Login
 * Test Case2: Login with credentials from properties file
 * Test Case3: Login with credentials from excel 
 * Test Case4: Login with two different users with same test case
 * Test Case5: Login_error, blank username and password
 * Test Case6: Login_error, forgot password and enter blank username
 * Test Case7: Get all links and print and click each link
 * Test Case8: Verify Dropdown for Manufacturer
 * Test Case 9: Create an account
 * Test Case10: Buy a product
 */
package com.platform.project.tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert; 
import org.testng.annotations.*; 
public class Week3Homework {

	static WebDriver driver;
	public static String catalogUrl =("http://107.170.213.234/catalog/index.php");
	
	//@BeforeTest
	public static void launchBrowser() {
			System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe");
			driver= new ChromeDriver();
			driver.get(catalogUrl);
		} 

	public static void closeBrowser() {
		driver.close();
	}
	
	@Test 
	public void testCase1() { 
		launchBrowser();
		logyourselfLink();
		login("vgonzalez275@gmail.com", "Agile#2020");
		checkHomePage();
		logOff();
		closeBrowser();
	}
	
	@Test 
	public void testCase2() {
		launchBrowser();
		logyourselfLink();
		properties();
		checkHomePage();
		logOff();
		closeBrowser();
	}
	
	@Test	
	public void testCase3() {
		launchBrowser();
		logyourselfLink();
		propertiesExcel();
		checkHomePage();
		logOff();
		closeBrowser();
	}
	
	@Test
	public void testCase4() {
		launchBrowser();
		logyourselfLink();
		login("vgonzalez275@gmail.com", "Agile#2020");
		checkHomePage();
		logOff();
		logyourselfLink();
		login("justagile@test.com", "test123");
		checkHomePage();
		logOff();
		closeBrowser();
	}
	@Test	
	public void testCase5() {
		launchBrowser();
		logyourselfLink();
		login(" ", " ");
		errorMessage();
		closeBrowser();
	}
    
	@Test
	public void testCase6() {
		launchBrowser();
		logyourselfLink();
		forgotPasswordError(" ");
		closeBrowser();
	}	

	@Test
	public void testCase7() {
		launchBrowser();
		getPageLinks();
		closeBrowser();
	}
	
	@Test
	public void testCase8() {
		launchBrowser();
		manufacturersDropDownMenu();
		closeBrowser();
	}

	@Test
	public void testCase9() {
		launchBrowser();
		createAccount("javalane@gmail", "Javatest123"); //takes email and password as parameters.
		closeBrowser();
	}
	
	public static void checkHomePage() {
		WebElement titleElement = driver.findElement(By.xpath("//div[@id='bodyContent']//h1"));
		Assert.assertEquals(titleElement.getText(), "Welcome to iBusiness");
	}

	public static void createAccount(String email, String password) {
		WebElement createAccountLink = driver.findElement(By.xpath("//u[contains(text(),'create an account')]"));
		createAccountLink.click();
		
		WebElement genderRadioButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[2]"));
		genderRadioButton.click();
		
		WebElement firstNameBox = driver.findElement(By.name("firstname"));
		firstNameBox.sendKeys("Jane");
		
		WebElement lastNameBox = driver.findElement(By.name("lastname"));
		lastNameBox.sendKeys("Doe");
		
		WebElement dobBox = driver.findElement(By.name("dob"));
		dobBox.sendKeys("08/20/1986");
		
		WebElement emailBox = driver.findElement(By.name("email_address"));
		emailBox.sendKeys(email);
		
		WebElement companyBox = driver.findElement(By.name("company"));
		companyBox.sendKeys(" ");
		
		WebElement addressBox = driver.findElement(By.name("street_address"));
		addressBox.sendKeys("1234 temp way");
		
		WebElement suburbBox = driver.findElement(By.name("suburb"));
		suburbBox.sendKeys(" ");
		
		WebElement postcodeBox = driver.findElement(By.name("postcode"));
		postcodeBox.sendKeys("95821");
		
		WebElement cityBox = driver.findElement(By.name("city"));
		cityBox.sendKeys("temptown");
		
		WebElement stateBox = driver.findElement(By.name("state"));
		stateBox.sendKeys("CA");
		
		WebElement countryBox = driver.findElement(By.name("country"));
		countryBox.click();
		countryBox.sendKeys("United States");
		countryBox.click();
		
		WebElement telephoneBox = driver.findElement(By.name("telephone"));
		telephoneBox.sendKeys("999-234-5678");
		
		WebElement faxBox = driver.findElement(By.name("fax"));
		faxBox.sendKeys(" ");
		
		WebElement passwordBox = driver.findElement(By.name("password"));
		passwordBox.sendKeys(password);
		
		WebElement confirmBox = driver.findElement(By.name("confirmation"));
		confirmBox.sendKeys(password);
		
		WebElement contButton = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
		contButton.click();
		
		try {
			WebElement confirmationText = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
			Assert.assertEquals(confirmationText.getText(), "Your Account Has Been Created!");
			System.out.println("Account has been created successfully.");
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Error creating account or account already exists.");
		}
		
	}
	
	//@Test 
	public static void logyourselfLink() {
		//checkHomePage();
		//click log yourself in link
		WebElement logYourselfLink = driver.findElement(By.xpath("//u[contains(text(),'log yourself in')]"));
		logYourselfLink.click();
	}
//	@Test
	public static void login(String username, String passwrd) {
		
		//find login text box & input email address
		WebElement loginEmail = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		loginEmail.sendKeys(username);
		                                 
		//find password text box & input password
		WebElement password = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]"));
		password.sendKeys(passwrd);
		
		WebElement signInButton= driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"));
		signInButton.click();
		
	}
	
	public static void manufacturersDropDownMenu() {
		WebElement dropDownMenu = driver.findElement(By.name("manufacturers"));
		dropDownMenu.click();
		
		List<WebElement> menu = driver.findElements(By.tagName("option"));
		//To use the list I need to create a constructor.
		String[] arr = {"Please Select","Canon","Fox", "GT Interactive", "Hewlett Packard", "Logitech", "Matrox", "Microsoft", "Samsung", "Sierra", "Warner", "U.S. Dollar", "Euro"};
		List<String> actualList = new ArrayList<String>();
		List<String> expectedList = Arrays.asList(arr);
		
		int numOfElements = menu.size();
		for(int i=0;i<numOfElements;i++) {
			String name = menu.get(i).getText();
			actualList.add(name);
			System.out.println(name);
		}

		//*************verify each value in the menu list******************
		Assert.assertEquals(actualList,expectedList);
	}
	
	
	public static void logOff() {
		WebElement signOutButton = driver.findElement(By.xpath("//span[contains(text(),'Log Off')]"));
		signOutButton.click();
		WebElement continueButton =  driver.findElement(By.xpath("//a[@id='tdb4']")); 
		continueButton.click();
		
	}
	
	public static void errorMessage() {
		WebElement errorText = driver.findElement(By.xpath("//body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]"));
		//Assert.assertFalse(condition, message);
		Assert.assertEquals(errorText.getText(), " Error: No match for E-Mail Address and/or Password.");
	}
	
	public static void getPageLinks() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		List<String> hrefs = new ArrayList<String>();
		for(WebElement link: links) {
			hrefs.add(link.getAttribute("href"));
			String linkName = link.getText();
			System.out.println(linkName);
		}
		try {
			for(String hr: hrefs)
				driver.get(hr);
		}catch(NullPointerException er) {
			System.out.println("Null Pointer Exception");
		}
	}
	
	public static void forgotPasswordError(String emailAddress) {
		WebElement forgotPasswrdLink = driver.findElement(By.xpath("//a[contains(text(),'Password forgotten? Click here.')]"));
		forgotPasswrdLink.click();
		WebElement emailBox = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		emailBox.sendKeys(emailAddress);
		WebElement continueButton = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
		continueButton.click();
		WebElement forgotPasswrdError = driver.findElement(By.xpath("//body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]"));
		Assert.assertEquals(forgotPasswrdError.getText(), " Error: The E-Mail Address was not found in our records, please try again.");
	}
	
//@Test	
	public static void properties() {
		
		FileInputStream readInfo = null;
		
		try {
			File fileObj = new File("./src/test/java/com/platform/project/tests/config.properties");
			readInfo = new FileInputStream(fileObj);
		}catch(FileNotFoundException e) {
			System.out.println("Error in reading file");
			e.printStackTrace();
		}
		
		Properties propData = new Properties();
		
		//get properties information
		try {
			propData.load(readInfo);
		}catch(IOException error) {
			error.printStackTrace();
		}
		
		//String url = propData.getProperty("catalogUrl");
		String username = propData.getProperty("username");
		String passwrd = propData.getProperty("password");
		
		//find login text box & input email address from properties file
		WebElement loginEmail = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		loginEmail.sendKeys(username);
				
		//find password text box & input password from properties file
		WebElement password = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]"));
		password.sendKeys(passwrd);
		
		WebElement signInButton= driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"));
		signInButton.click();
		
//		System.out.println("URL: "+url);
//		System.out.println("Username: "+username);
//		System.out.println("Password: "+passwrd);
}
//	@Test
	public static void propertiesExcel() {
		ArrayList<String> usernameCol = new ArrayList<String>();
		ArrayList<String> passwordCol = new ArrayList<String>();
		ArrayList<String> urlCol = new ArrayList<String>();
		
		Scanner read = null;
		//Open file, catch exception for no file
				String data;
				String[] dataArray= {};
			
				try {
					File fileObj = new File("./src/test/java/com/platform/project/tests/data.csv");
					read = new Scanner(fileObj);
					while (read.hasNextLine()) {
						
						data =read.nextLine();
						dataArray=data.split(",");
						
						usernameCol.add(dataArray[0]);
						passwordCol.add(dataArray[1]);
						urlCol.add(dataArray[2]);
					}
				}catch(FileNotFoundException e) {
					System.out.println("Error in reading file");
					e.printStackTrace();
				}	 
				//find login text box & input email address from properties file
				WebElement loginEmail = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
				loginEmail.sendKeys(usernameCol.get(1));
						
				//find password text box & input password from properties file
				WebElement password = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]"));
				password.sendKeys(passwordCol.get(1));
				
				WebElement signInButton= driver.findElement(By.xpath("//span[contains(text(),'Sign In')]"));
				signInButton.click();
					
	}
	

}
