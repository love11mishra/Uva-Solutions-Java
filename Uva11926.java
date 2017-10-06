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


public class Uva11926 {
	
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
		
		String s;
		while(!(s = br.readLine()).equals("0 0"))
		{
			st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			BitSet bs = new BitSet(1000000);
			boolean flag = false;
			for(int i = 0;i<n;i++)
			{
			   // BitSet bs1 = new BitSet();
			    int l = Integer.parseInt(next());
			    int u = Integer.parseInt(next());
				//bs1.set(l,u);
				if(bs.get(l,u).cardinality()>0)flag = true;
				else bs.set(l,u);
			}
			for(int i = 0;i<m;i++)
			{
				int l = Integer.parseInt(next());
			    int u = Integer.parseInt(next());
				int r = Integer.parseInt(next());
				int diff = u-l;
				for(int j = l; j<=1000000 &&!flag;j+=r)
				{
					if(bs.get(j,j+diff).cardinality()>0)flag = true;
					else bs.set(j,j+diff);
					
				}
			}
			if(flag)op.println("CONFLICT");
			else op.println("NO CONFLICT");
		}
		
		op.close();
	}

}







