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


    @RequestMapping("/uploadToStore")
    public UploadToStore uploadToStore(@RequestParam(value="name", defaultValue="Android_Build") String name) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        LoginGoogle lg=new LoginGoogle(driver);
        allApplication=lg.login();

        allApplication.CreatingApplication();
        allApplication.uploadingAPK();
        return new UploadToStore(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping("/greetings")
    public UploadToStore greetings(@RequestParam(value="name", defaultValue="World") String name){
        return new UploadToStore(counter.incrementAndGet(),
                String.format(template, name));
    }

}
