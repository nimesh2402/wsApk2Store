package util;

import java.util.concurrent.TimeUnit;

import org.apache.commons.validator.routines.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils{
	public WebDriver wd;
	public Wait<WebDriver> fluentWait;

	public CommonUtils(WebDriver wd) {
		
		this.wd=wd;
		// TODO Auto-generated constructor stub
	}
	public String fullPath(String strFileName) {
		
		return "";
	}
	public boolean isURLValid(String strURL) {
		
		UrlValidator urlValidator =new UrlValidator();
		return urlValidator.isValid(strURL);
	}
	public boolean waitForElementToAppear(WebElement element) {
		boolean webElementPresence = false;
		try {
			fluentWait = new FluentWait<WebDriver>(wd).pollingEvery(2, TimeUnit.SECONDS)
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
	public boolean waitForElementToAppearAndClickable(WebElement element) {
		boolean webElementPresence = false;
		try {
			fluentWait = new FluentWait<WebDriver>(wd).pollingEvery(2, TimeUnit.SECONDS)
					.withTimeout(60, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				fluentWait.until(ExpectedConditions.elementToBeClickable(element));
				webElementPresence= true;
			}
		} catch (TimeoutException toe) {
			
		} catch (Exception e) {
				}
		return webElementPresence;
	}
	public boolean waitToAppearIsClickableAndMove(WebElement element) {
		boolean webElementPresence = false;
		try {
			fluentWait = new FluentWait<WebDriver>(wd).pollingEvery(2, TimeUnit.SECONDS)
					.withTimeout(60, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				fluentWait.until(ExpectedConditions.elementToBeClickable(element));
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
				webElementPresence= true;
			}
		} catch (TimeoutException toe) {
			
		} catch (Exception e) {
				}
		return webElementPresence;
	}
	public boolean waitToAppearAndMove(WebElement element) {
		boolean webElementPresence = false;
		try {
			fluentWait = new FluentWait<WebDriver>(wd).pollingEvery(2, TimeUnit.SECONDS)
					.withTimeout(60, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
				webElementPresence= true;
			}
		} catch (TimeoutException toe) {
			
		} catch (Exception e) {
				}
		return webElementPresence;
	}
	public  WebElement isElementAvailable(WebDriver driver) {
        return new WebDriverWait(driver, 10)

        .until(new ExpectedCondition<WebElement>() {

              @Override

              public WebElement apply(WebDriver d) {

                     return d.findElement(By.id("fk-top-search-box"));

              }

        });
		
	}
	

}
