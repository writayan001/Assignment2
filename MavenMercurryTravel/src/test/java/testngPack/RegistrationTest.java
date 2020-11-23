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
import org.testng.annotations.AfterClass;


public class RegistrationTest{ 
    
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
            public void registerUser(){
                         Actions act= new Actions(driver);
                         WebElement customerLogin=driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/a"));
                         act.moveToElement(customerLogin).click().bulid().perform();
                         
                         try{
                              wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/ul/li[2]/a")));
                              WebElement register=driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/ul/li[2]/a"));
                              act.moveToElement(register).click().build().perform();
                         } 
                         catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");} 
                          
                         try{
                              wait.until(ExpectedConditions.presenceOfElementLocated(By.id("acc_first_name"));
                              driver.findElement(By.id("acc_first_name")).sendKeys("Rahul");
                              driver.findElement(By.id("acc_last_name")).sendKeys("Sharma");
                              driver.findElement(By.id("acc_user_email")).sendKeys("Rahul12344321@gmail.com");
                              driver.findElement(By.id("acc_user_password")).sendKeys("password");
                              driver.findElement(By.id("acc_user_passconf")).sendKeys("password");
                              WebElement actForNumType=driver.findElement(By.xpath("//*[@id="modalUserLogin"]/div/div/div[2]/form/select"));
                              Select type=new Select(actForNumType);
                              type.selectByValue("91");
                              driver.findElement(By.id("acc_mobile_no")).sendKeys("9876543210");
                              diver.findElement(By.xpath("//*[@id="modalUserLogin"]/div/div/div[2]/form/button")).click();
                             }
                             catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");}

                             try{
                                  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id="myModalLabel"]");
                                  WebElement status=driver.findElement(By.xpath("//*[@id="myModalLabel"]")); 
                                  if(status.getText().equals("Registration Successful")){System.out.println("Registration verified")}
                                 }
                             catch(NoSuchElementException e)  {System.out.println("Registration unsuccessful");}
                             }
                 
                         
            @AfterClass
            public void CloseBrowser(){
		Thread.sleep(3000);
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
                           

            }

}