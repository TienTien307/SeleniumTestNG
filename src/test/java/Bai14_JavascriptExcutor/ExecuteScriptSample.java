package Bai14_JavascriptExcutor;

import Keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExecuteScriptSample extends BaseTest {

    @Test
    public void testScript01(){
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        WebUI.sleep(2);
//        driver.findElement(By.xpath("(//a[normalize-space()='Flash Sale'])[1]")).click();
//        WebUI.sleep(2);

        //Click object với JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver; //khai báo và khởi tạo giá trị đối tượng
//        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[normalize-space()='Flash Sale'])[1]")));
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        driver.findElement(By.xpath("//i[normalize-space()='*Use Email Instead']")).click();
        //Điền giá trị vào input
        js.executeScript("arguments[0].setAttribute('value','customer@example.com');", driver.findElement(By.xpath("(//input[@id='email'])[1]")));
        js.executeScript("arguments[0].setAttribute('value',arguments[1]);", driver.findElement(By.xpath("//input[@id='password']")),"123456");
        WebUI.sleep(1);

        WebElement btnLogin = driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]"));
        //cuộn chuột xuống phần tử trên trang
        js.executeScript(("arguments[0].scrollIntoView(false);"), btnLogin);

        WebUI.sleep(2);
        btnLogin.click();

        WebUI.sleep(2);
    }

    @Test
    public void testScript02(){
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        WebUI.sleep(2);

        //khai báo và khởi tạo giá trị đối tượng
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[normalize-space()='Flash Sale'])[1]")));
        //cuộn chuột xuống phần tử trên trang
//        js.executeScript("alert('Welcome To Anh Tester ');");

        //highlight 1 phần tử trên trang
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//h1[normalize-space()='Welcome Back !']")));

        WebUI.sleep(2);
    }
}
