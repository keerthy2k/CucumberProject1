package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class AmazonPojo extends BaseClass{

	public AmazonPojo() {
	
		PageFactory.initElements(driver, this);
		
		}
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	@FindBy(id="nav-search-submit-button")
	private WebElement searchButton;
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	
	
}
