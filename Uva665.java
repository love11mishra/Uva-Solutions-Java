import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva665 {
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
	public static void main(String[] args) 
	{
		PrintWriter op = new PrintWriter(System.out);
		int M = Integer.parseInt(next());
		
		int x1 = M;
		while(M-- > 0)
		{
			int n = Integer.parseInt(next());
			int k = Integer.parseInt(next());
			boolean [] ar = new boolean[n+1];
			for(int i=0;i<k;i++)
			{
				int x = Integer.parseInt(next());
				//op.println(x);
				int [] ai = new int[x*2];
				for(int j = 0; j < 2*x; j++)
				{
					ai[j]=Integer.parseInt(next());
				}
				String s = next();
				if(s.equals("="))
				{
					for( int j=0;j<ai.length;j++)
					{
						ar[ai[j]] = true;
					}
				}
			}
			int indx = -1,count = 0;
			for(int i=1;i<=n;i++)
			{
				
				if(!ar[i])
				{
					indx = i;
					count++;
				}
			}
			//if(M!=x1)op.println();
			if(count==1)
			{
				op.println(indx+"\n");
			}
			else op.println("0\n");
			
		}
		
        op.close();
	}

}
