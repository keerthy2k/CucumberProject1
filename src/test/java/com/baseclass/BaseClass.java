package com.baseclass;

import java.util.Scanner;

import org.apache.poi.hssf.record.LbsDataSubRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver1;
	
	public void lbw() {
		WebDriverManager.chromedriver().setup();
		driver1=new ChromeDriver();
	}
	
	public void lu(String url) {
		driver1.get(url);
		driver1.manage().window().maximize();

	}
	
	
	public static WebDriver driver;
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
	
	public void launchUrl(String url) {
	driver.get(url);	
	driver.manage().window().maximize();
	}
	
	public void btnClick(WebElement element) {
		element.click();
	}
	
	public void selectFromList(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	public void type(WebElement element,String s) {
		element.sendKeys(s);
	}
	
	public String getAtt(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute; 
	}
	
	public boolean navigationVerify(String string) {
		String title = driver.getTitle();
		boolean b = title.contains(string);
		return b;
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void userInput() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the product name to be searched");
		String pdtName = s.nextLine();
		
	}
	
}
