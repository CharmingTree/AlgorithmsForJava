package ModernJava.ObserverPattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeMonde implements Observer {
    private static Logger logger = LoggerFactory.getLogger(LeMonde.class);

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            logger.info("Today cheese, wine and news! " + tweet);
        }
    }
}
