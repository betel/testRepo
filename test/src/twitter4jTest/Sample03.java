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
	boolean flag = false;
	public void onStatus(Status status){
		User user = status.getUser();
		//ユーザーのタイムゾーンを取得
		String tz = user.getTimeZone();

		//タイムゾーンが東京、大阪、札幌のときのみ
		if(flag){
			if(tz != null && (tz.equals("Tokyo"))||(tz.equals("Osaka"))||(tz.equals("Sapporo"))){
				String strText = status.getText();

				//ツイートから改行記号を除去
				strText = strText.replaceAll("\r\n", " ");
				strText = strText.replaceAll("\r", " ");
				strText = strText.replaceAll("\n", " ");
				//ツイートからタブ記号を除去
				strText = strText.replaceAll("\t", " ");

				System.out.println(user.getScreenName() + "\t\t" + strText);
			}
		}else{
			String strText = status.getText();

			//ツイートから改行記号を除去
			strText = strText.replaceAll("\r\n", " ");
			strText = strText.replaceAll("\r", " ");
			strText = strText.replaceAll("\n", " ");
			//ツイートからタブ記号を除去
			strText = strText.replaceAll("\t", " ");

			System.out.println(user.getScreenName() + "\t\t" + strText);
		}

	}
}
