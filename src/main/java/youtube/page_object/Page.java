package youtube.page_object;

import static youtube.DriverManager.driver;

public abstract class Page {

    String url;

    public void load(){
        driver().get(url);
    }

}
