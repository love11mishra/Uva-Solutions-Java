
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Uva10264 {
	
	static int max(int a, int b){return a>b?a:b;}
	public static void main(String[] args) throws IOException,NullPointerException {
		Scanner in  = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(in.hasNextInt()){
			int n = in.nextInt();
			int []a = new int[(int)Math.pow(2,n)];
			int [][]potency = new int[a.length][2];
			for(int i=0;i<a.length;i++)
			{
				a[i] = in.nextInt();
			}
			for(int i=0;i<a.length;i++)
			{   
				//potency[i][0]=a[i];
				for(int j=0;j<n;j++)
				{
					potency[i][0]+=a[(i^(1<<j))];
					//System.out.println(i+" "+(i^(1<<j)));
				}
				potency[i][1]=potency[i][0];
				//System.out.println(potency[i][0]);
				for(int j=0;j<n;j++)
				{
					int x = potency[i][0]+potency[(i^(1<<j))][0];
					if(x>potency[i][1])potency[i][1]=x;
				}
			}
			int result = 0;
			for(int i = 0;i<a.length;i++)
			{
				result = max(result,potency[i][1]);
			}
			System.out.println(result);
		}
		
	}

}







