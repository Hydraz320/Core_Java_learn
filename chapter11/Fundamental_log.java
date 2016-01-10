package chapter11;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Fundamental_log {
	
	public static void main(String[] args) {
		//下面这一句一旦启用 调用就会失效
		//Logger.getGlobal().setLevel(Level.OFF);
		LogTest log=new LogTest();
		log.printLog();
	}

}

class LogTest
{
	public void printLog()
	{
		Logger.getGlobal().info("我就瞎试试");
	}
}