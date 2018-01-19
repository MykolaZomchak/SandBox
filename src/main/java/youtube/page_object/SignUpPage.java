package youtube.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static youtube.DriverManager.driver;

public class SignUpPage extends Page{

    { url = "https://accounts.google.com/SignUp"; }

    public WebElement getFirstNameInput() {
        return driver().findElement(By.id("FirstName"));
    }

    public WebElement getLastNameInput() {
        return driver().findElement(By.id("LastName"));
    }

    public WebElement getUsernameInput() {
        return driver().findElement(By.id("GmailAddress"));
    }

    public WebElement getPasswordInput() {
        return driver().findElement(By.id("Passwd"));
    }

    public WebElement getConfirmPasswordInput() {
        return driver().findElement(By.id("PasswdAgain"));
    }

    public WebElement getMonthSelect() {
        return driver().findElement(By.cssSelector("div[title=\"Birthday\"]"));
    }

    public WebElement getDayInput(){
        return driver().findElement(By.id("BirthDay"));
    }

    public WebElement getYearInput(){
        return driver().findElement(By.id("BirthYear"));
    }

    public WebElement getGenderSelect() {
        return driver().findElement(By.cssSelector("div[title=\"Gender\"]"));
    }

    public WebElement getOption(String text) {
        return driver().findElement(By.xpath("//div[@class='goog-menuitem']/div[contains(text(),'" + text + "')]"));
    }

    public WebElement getPhoneInput(){
        return driver().findElement(By.id(("RecoveryPhoneNumber")));
    }

    public WebElement getCurrentEmailInput(){
        return driver().findElement(By.id(("RecoveryEmailAddress")));
    }

    public WebElement getCountrySelect() {
        return driver().findElement(By.cssSelector("div[title=\"Location\"]"));
    }

    public WebElement getNextStepButton(){
        return driver().findElement(By.id("submitbutton"));
    }

    public List<WebElement> getErrorMessages(){
        return driver().findElements(By.xpath("//span[@class='errormsg' and string-length(text())>5]"));
    }


}