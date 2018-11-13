package zapAndroid;

import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import okio.Timeout;
import util.APILoginAndStore;
import util.CommonUtils;
import util.Variables;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllApplication extends Driver {

    @FindBy(xpath="//button[contains(.,'Create application')]")
    WebElement createApplicationButton;

    @FindBy(xpath="//div[normalize-space(.)='Title']/following-sibling::div//input")
    WebElement titleofTheApp;

    @FindBy(xpath="//h3//following-sibling::footer/button[contains(.,'Create')]")
    WebElement finallyCreate;

    @FindBy(xpath="//p[contains(normalize-space(.),'Short description')]/../following-sibling::*//textarea")
    WebElement weShortDescription;
  
    @FindBy(xpath="//p[contains(normalize-space(.),'Full description')]/../following-sibling::*//textarea")
    WebElement weFullDescription;

    @FindBy(xpath="//div[contains(text(),'Add at least one phone screenshot here to help phone users see how your app will look on their device.')]/following-sibling::button")
    WebElement browse;
    //div[normalize-space(.)='Title']/following-sibling::div//input
    @FindBy(xpath="(//div[contains(text(),'Browse files')]/../preceding-sibling::div[1]/parent::div)[1]")
    WebElement backGroundofBrowse;

    @FindBy(xpath="//input[@type='file'][@style='display: table; height: 40px; position: absolute;']")
    WebElement browseMain;
    @FindBy(xpath="//input[@type='file'][@style='display: table; height: 40px; position: absolute;']")
    List<WebElement> lstbrowseMain;

    @FindBy(xpath="(//div[contains(text(),'Browse files')]/../preceding-sibling::div)[1]")
    WebElement addAtLeastOne;

    @FindBy(xpath="//p[text()='Add high-res icon']/../../../following-sibling::input")
    WebElement browseHiResolution512;
    @FindBy(xpath="//p[text()='Add high-res icon']/../../../following-sibling::input")
    List<WebElement> lstbrowseHiResolution512;

    @FindBy(xpath="//p[text()='Add high-res icon']")
    WebElement moveToElementbrowseHiResolution512;

    @FindBy(xpath="//p[text()='Add feature graphic']/../../../following-sibling::input")
    WebElement browseFeatureGraphic1024;
    @FindBy(xpath="//p[text()='Add feature graphic']/../../../following-sibling::input")
    List<WebElement> lstbrowseFeatureGraphic1024;

    @FindBy(xpath="//p[text()='Add feature graphic']")
    WebElement moveToElementbrowseFeatureGraphic1024;
    
    String strDropDown="//div[starts-with(text(),'SELECT')]/..";
    String strDropDownValue="//div[contains(@role,'option')][contains(text(),'VALUE')]";

    String strDropDownCategory="//div[normalize-space(.)='Category']/following-sibling::div/div/div[starts-with(.,'SELECT')]";
    @FindBy(xpath="//div[normalize-space(.)='Category']")
    WebElement strCategory;

    @FindBy(xpath="//div[normalize-space(.)='Privacy Policy']/following-sibling::div//input[@placeholder='http://...']")
    WebElement privacyPolicyTextBox;

    @FindBy(xpath="//button[contains(.,'Save draft')]")
    WebElement saveDraft;

    @FindBy(xpath="//span[contains(.,'Your application has been saved.')]")
    WebElement draftedSuccessfully;

    @FindBy(xpath="//span[contains(.,'App releases')]")
    WebElement AppReleaselink;

    @FindBy(xpath="//header//div[starts-with(.,'App releases')]")
    WebElement headerofRelease;

    @FindBy(xpath="//h3[contains(.,'Beta')]/following-sibling::div/button")
    WebElement betaManagelink;

    @FindBy(xpath="//div[normalize-space(.)='Create release']/following-sibling::button")
    WebElement createReleasebutton;

    @FindBy(xpath="//h3[contains(.,'App signing by Google Play')]")
    WebElement PreReleaseHeader;

    @FindBy(xpath="//div[normalize-space(.)='Continue']/..")
    WebElement PreReleaseconditnue;

    @FindBy(xpath="//p[(text()=' Enabled ')]")
    WebElement enabled;

    @FindBy(xpath="//input[@type='file'][@style='display: table; height: 40px; position: absolute; visibility: visible;']")
    WebElement apkUpload;


    public void uploadingAPK(){
        AppReleaselink.click();
        WebDriverWait wait=new WebDriverWait(wd,30);
        wait.until(ExpectedConditions.elementToBeClickable(headerofRelease));
        betaManagelink.click();
        wait.until(ExpectedConditions.elementToBeClickable(createReleasebutton));
        createReleasebutton.click();
        wait.until(ExpectedConditions.elementToBeClickable(PreReleaseHeader));
        PreReleaseconditnue.click();
        wait.until(ExpectedConditions.elementToBeClickable(enabled));
        //js.executeAsyncScript("arguments[0].setAttribute('style', arguments[1]);", backGroundofBrowse, "opacity:1;");
       if(jsExecution(lstbrowseMain,"document.getElementsByTagName('input')[10].style='display: table;height: 40px;position: absolute;visibility: visible;'")){
           apkUpload.sendKeys("C:\\Users\\niprajapati\\Desktop\\Main Folder\\ws\\app-release.apk");
        }
    }

    CommonUtils commonUtil;
    public AllApplication(WebDriver wd){

        super(wd);
        commonUtil=new CommonUtils(wd);

    }
    public void CreatingApplication(Variables v) throws InterruptedException, MalformedURLException, IOException {

        v.getApplication_banner();
        commonUtil.waitForElementToAppear(createApplicationButton);
    	WebDriverWait wait=new WebDriverWait(wd,30);
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(createApplicationButton));
        commonUtil.waitForElementToAppear(createApplicationButton);
        we.click();
        WebElement weTitleofTheApp=wait.until(ExpectedConditions.elementToBeClickable(titleofTheApp));
        weTitleofTheApp.sendKeys(v.getApplication_name());
        Thread.sleep(5);
        finallyCreate.click();

       
        
        WebDriverWait ww= new WebDriverWait(wd,60);
        ww.until(ExpectedConditions.visibilityOf(addAtLeastOne));
        weShortDescription.sendKeys(v.getApplication_short_description());
        weFullDescription.sendKeys(v.getApplication_full_description());
        Actions ac=new Actions(wd);
        ac.moveToElement(addAtLeastOne).build().perform();
        Thread.sleep(5);
        System.out.println("URL: "+v.getApplication_phone_screens()[0].toString());
        
        org.apache.commons.io.FileUtils.copyURLToFile(new URL(v.getApplication_phone_screens()[0].toString()),new File("C:\\Users\\incapsulate\\git\\wsApk2Store\\res\\main.jpeg"),10000,10000);
        
        //js.executeAsyncScript("arguments[0].setAttribute('style', arguments[1]);", backGroundofBrowse, "opacity:1;");
        if(jsExecution(lstbrowseMain,"document.getElementsByTagName('input')[4].style='display: table;height: 40px;position: absolute;'")){
            browseMain.sendKeys("C:\\Users\\incapsulate\\git\\wsApk2Store\\res\\main.jpeg");
        }
        Thread.sleep(5);
        //ac.moveToElement(moveToElementbrowseHiResolution512).build().perform();

        org.apache.commons.io.FileUtils.copyURLToFile(new URL(v.getApplication_icon().toString()),new File("C:\\Users\\incapsulate\\git\\wsApk2Store\\res\\icon.jpeg"),10000,10000);
        
        // 512X512
        if(jsExecution(lstbrowseHiResolution512,"document.getElementsByTagName('input')[9].style='display: table;height: 40px;position: absolute;'")){

            ac.moveToElement(browseHiResolution512).build().perform();
            browseHiResolution512.sendKeys("C:\\Users\\incapsulate\\git\\wsApk2Store\\res\\icon.jpeg");
        }
        
        org.apache.commons.io.FileUtils.copyURLToFile(new URL(v.getApplication_banner().toString()),new File("C:\\Users\\incapsulate\\git\\wsApk2Store\\res\\screen.jpeg"),10000,10000);
        
        
        if(jsExecution(lstbrowseFeatureGraphic1024,"document.getElementsByTagName('input')[12].style='display: table;height: 40px;position: absolute;'")){
            ac.moveToElement(browseFeatureGraphic1024).build().perform();
            browseFeatureGraphic1024.sendKeys("C:\\Users\\incapsulate\\git\\wsApk2Store\\res\\screen.jpeg");
        }
        Thread.sleep(200);
        v.getApplication_category();
        v.getApplication_type();
        String strDropDownTemp=strDropDown.replace("SELECT","Select an application type");
        String strDropDownValueTemp=strDropDownValue.replace("VALUE",v.getApplication_type()+"s");
        if(wd.findElements(By.xpath(strDropDownTemp)).size()>0) {
            //ac.moveToElement(wd.findElement(By.xpath(strDropDownTemp))).build().perform();
            Thread.sleep(100);
            JavascriptExecutor js=(JavascriptExecutor)wd;
            WebElement h3 = wd.findElement(By.xpath("//h3[contains(text(),'Categorization')]"));

            WebElement weDropDown1 = wd.findElement(By.xpath(strDropDownTemp));
            js.executeScript("arguments[0].scrollIntoView(true);", h3);
            Thread.sleep(100);
            weDropDown1.click();
            WebElement weDropDownValue = wd.findElement(By.xpath(strDropDownValueTemp));

            weDropDownValue.click();
        }
        Thread.sleep(50);
        String strDropDownTempCategory=strDropDownCategory.replace("SELECT","Select a category");
        String strDropDownValueTempCategory=strDropDownValue.replace("VALUE",v.getApplication_category());
        if(wd.findElements(By.xpath(strDropDownTempCategory)).size()>0) {
            //ac.moveToElement(wd.findElement(By.xpath(strDropDownTempCategory))).build().perform();
            JavascriptExecutor js=(JavascriptExecutor)wd;

            WebElement weDropDown1 = wd.findElement(By.xpath(strDropDownTempCategory));
           // js.executeScript("arguments[0].scrollIntoView(true);", strCategory);
            ww.until(ExpectedConditions.elementToBeClickable(weDropDown1));
            weDropDown1.click();
            Thread.sleep(5000);
            WebElement weDropDownValue = wd.findElement(By.xpath(strDropDownValueTempCategory));
            //s.executeScript("arguments[0].scrollIntoView(true);", weDropDownValue);
            ww.until(ExpectedConditions.elementToBeClickable(weDropDownValue));
            weDropDownValue.click();
            Thread.sleep(500);
        }
        privacyPolicyTextBox.sendKeys("http://zaptechsolutions.com");

        saveDraft.click();

        ww.until(ExpectedConditions.visibilityOf(draftedSuccessfully));

    }


    public void tearDown(){
        //wd.close();
    }
    public boolean jsExecution(List<WebElement> lstWebElement,String str){
        JavascriptExecutor js=(JavascriptExecutor)wd;
        wd.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        boolean bl=true;
        int counter=0;
        while(bl) {
            counter++;
            System.out.println(counter);
            try {
                js.executeAsyncScript(str);

            } catch (Exception e) {

            }
            if(lstWebElement.size()<0){
                if(counter==3) {

                    bl = false;
                    break;
                }
            }
            else {
                break;
            }

        }
        return bl;
    }

}
