package pages.Amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Base;
import io.qameta.allure.Step;

public class Navigation extends Base {
    @FindBy(id="nav-hamburger-menu")
    private WebElement eleHamburgerIcon;

    @FindBy(xpath="//a[div[text()=\"TV, Appliances, Electronics\"]]")
    private WebElement eleDepartment;

    @FindBy(xpath = "//a[text()=\"Televisions\"]")
    private WebElement eleTelevisionDepartment;

    @FindBy(xpath = "//div[div[span[text()=\"Brands\"]]]//a[span[text()=\"Samsung\"]]")
    private WebElement eleSamsungTV;

    @Step
    public void clickHamburgerIcon(){
        eleHamburgerIcon.click();
    }

    @Step
    public void selectDepartment(){
        eleDepartment.click();
    }

    @Step
    public void selectSubCategory(){
        eleTelevisionDepartment.click();
    }

    @Step
    public void FilterSamsungItem(){
        eleSamsungTV.click();
    }

}
