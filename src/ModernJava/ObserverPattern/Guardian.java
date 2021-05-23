package ModernJava.ObserverPattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Guardian implements  Observer {

    private static Logger logger = LoggerFactory.getLogger(Guardian.class);

    @Override
    public void notify(String tweet) {
            if (tweet != null && tweet.contains("queen")) {
                logger.info("Yet more news form London... "+tweet);
            }
    }
}
