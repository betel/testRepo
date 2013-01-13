package twitter4jTest;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class Sample04 {

	public void showStream(){
		TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
		MyStatusAdapter ms = new MyStatusAdapter();
		twitterStream.addListener(ms);
		twitterStream.sample();
	}
	//実行
	public static void main(String[] args){
		new Sample04().showStream();
	}
}
