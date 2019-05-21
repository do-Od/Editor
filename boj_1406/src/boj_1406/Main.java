package boj_1406;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String str = sc.nextLine();	//실행할 문자열
		
		Stack<Character> left=new Stack<Character>();
		Stack<Character> right=new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));	//우선 st1에 넣는다.			
		}
		
		int num = sc.nextInt();	//실행 시킬 명령어 갯수
		
		for(int i=0;i<=num;i++)
		{
			String[] str2 =sc.nextLine().split(" ");
			
			if(str2[0].equals("L"))	//커서를 왼쪽으로 한칸
			{
				if(!left.isEmpty())
				{
					right.push(left.pop());	//5
				}
			}
			else if(str2[0].equals("D"))	//커서를 오른쪽으로 한칸
			{
				if(!right.isEmpty())
				{
					left.push(right.pop());
				}
			}
			else if(str2[0].equals("B"))	//커서 왼쪽에 있는 문자를 삭제
			{
				if(!left.isEmpty())
				{
					left.pop();
				}
			}else if(str2[0].equals("P"))	//커서 왼쪽에 문자 추가
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
