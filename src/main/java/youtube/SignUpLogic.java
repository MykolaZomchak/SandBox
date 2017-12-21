package youtube;

import org.openqa.selenium.WebElement;
import youtube.page_object.SignUpPage;

import javax.xml.ws.WebEndpoint;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SignUpLogic {

    private SignUpPage page = new SignUpPage();

    public void openPage() {
        page.load();
    }

    public void inputFirstName(String firstName) {
        page.getFirstNameInput().sendKeys(firstName);
    }

    public void inputLastName(String firstName) {
        page.getLastNameInput().sendKeys(firstName);
    }

    public void inputUsername(String username) {
        page.getUsernameInput().sendKeys(username);
    }

    public void inputPassword(String password) {
        page.getPasswordInput().sendKeys(password);
    }

    public void inputConfirmPassword(String password) {
        page.getConfirmPasswordInput().sendKeys(password);
    }

    public void selectBirthMonth(String month) {
        page.getMonthSelect().click();
        page.getOption(month).click();
    }

    public void inputDay(String day) {
        page.getDayInput().sendKeys(day);
    }

    public void inputYear(String year) {
        page.getYearInput().sendKeys(year);
    }

    public void selectGender(String gender) {
        page.getGenderSelect().click();
        page.getOption(gender).click();
    }

    public void inputPhone(String phone) {
        page.getPhoneInput().clear();
        page.getPhoneInput().sendKeys(phone);
    }

    public void inputCurrentEmail(String email) {
        page.getCurrentEmailInput().sendKeys(email);
    }

    public void selectCountry(String country) {
        page.getCountrySelect().click();
        page.getOption(country).click();
    }


    public void clickNextStep() {
        page.getNextStepButton().click();
    }

    public Set<String> getErrorMessages() {
        List<WebElement> elements = page.getErrorMessages();
        Set<String> messages = new HashSet<>();
        for(WebElement element : elements)
            messages.add(element.getText());
        return messages;
    }
}
