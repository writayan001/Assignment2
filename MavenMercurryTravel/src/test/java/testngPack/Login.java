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

import com.project.utils.ExcelReader;

public class Login{
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
      
               @DataProvider
               public Object[][] getLoginData(){
        
               Object[][] data= new data[1][1];
               Hashtable<String,String> rec1= new Hashtable<>();
               rec1.put("userEmail","rahul12344321@gmail.com");
               rec1.put("password","password");
             
               data[0][0]=rec1;
               
               return data;
              }
             
                @Test(dataProvider="getLoginData")
                public void putLoginData(Hashtable<String,String> loginData){
                                      
                         Actions act= new Actions(driver);
                         WebElement customerLogin=driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/a"));
                         act.moveToElement(customerLogin).click().bulid().perform();
                         try{
                              wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/ul/li[1]/a")));
                              WebElement login=driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[1]/ul/li[1]/a"));
                              act.moveToElement(login).click().build().perform();
                         } 
                         catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");}
 
                         try{
                              wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sign_user_email"));
                              driver.findElement(By.id("sign_user_email")).sendKeys(loginData.get("userEmail"));
                              driver.findElement(By.id("sign_user_password")).sendKeys(loginData.get("password"));
                              driver.findElement(By.xpath("//*[@id="modalLogin"]/div/div/div[2]/form/button")).click();}
                         catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");}

                         try{

                              wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[2]/a"));
                              WebElement welcome=driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[2]/a"));
                              if(welcome.getText().equals("Welcome, Rahul")){System.out.println("Verified Login");}
                              else{System.out.println("not verified")}
                             }
                         catch(NoSuchElementException e)  {System.out.println("Not verified");}
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