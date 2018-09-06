package zapAndroid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UploadToStoreController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    AllApplication allApplication;


    @RequestMapping("/uploadToStore")
    public UploadToStore uploadToStore(@RequestParam(value="name", defaultValue="Android_Build") String name) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\niprajapati\\Desktop\\Main Folder\\ws\\chromedriver.exe");
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
