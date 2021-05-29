package ModernJava.ObserverPattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

    private static Logger logger = LoggerFactory.getLogger(Feed.class);
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }

    public static void main(String[] args) {
        Feed f = new Feed();
        //f.registerObserver(new NYTimes());
        //f.registerObserver(new Guardian());
        //f.registerObserver(new LeMonde());
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains(" money ")) {
                logger.info(" Breaking news in NY! " + tweet);
            }
        });
        f.notifyObservers("The queen said her favourite book is Modern Java in Action! money wine");
    }
}
