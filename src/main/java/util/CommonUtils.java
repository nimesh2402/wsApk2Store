package util;

import org.apache.commons.validator.routines.*;
import org.openqa.selenium.WebDriver;

import zapAndroid.Driver;

public class CommonUtils extends Driver {
	WebDriver wd;
	public CommonUtils(WebDriver wd) {
		super(wd);
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
	

}
