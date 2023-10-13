package Bai13_Alert_Popup_iFrame;

import common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HandleAlert extends BaseTest {

    @Test
    public void demoHandleAlertAccept() throws InterruptedException {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        Thread.sleep(2000);

        //Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert thứ nhất
        Alert alert1 = driver.switchTo().alert();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Thread.sleep(1000);
        alert1.accept();

        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertInputTextOther() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Thread.sleep(2000);
        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Anh Tester");
        Thread.sleep(1000);
        //Nhấn Ok button
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        //Kiểm tra giá trị sendKeys
        String value = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
        System.out.println(value);
        Assert.assertTrue(value.contains("Anh Tester"), "Không chứa Text sendKeys");
        Thread.sleep(1000);
    }

}
