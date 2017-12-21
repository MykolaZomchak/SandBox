package youtube.page_object;

import org.openqa.selenium.WebElement;

import java.util.List;

import static youtube.DriverManager.driver;

public class SignUpPage extends Page{

    { url = "https://accounts.google.com/SignUp"; }

    public WebElement getFirstNameInput() {
        return driver().findElementById("FirstName");
    }

    public WebElement getLastNameInput() {
        return driver().findElementById("LastName");
    }

    public WebElement getUsernameInput() {
        return driver().findElementById("GmailAddress");
    }

    public WebElement getPasswordInput() {
        return driver().findElementById("Passwd");
    }

    public WebElement getConfirmPasswordInput() {
        return driver().findElementById("PasswdAgain");
    }

    public WebElement getMonthSelect() {
        return driver().findElementByCssSelector("div[title=\"Birthday\"]");
    }

    public WebElement getDayInput(){
        return driver().findElementById("BirthDay");
    }

    public WebElement getYearInput(){
        return driver().findElementById("BirthYear");
    }

    public WebElement getGenderSelect() {
        return driver().findElementByCssSelector("div[title=\"Gender\"]");
    }

    public WebElement getOption(String text) {
        return driver().findElementByXPath("//div[@class='goog-menuitem']/div[contains(text(),'" + text + "')]");
    }

    public WebElement getPhoneInput(){
        return driver().findElementById("RecoveryPhoneNumber");
    }

    public WebElement getCurrentEmailInput(){
        return driver().findElementById("RecoveryEmailAddress");
    }

    public WebElement getCountrySelect() {
        return driver().findElementByCssSelector("div[title=\"Location\"]");
    }

    public WebElement getNextStepButton(){
        return driver().findElementById("submitbutton");
    }

    public List<WebElement> getErrorMessages(){
        return driver().findElementsByXPath("//span[@class='errormsg' and string-length(text())>5]");
    }


}