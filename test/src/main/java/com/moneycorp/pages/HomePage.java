package com.moneycorp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneycorp.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//button[@id='language-dropdown-flag']")
	WebElement languageDropDown;
	
	@FindBy(xpath="//span[text()= 'USA']")
	WebElement languageSelections;
	
	@FindBy(xpath ="//body/section[1]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement foreignFindoutmore;
	
	@FindBy(xpath="//header/div[2]/div[1]/div[3]/button[1]")
	WebElement SearchBox;
	
	@FindBy(xpath="//input[@id='nav_search']")
	WebElement searchInput;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String pageTitleValidate() {
	return driver.getTitle();
	}

	public void languageSelection() {
		languageDropDown.click();
		languageSelections.click();	
	}
	public ForeignArticlePage foreignArticle() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		foreignFindoutmore.click();
		return new ForeignArticlePage();
		
	}
	
	public String Url() {
		return driver.getCurrentUrl();
		 
	}
	
	public SearchResultPage searchBox(String input) {
		SearchBox.click();
		searchInput.sendKeys(input);
		searchInput.sendKeys(Keys.ENTER);
		return new SearchResultPage();
		}
	

}
