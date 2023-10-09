package Bai12_Actions_RobotClass;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActionsClass extends BaseTest {
    @Test
    public void TestSendKeys() throws InterruptedException {

        driver.get("https://www.google.com/");

        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Selenium Java").sendKeys(Keys.ENTER).build().perform();

        WebElement titleResult  = driver.findElement(By.xpath("//h3[contains(text(),'[Selenium Java] Bài 4: Cài đặt môi trường Selenium')]"));
        Thread.sleep(1000);
        action.click(titleResult).build().perform(); //click vào 1 element

        Thread.sleep(2000);
    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        //Element của header page
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);
        //click chuột trái 2 lần vào header
        action.doubleClick(element).perform();
        Thread.sleep(2000);
    }

    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);
        //click chuột phải vào element
        action.contextClick(element).perform();
        Thread.sleep(2000);
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(1000);
        //bắt 1 element bị khuất
        WebElement element = driver.findElement(By.xpath("//h4[contains(text(),'Blog kiến thức Testing')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển con trỏ chuột tới title Kiến thức Automation Testing)
        action.moveToElement(element).perform();

        Thread.sleep(2000);
    }
    @Test
    public void demoDragAndDropWithActionClass() throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Thread.sleep(1000);

        // Bắt element cần kéo
        WebElement From = driver.findElement(By.xpath("//div[@id='box5']"));
        // Bắt element cần thả đến
        WebElement To = driver.findElement(By.xpath("//div[@id='countries']//div[@id='box105']"));

        Thread.sleep(1000);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(From, To).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh").keyUp(Keys.SHIFT).sendKeys(" tester").build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void scrollPageDownAndUp() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll down cuối trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        Thread.sleep(2000);
        // Scroll up đầu trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(2000);
    }
}
