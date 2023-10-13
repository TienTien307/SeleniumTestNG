package Bai13_Alert_Popup_iFrame;

import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlePopupWindow extends BaseTest {
    @Test
    public void testHandlePopup() throws InterruptedException {
        driver.get("https://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        //lưu lại lớp window đầu tiên (MH chính)
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        //get all new opened tab window
        Set<String> windows = driver.getWindowHandles();

        //Set là 1 collection để lưu các phần tử giá trị KHÔNG tùng lặp
        //CÁch duyệt từng phần tử ko trùng lặp trong collection
        for (String window : windows){
            System.out.println(window);
            if ( !mainWindow.equals(window)){
                //so sánh nếu thằngnafafo khác hằng main (đầu tiên) thì chuyển
                //Switch to Child wonow
                driver.switchTo().window(window);
                Thread.sleep(2000);
                System.out.println("Đã chuyển đế lơp window con");

                //một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("abc@gmail.com");
                driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
                Thread.sleep(1000);

                //get text trang sau khi submit
                System.out.println(driver.findElement(By.xpath("//table//tr/td/h2")).getText());

                //closing the child window
                Thread.sleep(1000);
                driver.close();
            }
        }
        //switching to main window
        driver.switchTo().window(mainWindow);
        System.out.println("Dã chuyển về lớp window chính: " +driver.getCurrentUrl());

    }

}
