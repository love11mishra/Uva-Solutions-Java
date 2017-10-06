
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva11286 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st=new StringTokenizer("");
	
	
    public static void main(String[] args) throws IOException 
	{
	      PrintWriter op = new PrintWriter(System.out);
		  while(true)
		  {
			  int t = Integer.parseInt(br.readLine());
			  if(t == 0)break;
			  TreeMap<String,Integer> treemap = new TreeMap();
			  while(t-->0)
			  {
				  st = new StringTokenizer(br.readLine());
				  ArrayList<Integer> set = new ArrayList();
				  while(st.hasMoreTokens())
					  set.add(Integer.parseInt(st.nextToken()));
				  Collections.sort(set);
				  String set1 = set.toString();
				  if(treemap.containsKey(set1))
					  treemap.put(set1,treemap.get(set1)+1);
				  treemap.putIfAbsent(set1,1);
			  }
			  int maxValue = 0;
			  for(Map.Entry<String, Integer> entry:treemap.entrySet())
			  {
				  if(entry.getValue()>maxValue)maxValue = entry.getValue();
				  //op.println(entry.getKey()+" /"+entry.getValue());
			  }
			  int count=0;
			  for(Map.Entry<String, Integer> entry:treemap.entrySet())
			  {
				  if(entry.getValue()==maxValue)count+=maxValue;
			  }
			  op.println(count);
		  }
		 op.close();
	}

}







