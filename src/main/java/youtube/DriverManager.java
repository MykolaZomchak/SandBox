package youtube;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static int count;

    private static int[] ports = {5555, 6666};

    private DriverManager(){}

    public static WebDriver driver(){
        if(drivers.get() == null)
            initializeRemote();
        return drivers.get();
    }

    private static void initializeRemote(){
        try {
            drivers.set(new RemoteWebDriver(new URL("http://10.25.9.237:" + ports[count%ports.length] + "/wd/hub"), new ChromeOptions()));
            drivers.get().manage().window().setPosition(new Point(count*50, count++*50));
        } catch (MalformedURLException e) {
            System.out.println("Could not initialize driver" + e);
        }
    }

    private static void initializeChrome(){
        System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
        drivers.set(new ChromeDriver());
        drivers.get().manage().window().maximize();

    }

    public static void kill(){
        WebDriver driver = drivers.get();
        if(driver==null)
            return;
        driver.close();
        driver.quit();
        drivers.set(null);
    }

}
