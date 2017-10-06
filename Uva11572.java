
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Uva11572 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st=new StringTokenizer("");
	
	
    public static void main(String[] args) throws IOException 
	{
	      PrintWriter op = new PrintWriter(System.out);
		  int i = Integer.parseInt(br.readLine());
		  while(i-->0)
		  {
			  int num = Integer.parseInt(br.readLine());
			  HashMap<Integer, Integer> map = new HashMap();
			  int max = 0, start = 0;
			  for(int j=0;j<num;j++)
			  {
				  int x = Integer.parseInt(br.readLine());
				  if(map.containsKey(x))
				  {
					  int pos = map.get(x);
					  if(pos>=start)
					  {
						  start = pos+1;
					  }
				  }
				  max = Math.max(max,j-start+1);
				  map.put(x,j);
			  }
			  op.println(max);
		  }
	      op.close();
	}

}







