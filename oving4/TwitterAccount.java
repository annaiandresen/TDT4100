package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TwitterAccount {

	private String userName;
	private List<Tweet> tweets;
	private Collection<TwitterAccount> followers;
	private Collection<TwitterAccount> following;

	public TwitterAccount(String userName) {
		this.userName = userName;
		tweets = new ArrayList<>();
		followers = new ArrayList<>();
		following = new ArrayList<>();
	}

	public String getUserName() {
		return userName;
	}

	public void follow(TwitterAccount account) {
		if (this == account) {
			return;
		}
		if (!isFollowing(account)) {
			following.add(account);
			account.addFollower(this);
		}

	}

	public void addFollower(TwitterAccount account) {
		if (this == account) {
			return;
		}
		if (account.isFollowing(this)) {
			followers.add(account);
		}
	}

	public void unfollow(TwitterAccount account) {
		if (this == account) {
			return;
		}
		if (isFollowing(account)) {
			following.remove(account);
			account.removeFollower(this);
		}

	}
	
	public void removeFollower(TwitterAccount account) {
		if (this == account) {
			return;
		}
		if (isFollowedBy(account)) {
			followers.remove(account);
		}
	}
	
	

	public boolean isFollowing(TwitterAccount account) {
		return following.contains(account);

	}

	public boolean isFollowedBy(TwitterAccount account) {
		return followers.contains(account);
	}

	public void tweet(String text) {
		Tweet tweet = new Tweet(this, text);
		tweets.add(tweet);

	}

	public void retweet(Tweet tweet) {
		Tweet retweet = new Tweet(this, tweet);
		tweets.add(retweet);

	}

	public Tweet getTweet(int i) {
		return tweets.get(tweets.size()- i);

	}

	public int getTweetCount() {
		return tweets.size();

	}

	public int getRetweetCount() {
		int counter = 0;
		for (Tweet tweet : tweets) {
			counter += tweet.getRetweetCount();
		}
		return counter;

	}

	@Override
	public String toString() {
		String str = "";
		for (Tweet tweet : tweets) {
			str += "\n";
			str += tweet.getText();
			str += "\n";
		}
		return userName + str;
	}
}
