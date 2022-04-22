package ui;

import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Amazon {

    private static Logger logger = LoggerFactory.getLogger(Amazon.class);

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(5);
        driver.close();
    }
}
