package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By searchButtonLocator = By.name("search");
    private By productThumb = By.cssSelector(".product-thumb");

    public HeaderPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }

    public void SearchInput(String searchCriteria){ driver.findElement(searchButtonLocator).sendKeys(searchCriteria, Keys.ENTER);
    }

    public int getSearchResults() {
        return driver.findElements(productThumb).size();
    }


}