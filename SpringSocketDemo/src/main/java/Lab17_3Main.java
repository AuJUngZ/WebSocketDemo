public class Lab17_3Main {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount();
        twitterAccount.subscribe(new Follower1());
        twitterAccount.subscribe(new Follower2());
        twitterAccount.subscribe(new Follower3());

        twitterAccount.publishTweet("Say Hi to my 3 (millions) followers, Have a nice day");
        twitterAccount.publishTweet("Too many works!");
        twitterAccount.publishTweet("Waiting for ending of semester T____T");
    }
}

class Follower1 implements Observer<String> {
    @Override
    public void notify(String tweet) {
        System.out.println(tweet + " |  Follower 1 says: <3 luv");
    }
}

class Follower2 implements Observer<String> {
    @Override
    public void notify(String tweet) {
        System.out.println(tweet + " |  Follower 2 says: I'm first reply, wow ");
    }
}

class Follower3 implements Observer<String> {
    @Override
    public void notify(String tweet) {
        System.out.println(tweet + " |  Follower 3 says: We encourage you !!! Su SU "  );

    }
}