package com.qa.ftse100;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FTSE100 {
	
	private static RemoteWebDriver driver;
	private static WebElement target;
	

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
        driver = new ChromeDriver(chromeCfg());
        
    }
    
    @AfterClass
    public static void cleanUp() {
    	driver.quit();
    	System.out.println("Driver Closed");
    }
    
    public static ChromeOptions chromeCfg() {
     Map<String, Object> prefs = new HashMap<String, Object>();
     ChromeOptions cOptions = new ChromeOptions();
      
     prefs.put("profile.default_content_setting_values.cookies", 2);
     prefs.put("network.cookie.cookieBehavior", 2);
     prefs.put("profile.block_third_party_cookies", true);

     cOptions.setExperimentalOption("prefs", prefs);

     return cOptions;
     }
    
    @Test
    public void testRiser() throws InterruptedException {
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
        target = driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div/div[4]/div[1]/ul/li[2]/a/strong"));
        target.click();
    }
    
    @Test     
    public void testFallen() throws InterruptedException {
        driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");    
        target = driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div/div[4]/div[1]/ul/li[3]/a/strong"));
        target.click();
        
        Thread.sleep(500);
    }

}
