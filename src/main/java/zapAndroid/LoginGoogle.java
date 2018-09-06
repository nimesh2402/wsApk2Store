package zapAndroid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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






    public LoginGoogle(WebDriver wd){

        super(wd);


    }
    public AllApplication login() throws InterruptedException {
        wd.get("https://play.google.com/apps/publish");
        Thread.sleep(5);

        userName.sendKeys("android@zaptechsolutions.com");
        nextButton.click();
        Thread.sleep(5);
        WebDriverWait wait=new WebDriverWait(wd,10);
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(password));
        we.sendKeys("FH36%$hs90");
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
