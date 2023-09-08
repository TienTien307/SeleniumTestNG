package Bai10_AnnotaionTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MoBrowser1Lan {
    //BeforeTest hoặc @BeforeClass
    WebDriver driver;

    @BeforeClass
    public void createBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("anhtester", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//h3[normalize-space()='Anh Tester Automation Testing'])[1]")).click();
        Thread.sleep(1000);
    }

    //AfterTest hoặc AferClass
    @AfterClass
    public  void closeBrowser(){
        driver.quit();
    }

}
