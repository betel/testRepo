package twitter4jTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import twitter4j.User;

public class ToolBox {
	/**
	 * ArrayListの内容を指定したファイルに出力
	 * @param list
	 * @param fileName
	 */
	public static void writeIt(ArrayList<String> list, String fileName){
		try{
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			for(String str : list){
				pw.println(str);
			}
			pw.close();
		}catch(IOException e){
			e.printStackTrace();
			System.err.println("Cant't make file");
		}
	}
	/**
	 * タイムゾーンがどこであるかの判定
	 * @param user (twitter4j.user)
	 * @return boolean
	 */
	public static boolean isJapanese(User user){
		String tz = user.getTimeZone();
		boolean region = tz!=null&&(tz.equals("Tokyo")||tz.equals("Osaka")||tz.equals("Sapporo"));
		return region;
	}
	public static boolean isUS(User user){
		String tz = user.getTimeZone();
		boolean region = tz!=null&&(tz.equals("Eastern Time (US & Canada)")||tz.equals("Central Time (US & Canada)")||tz.equals("Eastern Time (US & Canada)")
				||tz.equals("Pacific Time (US & Canada)"));
		return region;
	}
	public static boolean isUK(User user){
		String tz = user.getTimeZone();
		boolean region = tz!=null&&tz.equals("London");
		return region;
	}
	/**
	 * 改行・タブの除去
	 * @param string
	 * @return string
	 */
	public static String arrangeStr(String string){
		string = string.replaceAll("\r\n", " ");
		string = string.replaceAll("\r", " ");
		string = string.replaceAll("\n", " ");

		string = string.replaceAll("\t", " ");
		return string;
	}
	/**
	 * 特定のワードを正規表現で探す
	 * @param reg
	 * @param string (検索対象)
	 * @return boolean
	 */
	public static boolean isContained(String reg, String string){
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(string);
		return m.find();
	}
}
