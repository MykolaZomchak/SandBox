package youtube.page_object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static youtube.DriverManager.driver;

public abstract class Page {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String url;

    public void load(){
        logger.debug("Opening page: " + url);
        driver().get(url);
    }

    protected Logger logger(){
        return logger;
    }

}
