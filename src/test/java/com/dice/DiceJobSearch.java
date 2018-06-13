package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {
		
		
		//setting up chrome driver path
		//same as:
		System.setProperty("webdriver.chrome.driver", "/Users/mustakilali/Documents/Selenium Dependencies/drivers/chromedriver");
		//WebDriverManager.chromedriver().setup();
		//invoking selenium webdriver
		WebDriver driver = new ChromeDriver();
		//fullscreen 
		driver.manage().window().fullscreen();
		//set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		 // Step 1. Launch browser and navigate to https://dice.com 
				// - Expected: dice home page should be displayed 
		 String url = "https://dice.com";
		 driver.get(url);
		 String actualTitle = driver.getTitle();
		 String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		 
		 if (actualTitle.equals(expectedTitle)) {
			 System.out.println("Loaded Successfully");
		 } else {
			 System.out.println("Loaded Unsuccessfully");
			 throw new RuntimeException("WebPage Not Loaded Successfully");
		 }
		 
		 String keyword = "java developer";
		 driver.findElement(By.id("search-field-keyword")).clear();
		 driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		 
		 String zipCode = "20190";
		 driver.findElement(By.id("search-field-location")).clear();
		 driver.findElement(By.id("search-field-location")).sendKeys(zipCode);
		 
		 driver.findElement(By.id("findTechJobs")).click();
		 
		 String count = driver.findElement(By.id("posiCountId")).getText();
		 System.out.println(count);
		 
		 int countResult = Integer.parseInt(count.replace(",", ""));
		 
		 if (countResult > 0) {
			 System.out.println("Step PASS: Keyword: " + keyword + " search returned " + countResult + " results in " + zipCode);
		 } else
				 System.out.println("Step FAIL: Keyword: " + keyword + " search returned " + countResult + " results in " + zipCode);
		 
		 driver.close();
		}
		
		 
		 
		
	}

