package util;

import java.util.concurrent.TimeUnit;

import org.apache.commons.validator.routines.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import zapAndroid.Driver;



public class CommonUtils extends Driver {

	public CommonUtils(WebDriver wd) {
		super(wd);
		
		// TODO Auto-generated constructor stub
	}
	public String fullPath(String strFileName) {
		
		return "";
	}
	public boolean isURLValid(String strURL) {
		
		UrlValidator urlValidator =new UrlValidator();
		return urlValidator.isValid(strURL);
	}
	public static boolean waitForElementToAppear(WebElement element) {
		boolean webElementPresence = false;
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(wd).pollingEvery(2, TimeUnit.SECONDS)
					.withTimeout(60, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				webElementPresence= true;
			}
		} catch (TimeoutException toe) {
			
		} catch (Exception e) {
				}
		return webElementPresence;
	}
	

}
