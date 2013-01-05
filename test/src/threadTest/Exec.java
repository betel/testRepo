package threadTest;

import org.lwjgl.input.Keyboard;

public class Exec {
	public void start(){
		Job job = new Job();
		Thread t = new Thread(job);
		while(!Keyboard.isKeyDown(Keyboard.KEY_C)){
			pollInput(t);
		}
	}

	public void pollInput(Thread t){
		while(!Keyboard.next()){
			if(Keyboard.getEventKeyState()){
				if(Keyboard.getEventKey()==Keyboard.KEY_S){
					System.out.println("start!");
					t.start();
				}else{
					System.out.println("stop");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			}
		}
	}
	//
	public static void main(String[] args){
		new Exec().start();
	}
	

}
