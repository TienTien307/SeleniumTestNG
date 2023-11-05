package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void createBrowser(){
        System.out.println("Start Chrome browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //chờ đợi ngầm định cho mỗi câu lệnh tìm kiếm driver.findElement
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //chờ đợi trang load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

//    @AfterClass
//    public void closeBrowser(){
//        System.out.println("Close browser");
//        driver.quit();
//    }
}
