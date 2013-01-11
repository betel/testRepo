package twitter4jTest;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class Sample01 {
	public void start(){
		Twitter twitter = TwitterFactory.getSingleton();
		Status status = twitter.updateStatus(latestStatus);
		System.out.println("Successfully update the status to [" + status.getText() + "]." );
	}
}
