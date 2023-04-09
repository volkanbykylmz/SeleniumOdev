package kitapyurdu.driver;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    public static WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications"); // Bildirimleri devre dışı bırakır
        chromeOptions.addArguments("--disable-extensions"); // Eklentileri devre dışı bırakır
        chromeOptions.addArguments("--disable-infobars"); // Bilgi çubuklarını devre dışı bırakır
        chromeOptions.addArguments("--disable-save-password-bubble"); // "Parolaları kaydet" uyarısını devre dışı bırakır
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(chromeOptions);
        //driver.manage().window().setPosition(new Point(0,0));
        //driver.manage().window().setSize(new Dimension(1024,500));
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser","Chrome 11");
        caps.setCapability("os","Windows");
        chromeOptions.merge(caps);
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();
        String browser = (String) caps.getCapability("browser");
        String os = (String) caps.getCapability("os");

        //System.out.println(pageTitle);
        //System.out.println(browser);
        //System.out.println(os);
        driver.get("https://www.kitapyurdu.com/");
    }


   // @After
    public void tearDown(){
        if(driver!= null){
            driver.close();
            driver.quit();
        }
    }
}
