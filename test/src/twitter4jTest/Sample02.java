package twitter4jTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Sample02 {
	public void tweet() throws IOException, TwitterException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tweet = "";
		while(tweet.isEmpty()){
			System.out.print("今何してる？:");
			tweet = br.readLine();
			if(tweet.length()>140){
				System.out.println("字数制限を超えています");
				tweet = "";
				continue;
			}
		}
		
		Twitter twitter = new TwitterFactory().getInstance();
		Status	status  = twitter.updateStatus(tweet);
		System.out.println(status.getUser().getScreenName() + "として投稿しました:" + status.getText());
		
		br.close();
	}
	
	public static void main(String[] args) throws IOException, TwitterException{
		new Sample02().tweet();
	}
}
