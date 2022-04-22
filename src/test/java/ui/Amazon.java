package ui;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Set;


public class Amazon {

    private static Logger logger = LoggerFactory.getLogger(Amazon.class);

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        logger.info("Navigate to Amazon website");
        driver.get("https://www.amazon.com");

        WebElement eleHamburgerIcon = driver.findElement(By.id("nav-hamburger-menu"));
        eleHamburgerIcon.click();

        WebElement eleDepartment = driver.findElement(By.xpath("//a[div[text()=\"TV, Appliances, Electronics\"]]"));
        eleDepartment.click();

        WebElement eleTelevisonDepartment = driver.findElement(By.linkText("Televisions"));
        eleTelevisonDepartment.click();

        WebElement eleSamsungCheckbox = driver.findElement(By.xpath("//div[div[span[text()=\"Brands\"]]]//a[span[text()=\"Samsung\"]]"));
        eleSamsungCheckbox.click();

        WebElement eleSortBtn = driver.findElement(By.id("a-autoid-3-announce"));
        eleSortBtn.click();

        WebElement eleSecondItem = driver.findElement(By.cssSelector("[data-cel-widget=search_result_2]  a[class=\"a-link-normal s-no-outline\"]"));
        eleSecondItem.click();

        WebElement elePriceHighToLow = driver.findElement(By.id("s-result-sort-select_2"));
        elePriceHighToLow.click();

        Set<String> windows = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>();
        windowsList.addAll(windows);
        driver.switchTo().window(windowsList.get(1));


        Thread.sleep(5);

        logger.info("Close the chromedriver sessions");
        driver.quit();
    }

}
