package Bai15_Waits;

import Keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestImpliciWait extends BaseTest {
    @Test
    public void  login(){
        driver.get("https://rise.fairsketch.com/signin");
        driver.findElement(By.xpath("//div[normalize-space()='Admin']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        WebUI.sleep(2);
    }
}
