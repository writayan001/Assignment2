package SeleniumPack;


import java.util.concurrent.TimeUnit;
import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenShot;
import

public class ScreenShot {

static WebDriver driver;
public static void main(String[] args) {
	System.setProperty("https://www.mercurytravels.co.in/");
	driver = new ChromeDriver();
	driver.get("https://demo.opencart.com/");
	driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id="modalPopup"]/div/div/div[1]/button/span")).click();
        driver.windows().timeouts.implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id="bs-example-navbar-collapse-1"]/ul/li[8]/a")).click();
        WebDriverWait wait= new WebDriverWait(driver,30);
        Action action= new Actions(driver);
        try{
             wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id="bs-example-navbar-collapse-1"]/ul/li[8]/ul/li[3]/a")));
             action.moveToElement(driver.findElement(By.xpath("//*[@id="bs-example-navbar-collapse-1"]/ul/li[8]/ul/li[3]/a"))).click().build().perform();
             if(driver.getCurrentUrl.equals("https://www.mercurytravels.co.in/foreign-exchange/products")){System.out.println("Verified url")}
             else{System.out.println("Not Verified ");}
             TakesScreenShot ts=(TakesScreenShot)driver;
             File file= ts.getScreenShot(OutputType.FILE);
             FileUtils.copyFile(file,new File(System.getProperty("user.dir")+"/Screenshots/file.png"));

             Thread.sleep(3000);
             driver.close();

        }
        catch(NoSuchElementException e){
                System.out.println("No such Element Found");
            }