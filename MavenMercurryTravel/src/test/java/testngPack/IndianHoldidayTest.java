package testng;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenShot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass


public class IndianHoldidayTest{ 
    
             WebDriver driver=null;
             @BeforeClass
             public void launchingBrowser(){
                         System.getProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
                         driver=new ChromeDriver();
                         driver.get("https://www.mercurytravels.co.in/");
                         driver.manage().window().maximize();
                         WebDriverWait wait=new WebDriverWait(driver,30);
                         try{
                              wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id="modalPopup"]/div/div/div[1]/button/span")));
                              driver.findElement(By.xpath("//*[@id="modalPopup"]/div/div/div[1]/button/span")).click();

                         }
                         catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");}           

             }

            @Test
            public void enterIndianHolidayData(){
                          
                        driver.findElement(By.xpath("//*[@id="bs-example-navbar-collapse-1"]/ul/li[2]/a")).click();
                        try{
                              wait.until(ExpectedConditions.presenceOfElementLocated(By.id("holiday_category_id")));
                              driver.findElement(By.id("holiday_category_id")).sendKeys("Mumbai");}
                        catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");}
                        
                        try{
                              wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-id-7"));
                               driver.findElement(By.id("ui-id-7")).click();}
                        catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");}
                        WebElement dur= driver.findElement(By.id("duration_d")).click();
                        Select duration=new Select(dur);
                        duration.selectByVisibleText("3Nights+4Days");
                        driver.findElement(By.xpath("//*[@id="dom_auto_comp_param"]/div/div/div/div[3]/button")).click();
                        try{
                     
                             wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id="totalcount"]")));
                             WebElement availPack=findElement(By.xpath("//*[@id="totalcount"]"));
                             if(availPack.getText().equals("0")){System.out.println("available packagesis 0.Verified ");}
                            }
                        
                        catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");}
                       
            }

}