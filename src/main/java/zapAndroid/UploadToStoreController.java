package zapAndroid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.RestController;

import util.APILoginAndStore;
import util.Variables;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UploadToStoreController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    AllApplication allApplication;
    String strLoginURL="http://198.58.98.34:4350/api/user/login";
    String strLoginUsername="pradip@zaptechsolutions.com";
    String strLoginPassword="pradip123#";
    String strListURL="http://198.58.98.34:4350/api/publish/list";
    APILoginAndStore st;
    public boolean isAPIResult=false;
    Variables var;

    @RequestMapping(path="/uploadToStore")
    public UploadToStore uploadToStore(@RequestParam(value="username", defaultValue="Android_Build") String username,@RequestParam(value="password", defaultValue="Android_Build") String password) throws InterruptedException, IOException {

    	System.out.println(username+":"+password);
       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
       
       // API call
       st=new APILoginAndStore();
       var =st.jsonLogin(strLoginUsername,strLoginPassword,strLoginURL,strListURL);
      // System.out.println(st.v.getApplication_primary_language_1());
       System.out.println(st.v.getApplication_name());
       System.out.println(st.v.getApplication_phone());
       System.out.println(st.v.getApplication_email_address());
       System.out.println(st.v.getApplication_icon());
       
        // Chrome driver setup
        WebDriver driver = new ChromeDriver();
        LoginGoogle lg=new LoginGoogle(driver,strLoginURL,strLoginUsername,strLoginPassword);
        boolean isLogin=lg.login();
        if(isLogin) {
   
      
        allApplication=new AllApplication(driver);
        allApplication.CreatingApplication(st.v);
        allApplication.uploadingAPK();
        return new UploadToStore(counter.incrementAndGet(),
                String.format(template, "Passed"));
        }
        return new UploadToStore(counter.incrementAndGet(),
                String.format(template, "failed"));
    }
    @RequestMapping("/greetings")
    public UploadToStore greetings(@RequestParam(value="name", defaultValue="World") String name){
        return new UploadToStore(counter.incrementAndGet(),
                String.format(template, name));
    }

}
