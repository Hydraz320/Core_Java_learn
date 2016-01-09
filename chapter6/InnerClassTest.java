package chapter6;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TalkingClock clock=new TalkingClock(1000,true);
		clock.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

class TalkingClock
{
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval,boolean beep)
	{
		this.interval=interval;
		this.beep=beep;
	}
	
	public void start()
	{
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(interval,listener);
		t.start();
	}
	
	public class TimePrinter implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Date now=new Date();
			System.out.println("time is:"+now);
			if(beep)
				Toolkit.getDefaultToolkit().beep();
		}
		
	}
}