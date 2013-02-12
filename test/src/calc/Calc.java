package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
	String[] l;
	String op;
	double a,b,ans;
	
	public void start(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			while((str=br.readLine())!=null){
				l	= str.split(" ");
				op	= l[1];
				a	= Double.parseDouble(l[0]);
				b	= Double.parseDouble(l[2]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(op.equals("+")){ ans = a + b; }
		if(op.equals("-")){ ans = a - b; }
		if(op.equals("*")){ ans = a * b; }
		if(op.equals("/")){
			if(b==0){
				ans = 0;
			}else{
				ans = a/b;
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args){
		new Calc().start();
	}
}
