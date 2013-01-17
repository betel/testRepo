package twitter4jTest;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/*
 * URLを含むものだけを抽出
 */

public class Sample06 {
	public static void main(String[] args){
		TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
		twitterStream.addListener(new OutputURL());
		twitterStream.sample();
	}
}
