package twitter4jTest;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Sample01 {
	public void start(){
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			Status status = twitter.updateStatus("Hello!");
			System.out.println("Successfully update the status to [" + status.getText() + "]." );
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args){
		new Sample01().start();
	}
}
