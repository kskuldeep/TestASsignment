package test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.moneycorp.base.TestBase;
import com.moneycorp.pages.HomePage;
import com.moneycorp.pages.SearchResultPage;

public class HomePageTest extends TestBase{
	HomePage home;
	SearchResultPage result;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		intialization();
		home=new HomePage();
		result=new SearchResultPage();
	}
	@Test(priority=1)
	public void languageChange() {
	home.languageSelection();
	}
	@Test(priority=2)
	public void articletestcase() {
		home.foreignArticle();
	}
	@Test(priority=3)
	public void validateArticleUrl() {
		String url=home.Url();
		Assert.assertEquals(url, "https://www.moneycorp.com/en-us/business/foreign-exchange-solutions/");	
	
	}
	@Test(priority=4)
	public void search() {
		home.searchBox("international payment");
	}
	
	@Test(priority=5)
	public void validateResult() {
		String resultUrl=result.url();
		Assert.assertEquals(resultUrl, "https://www.moneycorp.com/en-us/search/?q=international+payment");
	}
	@Test(priority=6)
	public void linksTestcase() {
		List<WebElement> element=driver.findElements(By.tagName("a"));
		int i=element.size();
		for(int j=0; j<i; j++) {
			System.out.println(element.get(j).getAttribute("href"));
		if(element.get(j).getAttribute("href").contains("https://www.moneycorp.com/en-us"))	{
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		}

			

	}
}
