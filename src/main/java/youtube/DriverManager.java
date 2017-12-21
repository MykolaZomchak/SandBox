package youtube;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static ChromeDriver instance;

    private DriverManager(){}

    public static ChromeDriver driver(){
        if(instance == null)
            initialize();
        return instance;
    }

    private static void initialize(){
        System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
        instance = new ChromeDriver();
        instance.manage().window().maximize();
    }

    public static void kill(){
        if(instance==null)
            return;
        instance.close();
        instance.quit();
        instance = null;
    }

}
