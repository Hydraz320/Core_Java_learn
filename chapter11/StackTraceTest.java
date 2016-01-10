package chapter11;

import java.util.Scanner;

public class StackTraceTest {
	
	public static int factorial(int n)
	{
		System.out.println("factorial "+n);
		//堆栈跟踪
		Throwable t=new Throwable();
		StackTraceElement[] frames=t.getStackTrace();
		for(StackTraceElement f:frames)
			System.out.println(f);
		//递归计算的过程
		int r=0;
		if(n<=1)r=1;
		else
			r=n*factorial(n-1);
		//打印
		System.out.println("return "+r);
		//返回
		return r;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=in.nextInt();
		factorial(n);
	}

}
