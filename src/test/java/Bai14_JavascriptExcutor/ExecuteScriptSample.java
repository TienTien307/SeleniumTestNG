package Bai14_JavascriptExcutor;

import Keywords.WebUI;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ExecuteScriptSample extends BaseTest {

    @Test
    public void testScript01(){
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
//        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
//        WebUI.sleep(2);
//        driver.findElement(By.xpath("(//a[normalize-space()='Flash Sale'])[1]")).click();
//        WebUI.sleep(2);

        //Click object với JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver; //khai báo và khởi tạo giá trị đối tượng
//        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[normalize-space()='Flash Sale'])[1]")));
        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();

        driver.findElement(By.xpath("//i[normalize-space()='*Use Email Instead']")).click();
        //Điền giá trị vào input
        js.executeScript("arguments[0].setAttribute('value','admin02@mailinator.com');", driver.findElement(By.xpath("(//input[@id='email'])[1]")));
        js.executeScript("arguments[0].setAttribute('value','123456');", driver.findElement(By.xpath("//input[@id='password']")));
        driver.findElement(By.xpath("button[class='btn btn-primary btn-block fw-700 fs-14 rounded-4']")).click();

        WebUI.sleep(2);
    }
}
