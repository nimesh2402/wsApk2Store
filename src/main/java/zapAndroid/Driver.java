package zapAndroid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Driver {
     protected static WebDriver wd=null;

    @SuppressWarnings("static-access")
	public Driver(WebDriver wd) {
    	this.wd=wd;
        PageFactory.initElements(wd,this);
    }
}
