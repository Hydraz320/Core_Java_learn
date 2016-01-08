package chapter4;

import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Ӧ��GregorianCalendar�����������
 * @author Geec
 * @version 1.0
 */
public class Calendar {

	public static void main(String[] args) {
		//�޸ĵ������� �ĳ�����
		Locale.setDefault(Locale.US);
		//������ǰʱ��
		GregorianCalendar d=new GregorianCalendar();
		
		//��¼�����¡���
		int today=d.get(GregorianCalendar.DAY_OF_MONTH);
		int month=d.get(GregorianCalendar.MONTH);
		
		//���������ó�1�� �Ӷ��ҵ�Ӧ�е�����
		d.set(GregorianCalendar.DAY_OF_MONTH, 1);
		
		//��¼1�����ܼ�
		int weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
		
		//��ȡ���ؼ�ʱ��ʽ�� һ�ܵĵ�һ�����ܼ�
		int firstDayOfWeek=d.getFirstDayOfWeek();
		
		//�����һ��������������
		int indent=0;
		while(weekday!=firstDayOfWeek)
		{
			indent++;
			d.add(GregorianCalendar.DAY_OF_MONTH, -1);//���ص���һ�� �����ϸ��µ�ĩ����
			weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
		}
		//��ӡ������������һ�б� ������4����
		String[] weekdayNames=new DateFormatSymbols().getShortWeekdays();
		do
		{
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(GregorianCalendar.DAY_OF_MONTH, 1);
			weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
		}while(weekday!=firstDayOfWeek);
		//ѭ������˵��Ӧ�ÿ�ʼ��ӡ��һ���� ���Ի���Ҫ����
		System.out.println();
		
		//�ڶ�����Ҫ�ȴ�ӡ���� ÿ�δ�ӡ4���ո� ע�����ĸ���
		for(int i=0;i<indent;i++)
			System.out.print("    ");
		
		//��ӡ����������������µĵ�һ�� �������ô���� ʱ��Ӧ��������һ�ܵĵ�һ�� ��println���е���
		//System.out.println(d.getTime());
		d.set(GregorianCalendar.DAY_OF_MONTH, 1);
		
		//��ӡ���ڱ� ����ӡ������»����ʼ��¼����һ����ʱ
		do
		{
			int day=d.get(GregorianCalendar.DAY_OF_MONTH);
			System.out.printf("%3d",day);
			//����ǵ������ӡһ��* ����ʹ�һ���ո񱣳ֶ���
			if(day==today)
				System.out.print("*");
			else
				System.out.print(" ");
			
			//��������
			d.add(GregorianCalendar.DAY_OF_MONTH, 1);
			weekday=d.get(GregorianCalendar.DAY_OF_WEEK);
			
			//�ж��Ƿ�����һ�� ����� ��Ҫ����
			if(weekday==firstDayOfWeek)
				System.out.println();
		}while(d.get(GregorianCalendar.MONTH)==month);
		
		//Ҫ�����һ��û���� �ۻ�һ��
		if(weekday!=firstDayOfWeek)
			System.out.println();
	}

}
