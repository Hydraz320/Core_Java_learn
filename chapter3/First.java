package chapter3;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
/**
 * Just for practice
 * @author Geec
 * @version 1.0
 *
 */
import java.util.*;
public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * StringBuilder��ʹ��
		 */
		/*
		StringBuilder builder=new StringBuilder();
		builder.append("I'm ");
		builder.append("a big ass");
		builder.append("hole.");
		String s=builder.toString(); 
		System.out.println(s);
		*/
		/**
		 * Scanner��ʹ��  p55�����ڶ�ȡ�����Console��
		 */
		/*
		Scanner in=new Scanner(System.in);
		System.out.println("What is your name?");
		String name=in.nextLine();
		System.out.println("What is your age?");
		int age=in.nextInt();
		System.out.println(name);
		System.out.println(age);
		*/
		/**
		 * �ļ�������� Scanner PrintWriter
		 */
		/*
		Scanner in=null;
		try {
			in=new Scanner(Paths.get("D:\\ff\\test.txt"));
			while(in.hasNext())
			{
				System.out.println(in.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		PrintWriter out=null;
		try {
			out=new PrintWriter("D:\\ff\\test.txt");
			//out.println("another test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		 */
		/**
		 * �������+�����ӡ+����
		 */
		int[] luckyNumbers=new int[]{1,2,3,4,5};
		int[] copy=Arrays.copyOf(luckyNumbers, luckyNumbers.length);
		copy[1]=10;
		System.out.println(Arrays.toString(luckyNumbers));
		Arrays.sort(copy);
		System.out.println(Arrays.toString(copy));
	}


}
