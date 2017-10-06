import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Uva11933 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st=new StringTokenizer("");
	
	  static public String next() {
	        while (st == null || !st.hasMoreTokens()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return st.nextToken();
	    }
	
	static int max(int a, int b){return a>b?a:b;}
	public static void main(String[] args) throws IOException 
	{
		PrintWriter op = new PrintWriter(System.out);
		
		while(true)
		{
			int num = Integer.parseInt(next());
			if(num == 0)break;
			int count = 0,a=0,b=0;
			for(int i=0;i<31;i++)
			{
				if((num&(1<<i))!=0)   //check if numis divisible by 2
				{
					if((count&1)==0)
					{
						a|=(1<<i);    //set the ith bit
					}
					else
					{
						b|=(1<<i);    //set the ith bit
					}
					count++;
				}
			}
			op.println(a+" "+b);
			
		}
		
		op.close();
	}

}







