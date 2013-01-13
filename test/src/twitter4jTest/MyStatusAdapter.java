package twitter4jTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.User;

public class MyStatusAdapter extends StatusAdapter{

	public int count = 0;
	private int limit = 5;

	public void onStatus(Status status){

		User user = status.getUser();
		if(isJapanese(user)){
			String strText = status.getText();
			if(isContained(strText)){
				strText = arrangeStr(strText);
				System.out.println("<"+count+">\t" +status.getCreatedAt() + "\t"+ user.getScreenName() + "    \t\t\t" + strText);
				//pw.println("<"+count+">\t" + user.getScreenName() + "    \t\t\t" + strText);
				count++;
			}
		}
	}

	//一行ずつファイルに出力
	public void writeIt(String str){
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tweets.txt")));
			pw.println(str);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Can't make file");
		}
	}

	//タイムゾーンが日本であるかどうかの判定
	public boolean isJapanese(User user){
		String tz = user.getTimeZone();
		boolean region = tz!=null && (tz.equals("Tokyo"))||(tz.equals("Osaka"))||(tz.equals("Sapporo"));
		return region;
	}
	//wordを含むかどうか
	public boolean isContained(String str){
		String reg = "";
		Pattern p	=	Pattern.compile(reg);
		Matcher m	=	p.matcher(str);
		return m.find();
	}
	//ツイートから改行・タブを除去する
	public String arrangeStr(String str){
		str = str.replaceAll("\r\n", " ");
		str = str.replaceAll("\r", " ");
		str = str.replaceAll("\n", " ");

		str = str.replaceAll("\t", " ");
		return str;
	}
}
