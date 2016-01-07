package chapter4;

import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * ����������д����
 * @author Geec
 * @version 1.0
 */
public class USCalendar {
	//��¼�����¡��ա����ػ�����һ�ܵĵ�һ������һ��
	private final int today;
	private final int month;
	private final int firstDayOfWeek;
	//��¼��ǰʱ��
	private GregorianCalendar d;
	//����
	private int indent;
	//��¼ĳ�����ܼ�
	private int weekday;

	//������
	public USCalendar()
	{
		//�޸ĵ������� �ĳ�����
		Locale.setDefault(Locale.US);
		//������ǰʱ��
		d=new GregorianCalendar();
		//��¼�����¡���
		today=d.get(GregorianCalendar.DAY_OF_MONTH);
		month=d.get(GregorianCalendar.MONTH);
		//��ȡ���ؼ�ʱ��ʽ�� һ�ܵĵ�һ�����ܼ�
		firstDayOfWeek=d.getFirstDayOfWeek();
		//�����һ��������������
		indent=0;
	}
	//��ӡ�����ķ���
	public void displayCalendar()
	{
		// ���������ó�1�� �Ӷ��ҵ�Ӧ�е�����
		d.set(GregorianCalendar.DAY_OF_MONTH, 1);

		// ��¼1�����ܼ�
		int weekday = d.get(GregorianCalendar.DAY_OF_WEEK);
		while(weekday!=firstDayOfWeek)
		{
			indent++;
			d.add(GregorianCalendar.DAY_OF_MONTH, -1);//���ص���һ�� �����ϸ��µ�ĩ����
			weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
		}
		// ��ӡ������������һ�б� ������4����
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(GregorianCalendar.DAY_OF_MONTH, 1);
			weekday = d.get(GregorianCalendar.DAY_OF_WEEK);
		} while (weekday != firstDayOfWeek);
		// ѭ������˵��Ӧ�ÿ�ʼ��ӡ��һ���� ���Ի���Ҫ����
		System.out.println();

		// �ڶ�����Ҫ�ȴ�ӡ���� ÿ�δ�ӡ4���ո� ע�����ĸ���
		for (int i = 0; i < indent; i++)
			System.out.print("    ");

		// ��ӡ����������������µĵ�һ�� �������ô���� ʱ��Ӧ��������һ�ܵĵ�һ�� ��println���е���
		// System.out.println(d.getTime());
		d.set(GregorianCalendar.DAY_OF_MONTH, 1);

		// ��ӡ���ڱ� ����ӡ������»����ʼ��¼����һ����ʱ
		do {
			int day = d.get(GregorianCalendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			// ����ǵ������ӡһ��* ����ʹ�һ���ո񱣳ֶ���
			if (day == today)
				System.out.print("*");
			else
				System.out.print(" ");

			// ��������
			d.add(GregorianCalendar.DAY_OF_MONTH, 1);
			weekday = d.get(GregorianCalendar.DAY_OF_WEEK);

			// �ж��Ƿ�����һ�� ����� ��Ҫ����
			if (weekday == firstDayOfWeek)
				System.out.println();
		} while (d.get(GregorianCalendar.MONTH) == month);

		// Ҫ�����һ��û���� �ۻ�һ��
		if (weekday != firstDayOfWeek)
			System.out.println();
	}
}
