package lwjglUtilSample;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Sample01 {

	public void start(){
		try{
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
			System.exit(0);
		}
		
		while(!Display.isCloseRequested()){
			Display.update();
		}
		Display.destroy();
	}
	public long getTime(){
		return (Sys.getTime() * 1000)/Sys.getTimerResolution();
	}
	public static void main(String[] args){
		new Sample01().start();
	}
}
