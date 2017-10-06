import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Uva514 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st=new StringTokenizer("");
	
	/*  static public String next() {
	        while (st == null || !st.hasMoreTokens()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return st.nextToken();
	    }*/
	
	//static int max(int a, int b){return a>b?a:b;}
	public static void main(String[] args) throws IOException 
	{
	//	Scanner in  = new Scanner(System.in);
		PrintWriter op = new PrintWriter(System.out);
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0)break;
			
			while(true)
				{
					st = new StringTokenizer(br.readLine());
					Stack<Integer>stack = new Stack<Integer>();
					int x = Integer.parseInt(st.nextToken());
					if(x==0) break;
					else stack.push(x);
					
					while(st.hasMoreTokens())
							stack.push(Integer.parseInt(st.nextToken()));
					
					
					Stack<Integer> stack2 = new Stack<Integer>();
					stack2.push(stack.pop());
					int p = n;
					while(true)
					{
						if(stack2.peek() == p)
						{
							while(!stack2.isEmpty()&&stack2.peek()==p)
							{
								stack2.pop();
								p--;
							}
						}
						
						
						if(stack.isEmpty()&&stack2.isEmpty())
						{
							op.println("Yes");break;
						}
						else if(stack.isEmpty()&&!stack2.isEmpty())
						{
							op.println("No");break;
						}
						if(!stack.isEmpty())stack2.push(stack.pop());
						
					}
					
				}
				
			    }
		
		
		op.close();
	}

}







