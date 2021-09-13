package objectstructures;


public class Tweet {

	//A tweet belongs to the account from which it was sent
	//If a different account finds this tweet interesting, this account can retweet the tweet. 
	
	private String text;
	private TwitterAccount account;
	private int retweetCount = 0;
	private Tweet originalTweet = null;
	
	
	//Constructors
	
	/**
	 * Creates a new original tweet
	 * @param ac The account posting the tweet
	 * @param tweet The content of the tweet
	 */
	public Tweet (TwitterAccount ac, String text) {
		this.account = ac;
		this.text = text;
		
	}
	
	/**
	 * Reposts a tweet from a different account
	 * @param OP The original poster of the tweet
	 * @param tweet The tweet you want to repost
	 * @exception Throws IllegalArgumentException if OP is the same account as this user
	 */
	public Tweet(TwitterAccount account, Tweet tweet) {
		Tweet originalTweet = tweet.getOriginalTweet();
		
		if (tweet.getOwner() == account || (originalTweet != null && originalTweet.getOwner() == account)) {
			throw new IllegalArgumentException("You can't retweet your own tweet weirdo");
		}
		this.originalTweet = (originalTweet != null ? originalTweet : tweet);
		this.originalTweet.retweetCount++;
		this.account = account;
		this.text = this.originalTweet.getText();
	}
	
	public String getText() {
		return text;
	}
	
	public TwitterAccount getOwner() {
		return account;
	}
	
	public Tweet getOriginalTweet() {
		return originalTweet;
	}
	
	public int getRetweetCount() {
		return retweetCount;
	}
}
