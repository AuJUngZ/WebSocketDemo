import java.util.HashSet;
import java.util.Set;

public class TwitterAccount implements Observable<String> { //Twitter account is producer that produce tweets
    private Set<Observer<String>> subscribers = new HashSet<>(); //add follower into this set
    /*Each account have subscribed method*/
    public void subscribe( //In Twitter Account have set of followers (subscriber in context)
                           Observer<String> follower) {
        subscribers.add(follower); //If anyone wants to follow account, call subscribe method and sent yourself.
    }
    public void publishTweet(String tweet) { //When new tweet
        for (Observer<String>
                subscriber : subscribers) //notify new tweet to each follower(subscriber)
            subscriber.notify(tweet); //subscriber get notify
    }
}
