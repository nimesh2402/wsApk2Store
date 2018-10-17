package zapAndroid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UploadToStoreController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    AllApplication allApplication;
    String strLoginURL="http://198.58.98.34:4350/api/user/login";
    String strLoginUsername="pradip@zaptechsolutions.com";
    String strLoginPassword="pradip123#";
    String strListURL="http://198.58.98.34:4350/api/publish/list";

    @RequestMapping("/uploadToStore")
    public UploadToStore uploadToStore(@RequestParam(value="name", defaultValue="Android_Build") String name) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        LoginGoogle lg=new LoginGoogle(driver,strLoginURL,strLoginUsername,strLoginPassword,strListURL);
        boolean isLogin=lg.login();
        if(isLogin) {
        allApplication=new AllApplication(driver);
        allApplication.CreatingApplication();
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
