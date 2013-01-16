package twitter4jTest;

import static twitter4jTest.ToolBox.*;

import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/*
 * 自分のツイートの取得
 */
public class Sample05 {

	public void getMyTweets(){
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			for(int i=0; i<10; i++){
				Paging paging = new Paging(i+1,40);		//ページ数は0ではなく1から始まる
				List<Status> statuses = twitter.getUserTimeline("betelgeuse_01",paging);
				for(Status status : statuses){
					if(isContained("RT",status.getText())){
						continue;
					}
					System.out.println(status.getUser().getScreenName() + "\t" + status.getText());
				}
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		new Sample05().getMyTweets();
	}
}