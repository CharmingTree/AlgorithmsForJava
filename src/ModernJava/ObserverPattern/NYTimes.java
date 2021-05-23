package ModernJava.ObserverPattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NYTimes implements Observer{
    private static Logger logger = LoggerFactory.getLogger(NYTimes.class);

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            logger.info("Breaking news in NY! " + tweet);
        }
    }
}
