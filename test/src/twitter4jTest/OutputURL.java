package twitter4jTest;

import java.util.ArrayList;

import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.User;
import static twitter4jTest.ToolBox.*;

public class OutputURL extends StatusAdapter{
	
	int count = 0;
	int limit = 100;
	ArrayList<String> tweets = new ArrayList<String>();
	
	public void onStatus(Status status){
		User user = status.getUser();
		String str = status.getText();
		if(isJapanese(user)&&isContained("http",str)){
			str = arrangeStr(str);
			String style = "<" + count + ">\t" + status.getCreatedAt() + "\t" + str + "(@" + user.getScreenName() + ")";
			tweets.add(style);
			System.out.println(style);
			count++;
		}
		if(count>limit-1){
			writeIt(tweets,"tweets.txt");
			System.exit(0);
		}
	}
}
