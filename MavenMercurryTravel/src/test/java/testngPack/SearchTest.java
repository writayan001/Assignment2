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


public class SearchTest{ 
    
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
            public void enterData(){
                      WebElement destination=driver.findElement(By.id("holiday_category_id"))
                      destination.sendKeys("London");
                      try{
                           wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-id-14")));
                           WebElement lon=driver.findElement(By.id("ui-id-14"));
                           lon.click();
                      }

                      catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");} 

                      driver.findElement(By.id("dphh1")).click();
                      Actions action=new Actions(driver);
                      try{
                           wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[15]/div[1]/table/tbody/tr[5]/td[5]")));
                           WebElement 26Nov=driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/tbody/tr[5]/td[5]"));
                           action.moveToElement(26Nov).click().build().perform();
                           Thread.sleep(3000);
                      }
                      catch(NoSuchElementException e)  {System.out.println("No Such ELement Found.");} 
                      WebElement act=driver.findElement(By.id("duration_d"));
                      Select duration= new Select(act);
                      duration.selectByVisibleText("5Nights+6Days");
                      Thread.sleep(3000);
                      WebElement act1=driver.findElement(By.id("themes"));
                      Select typeOfHoliday= new Select(act1);
                      typeOfHoliday.selectByVisibleText("Family");
                      Thread.sleep(3000);
                      driver.findElement(By.xpath("//*[@id="int_auto_comp_param"]/div/div/div[3]/div/div/button")).click();
                     try{
                     
                      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id="totalcount"]")));
                      WebElement availPack=findElement(By.xpath("//*[@id="totalcount"]"));

                      String requiredUrl="https://www.mercurytravels.co.in/international-holidays/london-tour-packages";
                      String currentUrl=driver.getCurrentUrl();
                      if(currentUrl.equals(requiredUrl)){System.out.println("Url and page verified");}
                      else{System.out.println("Verification Unsuccessful");}
                      
                      System.out.println("No. of Packages: "+ availPack.getText());
                      String currentPack=availPack.getText();
                      String expectedPack="0";

                      if(currentPack.equals(expectedPack)){System.out.println("No. of packages Verified");}
                      else{System.out.println("Verification Unsuccessful");}
                      
                      TakesScreenShot ts=(TakesScreenShot)driver;
                      File file= ts.getScreenShot(OutputType.FILE);
                      FileUtils.copyFile(file,new File(System.getProperty("user.dir")+"/Screenshots"));
                      Thread.sleep(3000);
                      }
                     catch(NoSuchElementException e){System.out.println("No Elements Found");}
                     
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