package zapAndroid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Driver {
     public WebDriver wd=null;

	public Driver(WebDriver wd) {
    	this.wd=wd;
        PageFactory.initElements(wd,this);
    }
}
