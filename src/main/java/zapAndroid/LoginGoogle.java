package zapAndroid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginGoogle extends Driver {
    @FindBy(xpath="//input[@id='identifierId']")
    WebElement userName;
    @FindBy(xpath="//span[contains(text(),'Next')]/../..")
    WebElement nextButton;
    @FindBy(xpath="//input[@aria-label='Enter your password'] | //input[@name='password'] | //input[@type='password']")
    WebElement password;
    String strConsoleURL="https://play.google.com/apps/publish";
    @FindBy(xpath="//button[contains(.,'Create application')]")
    WebElement createApplicationButton;

    Properties pr=new Properties();
    InputStream in;






    public LoginGoogle(WebDriver wd){

        super(wd);


    }
    public AllApplication login() throws InterruptedException, IOException {
        in=new FileInputStream("property.properties");
        pr.load(in);
        wd.get("https://play.google.com/apps/publish");
        Thread.sleep(5);

        userName.sendKeys(pr.getProperty("android_user_name"));
        nextButton.click();
        Thread.sleep(5);
        WebDriverWait wait=new WebDriverWait(wd,10);
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(password));
        we.sendKeys(pr.getProperty("android_password"));
        nextButton.click();
        Thread.sleep(20);

        //wd.navigate().to(strConsoleURL);
        System.out.println("Out put");
        return new AllApplication(wd);

    }
    public void tearDown(){
        //wd.close();
    }
}
