package com.moneycorp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneycorp.base.TestBase;

public class ForeignArticlePage extends TestBase {
	
	@FindBy(xpath="//header/div[2]/div[1]/div[3]/button[1]")
	WebElement SearchBox;
	
	@FindBy(xpath="//input[@id='nav_search']")
	WebElement searchInput;

	public ForeignArticlePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public SearchResultPage searchBox(String input) {
	SearchBox.click();
	searchInput.sendKeys(input);
	searchInput.sendKeys(Keys.ENTER);
	return new SearchResultPage();
	}


}
