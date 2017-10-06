import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva_12455 {
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
	  
	public static void main(String[] args) {
		PrintWriter op = new PrintWriter(System.out);
		int t = Integer.parseInt(next());
		while(t-->0){
			int x = Integer.parseInt(next());
			int n= Integer.parseInt(next());
			int [] a= new int[n];
			for(int i=0;i<n;i++) a[i]=Integer.parseInt(next());
			boolean flag = true;
			for(int i=0; i<(1<<n);i++){ // for each subset, O(2^n)
				int sum =0; 
				for(int j=0;j<n;j++){ // check membership, O(n)
					if((i&(1<<j))!=0) // test if bit ‘j’ is turned on in subset ‘i’?
						sum+=a[j];   // if yes, process ‘j’
				}
				if(sum==x){         // the answer is found: bitmask ‘i’
					op.println("YES "+ i);
					flag = false;
					break;
				}
			}
			if(flag)op.println("NO");
			
		}
		
		op.close();

	}

}
