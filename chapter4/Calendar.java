package chapter4;

import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 应用GregorianCalendar类的日历程序
 * @author Geec
 * @version 1.0
 */
public class Calendar {

	public static void main(String[] args) {
		//修改当地区域 改成美国
		Locale.setDefault(Locale.US);
		//创建当前时间
		GregorianCalendar d=new GregorianCalendar();
		
		//记录当天月、日
		int today=d.get(GregorianCalendar.DAY_OF_MONTH);
		int month=d.get(GregorianCalendar.MONTH);
		
		//将日期设置成1号 从而找到应有的缩进
		d.set(GregorianCalendar.DAY_OF_MONTH, 1);
		
		//记录1号是周几
		int weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
		
		//获取当地计时方式下 一周的第一天是周几
		int firstDayOfWeek=d.getFirstDayOfWeek();
		
		//计算第一行日期所需缩进
		int indent=0;
		while(weekday!=firstDayOfWeek)
		{
			indent++;
			d.add(GregorianCalendar.DAY_OF_MONTH, -1);//往回倒退一天 看看上个月的末几天
			weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
		}
		//打印周日至周六的一行表 控制在4个空
		String[] weekdayNames=new DateFormatSymbols().getShortWeekdays();
		do
		{
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(GregorianCalendar.DAY_OF_MONTH, 1);
			weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
		}while(weekday!=firstDayOfWeek);
		//循环结束说明应该开始打印下一行了 所以还需要换行
		System.out.println();
		
		//第二行需要先打印缩进 每次打印4个空格 注意是四个！
		for(int i=0;i<indent;i++)
			System.out.print("    ");
		
		//打印完缩进后来到这个月的第一天 如果不这么调整 时间应该是在下一周的第一天 可println进行调试
		//System.out.println(d.getTime());
		d.set(GregorianCalendar.DAY_OF_MONTH, 1);
		
		//打印日期表 当打印的这个月还是最开始记录的那一个月时
		do
		{
			int day=d.get(GregorianCalendar.DAY_OF_MONTH);
			System.out.printf("%3d",day);
			//如果是当天则打印一个* 否则就打一个空格保持对齐
			if(day==today)
				System.out.print("*");
			else
				System.out.print(" ");
			
			//更新日历
			d.add(GregorianCalendar.DAY_OF_MONTH, 1);
			weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
			
			//判断是否到了下一周 如果是 需要换行
			if(weekday==firstDayOfWeek)
				System.out.println();
		}while(d.get(GregorianCalendar.MONTH)==month);
		
		//要是最后一行没填满 咱换一行
		if(weekday!=firstDayOfWeek)
			System.out.println();
	}

}
