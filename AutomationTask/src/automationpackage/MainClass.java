package automationpackage;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {


    public static void main(String[] args) {
    	
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	String baseUrl = "http://www.google.com";
        boolean found=false;

        // launch Google Chrome and direct it to the Base URL
        driver.get(baseUrl);
        
        // find search box by name
        WebElement searchBox = driver.findElement(By.name("q"));
        
        // type Bloxico in search box
        searchBox.sendKeys("Bloxico");
        
        //find Search button by name
        WebElement button = driver.findElement(By.name("btnK"));
        
        //wait for button to be clickable
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       
        //click on the Google Search button
        button.click();
        
        //wait for the results page to load
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //find a list of all links on google results page
        List<WebElement> links = driver.findElements(By.tagName("cite"));
        
        if(links.size() != 0)   {
        	
        //goes through all List elements and searches for https://bloxico.com
 		   for(WebElement inputElement : links)  {
 			   if(inputElement.getText().equals("https://bloxico.com")) 
 			   	found=true;   
 		   }
 		   //displays the test result
 		   if (found) System.out.println("Test passed ! \nhttps://bloxico.com exists on a Google page");
 		   else System.out.println("Test failed ! \nhttps://bloxico.com doesn't exist on a Google page");
 	   }
       
        //close Google Chrome 
        driver.close();
       
    }

}

