/* Author Lavlesh */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva10226 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st=new StringTokenizer("");
	
	    public static void main(String[] args) throws IOException 
	{
	      Scanner in  = new Scanner(System.in);
		  PrintWriter op = new PrintWriter(System.out);
		  int t = Integer.parseInt(br.readLine());
		  br.readLine();
		  while(t-->0)
		  {
			  TreeMap<String, Double> treemap = new TreeMap();
			  String key ;
			  
			  int count=0;
			  while((key = br.readLine())!= null)
			  {
				 if(key.equals(""))break;
				  if(treemap.containsKey(key))
				  {
					  treemap.put(key,treemap.get(key)+1);
				  }
				  else treemap.put(key,1.0);
				 count++;
			  }
			 for(Map.Entry<String,Double> entry:treemap.entrySet())
			 {
				 String k = entry.getKey();
				 Double v = entry.getValue();
				 double per = (v*100)/count;
				 op.print(k+" ");
				 op.printf("%.4f",per);
				 op.println();
			 }
			 if(t>0)op.println();
		  }
		 op.close();
	}

}







