package com.definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.baseclass.BaseClass;
import com.pojo.AmazonPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition extends BaseClass{
	AmazonPojo ap;
	
	@Given("User launches the browser and loads the url")
	public void user_launches_the_browser_and_loads_the_url() {
	   
	launchBrowser();
	launchUrl("https://www.amazon.in");
	}

	@When("User verifies the home page and type on search box for product")
	public void user_verifies_the_home_page_and_type_on_search_box_for_product() {
	  ap=new AmazonPojo();
	  
	//Scanner sc=new Scanner(System.in);
	//System.out.println("Enter the product name to be searched");
	//String pdtName = sc.nextLine();
	type(ap.getSearchBox(),"iphone");
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	   
	ap=new AmazonPojo();
	
	btnClick(ap.getSearchButton());
	}

	@Then("User verifies the result page")
	public void user_verifies_the_result_page() {
	
		//switching to child window
		
		String ParWin = driver.getWindowHandle();
		Set<String> AllWin = driver.getWindowHandles();
		for (String string : AllWin) {
			if(!(ParWin==string))
			{
				driver.switchTo().window(string);
			}
				
		}
		List<Integer> l=new LinkedList<>();
		List<WebElement> pdtPriceList = driver.findElements(By.xpath("//span[contains(@class,'a-price-whole')]"));
	for (WebElement webElement : pdtPriceList) {
	String text = webElement.getText();
	System.out.println(text);	
	String replace = text.replace(",", "");
	int price = Integer.parseInt(replace);
	
	if(price<50000)
	{	
	l.add(price);	
	}
	}
	System.out.println(l);
	Object[] array = l.toArray();
	
	Arrays.sort(array);
	for (int i = 0; i < array.length; i++) {
		System.out.println(array[i]);
	}
		}
	

	@Given("User launches the browsee and load the myntra url")
	public void user_launches_the_browsee_and_load_the_myntra_url() {
	launchBrowser();
	launchUrl("https://myntra.com");
	
	}

	@When("User verifies the home page")
	public void user_verifies_the_home_page() {
	    String title = driver.getTitle();
	    boolean b = title.contains("Online Sho");
	    
	}

	@When("User moves on to men module and chooses tshirt category")
	public void user_moves_on_to_men_module_and_chooses_tshirt_category() {
	    Actions a=new Actions(driver);
	    WebElement mod = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
	    a.moveToElement(mod).perform();
	    WebElement cate = driver.findElement(By.xpath("(//a[text()='T-Shirts'])[1]"));
	    cate.click();
	}

	@Then("User verifies the tshirt result page")
	public void user_verifies_the_tshirt_result_page() {
	    
		List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		List<Integer> l=new ArrayList<>();
		int priceint=0;
		for (WebElement webElement : pricelist) {
			String text = webElement.getText();
			System.out.println(text);
			String substring = text.substring(4);
			priceint = Integer.parseInt(substring);
			
			
			l.add(priceint);
			
		}
		
		System.out.println(l);
		
		Set<Integer> s=new TreeSet<>();
		s.addAll(l);	
		System.out.println(s);
	
		int dup=l.size()-s.size();
	System.out.println("duplicate count: "+dup);
		
	}


	
	}



