package youtube;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class.getSimpleName());
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static int count;

    private static int[] ports = {5555, 6666};

    private DriverManager(){}

    public static WebDriver driver(){
        if(drivers.get() == null)
            initializeRemote();
        return drivers.get();
    }

    private static synchronized void initializeRemote(){
        logger.info("Initializing driver on port: " + ports[count%ports.length]);
        try {
            drivers.set(new RemoteWebDriver(new URL("http://10.25.9.237:" + ports[count%ports.length] + "/wd/hub"), new ChromeOptions()));
            drivers.get().manage().window().setPosition(new Point(count*50, count++*50));
        } catch (MalformedURLException|UnreachableBrowserException e) {
            logger.error("Fatal error: can't initialize Chrome driver on hub http://10.25.9.237:" + ports[count%ports.length] + "/wd/hub", e);
        }
    }

    public static void kill(){
        logger.info("Killing driver: " + drivers.get().toString());
        WebDriver driver = drivers.get();
        if(driver==null)
            return;
        driver.close();
        driver.quit();
        drivers.set(null);
    }

}
