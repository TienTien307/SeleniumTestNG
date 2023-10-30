package Bai10_AnnotaionTestNG;

import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends BaseTest{

    @Test (priority = 1)
    public void testlogin() throws InterruptedException {
        System.out.println("runtest login");
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(1000);
    }
    @Test (priority = 2)
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(1000);
    }

}
