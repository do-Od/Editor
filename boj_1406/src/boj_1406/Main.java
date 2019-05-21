package boj_1406;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String str = sc.nextLine();	//������ ���ڿ�
		
		Stack<Character> left=new Stack<Character>();
		Stack<Character> right=new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));	//�켱 st1�� �ִ´�.			
		}
		
		int num = sc.nextInt();	//���� ��ų ��ɾ� ����
		
		for(int i=0;i<=num;i++)
		{
			String[] str2 =sc.nextLine().split(" ");
			
			if(str2[0].equals("L"))	//Ŀ���� �������� ��ĭ
			{
				if(!left.isEmpty())
				{
					right.push(left.pop());	//5
				}
			}
			else if(str2[0].equals("D"))	//Ŀ���� ���������� ��ĭ
			{
				if(!right.isEmpty())
				{
					left.push(right.pop());
				}
			}
			else if(str2[0].equals("B"))	//Ŀ�� ���ʿ� �ִ� ���ڸ� ����
			{
				if(!left.isEmpty())
				{
					left.pop();
				}
			}else if(str2[0].equals("P"))	//Ŀ�� ���ʿ� ���� �߰�
			{
				left.push(str2[1].charAt(0));
			}
		}
		
		while(!left.empty())
		{
			right.push(left.pop());
		}
		
		StringBuilder finish = new StringBuilder();
		
		while(!right.empty())
		{
			finish.append(right.pop());
		}
		
		System.out.println(finish);
	}
}
