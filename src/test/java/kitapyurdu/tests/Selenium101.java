package kitapyurdu.tests;

import kitapyurdu.driver.BaseTest;
import kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Selenium101 extends BaseTest {

    @Test
    public void test(){
        Methods methods = new Methods();

        //login
        methods.waitClick(By.xpath("//*[@class='menu-top-button login']"));
        methods.sendKeys(By.id("login-email"),"volkan.buyukyilmaz@testinium.com");
        methods.sendKeys(By.id("login-password"),"182318231823");
        methods.waitBySeconds(3);
        methods.waitClick(By.id("js-popup-accept-button"));//çerezleri kabul et
        methods.waitBySeconds(3);
        methods.waitClick(By.xpath("//button[@class='ky-btn ky-btn-orange w-100 ky-login-btn']"));
        methods.waitBySeconds(3);

        //login assert
        Assert.assertTrue(methods.getText(By.xpath("//*[@class='menu top login']//*[@class='common-sprite']")).contains("Merhaba"));

        //search
        methods.sendKeys(By.id("search-input"),"Oyuncak");
        methods.waitClick(By.xpath("//*[@class='common-sprite button-search']"));

        //favories add
        methods.scrollWithAction(By.xpath("(//*[@id='product-table']//*[@class='product-cr'])[7]"));
        methods.waitBySeconds(3);
        methods.waitClick(By.xpath("(//*[@id='product-table']//*[@class='product-cr'])[4]//*[@class='hover-menu']//*[@class='add-to-favorites']"));
        methods.waitBySeconds(3);
        methods.waitClick(By.xpath("(//*[@id='product-table']//*[@class='product-cr'])[5]//*[@class='hover-menu']//*[@class='add-to-favorites']"));
        methods.waitBySeconds(3);
        methods.waitClick(By.xpath("(//*[@id='product-table']//*[@class='product-cr'])[6]//*[@class='hover-menu']//*[@class='add-to-favorites']"));
        methods.waitBySeconds(3);
        methods.waitClick(By.xpath("(//*[@id='product-table']//*[@class='product-cr'])[7]//*[@class='hover-menu']//*[@class='add-to-favorites']"));
        methods.waitBySeconds(3);

        //select category
        methods.waitClick(By.xpath("//*[@class='logo-text']//img"));
        methods.waitBySeconds(1);
        methods.waitClick(By.xpath("//*[@class='lvl1catalog']//a"));
        methods.waitClick(By.xpath("//*[@class='landing-block']//a[2]//img"));

        //filter
        methods.selectByText(By.xpath("//*[@class='sort']//select"),"Yüksek Oylama");
        methods.waitBySeconds(1);

        //to hobi
        methods.scrollWithAction(By.xpath("(//*[@class='mn-strong common-sprite'])[3]"));
        methods.waitBySeconds(1);
        methods.waitClick(By.xpath("//a[contains(text(),'Hobi')]"));
        methods.waitBySeconds(1);

        //random selection of products
        int random = methods.random();
        methods.scrollWithAction(By.xpath("(//*[@class='mg-b-10'])["+random+"]"));
        methods.waitClick(By.xpath("(//*[@class='mg-b-10'])["+random+"]//i[@class='fa fa-shopping-cart']"));
        methods.waitBySeconds(1);
        methods.waitClick(By.xpath("//*[@id='sprite-cart-icon']"));

        //to favories
        methods.scrollWithAction(By.xpath("//*[@class='menu top my-list']"));
        methods.waitBySeconds(2);
        methods.waitClick(By.xpath("//*[@class='menu top my-list']//div//ul//li//a"));
        methods.waitBySeconds(1);

        //third thr product is deleted
        methods.scrollWithAction(By.xpath("//*[@class='product-cr'][3]"));
        methods.waitClick(By.xpath("//*[@class='product-cr'][3]//*[@class='hover-menu']//a[@data-title='Favorilerimden Sil']"));
        methods.waitBySeconds(1);

        //to product cart
        methods.scrollWithAction(By.xpath("//*[@id='cart']"));
        methods.waitClick(By.xpath("//*[@id='cart']"));
        methods.waitClick(By.xpath("//*[@id='cart-content']//*[@class='checkout fl']//div//a"));
        methods.waitBySeconds(1);

        //add product
        driver.findElement(By.xpath("//tbody//tr//td[@class='quantity']//input")).clear();
        methods.waitBySeconds(3);
        methods.sendKeys(By.xpath("//tbody//tr//td[@class='quantity']//input"),"5");
        methods.waitClick(By.xpath("//tbody//tr//td[@class='quantity']//i"));

        //buy
        methods.waitBySeconds(10);
        methods.scrollWithAction(By.xpath("//div[@class='buttons']//a[contains(text(),'Satın')]"));
        methods.waitClick(By.xpath("//div[@class='buttons']//a[contains(text(),'Satın')]"));

        //new information
        methods.waitBySeconds(5);
        methods.waitClick(By.xpath("//a[contains(text(),'Yeni bir adres kullanmak istiyorum.')]"));

        //user information
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-firstname-companyname"),"Volkan");
        methods.sendKeys(By.id("address-lastname-title"),"Volkan");
        methods.selectByText(By.id("address-zone-id"),"İstanbul");
        methods.waitBySeconds(3);
        methods.selectByText(By.xpath("//*[@id='address-county-id']"),"BAHÇELİEVLER");
        methods.sendKeys(By.id("address-address-text"),"asdfghjklşi");
        methods.sendKeys(By.id("address-mobile-telephone"),"5123456789");
        methods.waitBySeconds(2);
        methods.waitClick(By.id("button-checkout-continue"));
        methods.waitBySeconds(5);
        methods.waitClick(By.id("button-checkout-continue"));

        //error message
        methods.sendKeys(By.xpath("//input[@id='credit-card-owner']"),"TEST OTOMASYON");
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@id='credit_card_number_1']"),"0000111122223333");
        methods.waitBySeconds(2);
        methods.selectByText(By.xpath("//select[@id='credit-card-expire-date-month']"),"05");
        methods.waitBySeconds(2);
        methods.selectByText(By.xpath("//select[@id='credit-card-expire-date-year']"),"2025");
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@id='credit-card-security-code']"),"123");
        methods.waitBySeconds(2);
        methods.waitClick(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
        Assert.assertEquals("Kart numarası geçersiz. Kontrol ediniz!",driver.findElement(By.xpath("(//*[@data-group='credit-card-inputs'])[4]//span")).getText());
        methods.waitBySeconds(2);

        //logout
        methods.waitClick(By.xpath("//*[@class='checkout-logo']"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//*[@class='menu top login']//ul//li//a"));
        methods.waitBySeconds(2);
        methods.waitClick(By.xpath("//*[@class='menu top login']//ul//li//div//ul//li[4]//a"));

    }

}
