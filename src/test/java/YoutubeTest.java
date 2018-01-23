import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import youtube.IOUtils;
import youtube.SignUpLogic;

import java.util.Iterator;
import java.util.Set;

import static youtube.DriverManager.kill;

public class YoutubeTest {

    private final Logger logger = LoggerFactory.getLogger(YoutubeTest.class.getSimpleName());

    @DataProvider(name = "SignUp", parallel = true)
    public static Iterator<Object[]> credentials() {
        return IOUtils.readCsv("res/tests/sign_up.csv").iterator();
    }

    @Test(dataProvider = "SignUp")
    public void test(String firstName, String lastName, String username, String password,
                     String confirmPassword, String month, String day, String year, String gender,
                     String mobilePhone, String currentEmail, String location, Set<String> expectedErrors){
        logger.debug("Test started");
        SignUpLogic signUp = new SignUpLogic();
        signUp.openPage();
        signUp.inputFirstName(firstName);
        signUp.inputLastName(lastName);
        signUp.inputUsername(username);
        signUp.inputPassword(password);
        signUp.inputConfirmPassword(confirmPassword);
        signUp.selectBirthMonth(month);
        signUp.inputDay(day);
        signUp.inputYear(year);
        signUp.selectGender(gender);
        signUp.inputPhone(mobilePhone);
        signUp.inputCurrentEmail(currentEmail);
        signUp.selectCountry(location);
        Assert.assertEquals(signUp.getErrorMessages(), expectedErrors);
        logger.debug("Test finished");
    }

    @AfterMethod
    public void afterTest(){
        kill();
    }

}
