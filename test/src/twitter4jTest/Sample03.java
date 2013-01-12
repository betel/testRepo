package twitter4jTest;

import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;

public class Sample03 {
	public static void main(String[] args){
		try{
			TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
			twitterStream.addListener(new MyStatusAdapter());
			twitterStream.sample();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

class MyStatusAdapter extends StatusAdapter{
	public void onStatus(Status status){
		User user = status.getUser();

		String strText = status.getText();
		strText = strText.replaceAll("\r\n", " ");
		strText = strText.replaceAll("\r", " ");
		strText = strText.replaceAll("\n", " ");

		strText = strText.replaceAll("\t", " ");

		System.out.println(user.getScreenName()
				+ "\t" + strText);
	}
}
