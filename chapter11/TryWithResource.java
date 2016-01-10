package chapter11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			try(Scanner in=new Scanner(new FileInputStream("D:/ff/aa.txt"));
					PrintWriter out=new PrintWriter("D:/ff/bb.txt")) 
			{
				while(in.hasNext())
					out.println(in.nextLine().toUpperCase());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
