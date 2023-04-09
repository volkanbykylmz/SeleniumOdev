package kitapyurdu.methods;

import kitapyurdu.driver.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jdDriver;

    public Methods(){
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jdDriver = (JavascriptExecutor) driver;
    }

    public WebElement waitFindElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitClick(By by){
        waitFindElement(by).click();
    }

    public void waitBySeconds(long seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendKeys(By by, String text){
        waitFindElement(by).sendKeys(text);
    }

    public boolean isElementVisible(By by){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void scrollWithAction(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(waitFindElement(by)).build().perform();
    }

    public void keysDownWithAction(int sayi){
        Actions actions = new Actions(driver);
        for (int i = 0; i <sayi ; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        }

    }

    public int random(){
        Random random = new Random();
        int randomNumber = random.nextInt(9) + 1;
        return randomNumber;
    }

    public Select getSelect(By by){
        return new Select(waitFindElement(by));
    }

    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributeName){
        return waitFindElement(by).getAttribute(attributeName);
    }

    public String getText(By by){
      return waitFindElement(by).getText();
    }

    public String getValue(By by){
        return jdDriver.executeScript("return arguments[0].value",waitFindElement(by)).toString();
    }


}
