package com.StepDefinition;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;



public class LoginSteps {
	WebDriver driver;
	String appurl = "https://www.swiggy.com";
	

	@Given("Navigate to the landing page of Swiggy")
	public void navigate_to_the_landing_page_of_Swiggy() {
		System.out.println("Launch browser");
		System.out.println("User already in login page");
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver(); // Assign to the class-level variable
		driver.manage().window().maximize();
		driver.get(appurl);

		// Verify Home page
		String title = driver.getTitle();
		System.out.println("Home Page Title::" + title);
		AssertJUnit.assertEquals("Order food online from India's best food delivery service. Order from restaurants near you", title);

	}

	@When("Enter location as Mumbai")
	public void enter_location_as_Mumbai() throws InterruptedException {
		driver.findElement(By.id("location")).sendKeys("Mumbai");
		Thread.sleep(1000);
	}

	@Then("Redirect to the ItemPage")
	public void redirect_to_the_ItemPage() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='Mumbai, Maharashtra, India']")).click();
		// Verify Item page
		String title = driver.getTitle();
		System.out.println("Item Page Title::" + title);
		AssertJUnit.assertEquals("Order food online from India's best food delivery service. Order from restaurants near you", title);
		Thread.sleep(3000);
	}
	
	@And("Hover over search icon")
	public void hover_over_search_icon_and_Enter_Item_as_Pizza() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='Search']")).click();
		Thread.sleep(2000);
	}
	
	@Then("Enter Item as Pizza and search")
	public void enter_Item_as_Pizza_and_search() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search for restaurants and food']")).sendKeys("Pizza");
		Thread.sleep(2000);
		// pressing enter key of the keyboard
		Actions actions = new Actions(driver);
		actions. sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
	}
	
	@When("Search resturant and select Pizza Hut")
	public void search_resturant_and_select_first_restaurant() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Restaurants')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Pizza Hut')]")).click();
		Thread.sleep(2000);
	}
	
	@And("Redirect to orderPage and order Margherita")
	public void redirect_to_orderPage() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='icon-magnifier']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search in Pizza Hut']")).sendKeys("Margherita");
		Thread.sleep(2000);
	}
	
	@Then("Add one Margherita to cart")
	public void add_one_Margherita_to_cart() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@class='_1RPOp'][normalize-space()='ADD'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(normalize-space(),'Continue')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(normalize-space(),'Continue')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(normalize-space(),'Add Item')]")).click();
		Thread.sleep(2000);
		//double click action
//		Actions act = new Actions(driver);
//		WebElement ele = driver.findElement(By.xpath("(//span[@class='_1W_TH'])[1]"));
//		act.doubleClick(ele).perform();
//		Thread.sleep(2000);
			
	}
	
	@When("Click on Cart button")
	public void click_on_checkout_button() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='Cart']")).click();
		Thread.sleep(5000);
//		WebElement elem = driver.findElement(By.xpath("//a[contains(@href,'/checkout')]"));
//		Actions builder = new Actions(driver);
//		builder.moveToElement(elem).perform();
//		Thread.sleep(3000);
		
	}
	@Then("Verify Checkout page is loaded correctly")
	public void verify_Checkout_page_is_loaded_correctly() {
		WebElement pageTitleElement = driver.findElement(By.xpath("(//span[@class='_2EQ3T'])[1]"));
        Assert.assertTrue(pageTitleElement.isDisplayed(), "Checkout page title is not displayed");
	}
}
