package chapter4;

import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 将日历单独写成类
 * @author Geec
 * @version 1.0
 */
public class USCalendar {
	//记录当天月、日、当地环境下一周的第一天是哪一天
	private final int today;
	private final int month;

	/**
	 * 日历对象及当地每周第一天 我直接整static了。其中firstDayOfWeek
	 * 也不会在过程中改变，就直接final了。最后初始化是在static代码块中完成的。
	 */
	//记录当前时间
	private static GregorianCalendar d;
	private static final int firstDayOfWeek;
	static
	{
		//修改当地区域 改成美国
		Locale.setDefault(Locale.US);
		//创建当前时间
		d=new GregorianCalendar();
		//获取当地计时方式下 一周的第一天是周几
		firstDayOfWeek=d.getFirstDayOfWeek();
	}

	/**
	 * 因为分出去几个静态域并用代码块完成了初始化，构造器就没有太多任务了
	 */
	public USCalendar()
	{
		//记录当天月、日
		today=d.get(GregorianCalendar.DAY_OF_MONTH);
		month=d.get(GregorianCalendar.MONTH);
	}
	//打印日历的方法
	/**
	 * display没有参数，就是个显示函数，初始化都是在构造器及代码块中完成的
	 */
	public void displayCalendar()
	{
		// 将日期设置成1号 从而找到应有的缩进
		d.set(GregorianCalendar.DAY_OF_MONTH, 1);

		// 记录1号是周几
		int weekday = d.get(GregorianCalendar.DAY_OF_WEEK);
		//缩进
		int indent=0;
		while(weekday!=firstDayOfWeek)
		{
			indent++;
			d.add(GregorianCalendar.DAY_OF_MONTH, -1);//往回倒退一天 看看上个月的末几天
			weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
		}
		// 打印周日至周六的一行表 控制在4个空
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(GregorianCalendar.DAY_OF_MONTH, 1);
			weekday = d.get(GregorianCalendar.DAY_OF_WEEK);
		} while (weekday != firstDayOfWeek);
		// 循环结束说明应该开始打印下一行了 所以还需要换行
		System.out.println();

		// 第二行需要先打印缩进 每次打印4个空格 注意是四个！
		for (int i = 0; i < indent; i++)
			System.out.print("    ");

		// 打印完缩进后来到这个月的第一天 如果不这么调整 时间应该是在下一周的第一天 可println进行调试
		// System.out.println(d.getTime());
		d.set(GregorianCalendar.DAY_OF_MONTH, 1);

		// 打印日期表 当打印的这个月还是最开始记录的那一个月时
		do {
			int day = d.get(GregorianCalendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			// 如果是当天则打印一个* 否则就打一个空格保持对齐
			if (day == today)
				System.out.print("*");
			else
				System.out.print(" ");

			// 更新日历
			d.add(GregorianCalendar.DAY_OF_MONTH, 1);
			weekday = d.get(GregorianCalendar.DAY_OF_WEEK);

			// 判断是否到了下一周 如果是 需要换行
			if (weekday == firstDayOfWeek)
				System.out.println();
		} while (d.get(GregorianCalendar.MONTH) == month);

		// 要是最后一行没填满 咱换一行
		if (weekday != firstDayOfWeek)
			System.out.println();
	}
}
