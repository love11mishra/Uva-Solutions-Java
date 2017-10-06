import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Uva230 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st=new StringTokenizer("");
	
	// Method searches the data element by name of the book
	static data searchOnList(ArrayList<data> all, String s)
	{
		for (data data1 : all) 
		{
			if(data1.book.equals(s))
			{
				return all.get(all.indexOf(data1));
			}
		}
		return new data("\"A111\" by A111"); //return some data instance to avoid null pointer exception 
      }

	public static void main(String[] args) throws IOException,NullPointerException {
		PrintWriter op = new PrintWriter(System.out);
		int end = 0;
		ArrayList<data> all = new ArrayList<data>(); //contains info about all the books
		ArrayList<data> alld = new ArrayList<data>(); //contains the currently present books in the library
		ArrayList<data> returnn = new ArrayList<data>(); //Contains the books that are returned after last shelve command
		
		//Compares the data elements first by author name and if authors are same then by book name (Used for sorting the list).
		Comparator<data> compareitems = Comparator.comparing(data::getauthor).thenComparing(data::getbook);

		while(end < 2){
			
			String str = br.readLine();
		
			//Case first if input string is END
			if(str.equals("END")) end++;
			
			//Case 2 if BORROW
			else if(str.startsWith("BORROW"))
			{
				//Taking out the book name from input string
				String s = str.substring(8,str.length()-1);
				
				data d = searchOnList(alld,s);
				if(!d.book.equals("A111")&&!d.author.equals("A111"))alld.remove(alld.indexOf(d));
			
			}
			
			//Case 3 if RETURN
			else if(str.startsWith("RETURN"))
			{
				
				String s = str.substring(8,str.length()-1);
				data d = searchOnList(all,s);
				returnn.add(d);
				alld.add(d);
			}
			
			//Case 4 if SHELVE
			else if(str.equals("SHELVE"))
			{
				//Sorting the lists
				Collections.sort(all,compareitems);
				Collections.sort(alld,compareitems);
				Collections.sort(returnn,compareitems);
				
				for (data data2 : returnn) 
				{
					int i = alld.indexOf(data2);
					
					if(i==0) op.println("Put \""+alld.get(i).book+"\" first");
					
					else op.println("Put \""+alld.get(i).book+"\" after \""+alld.get(i-1).book+"\"");
				} 
				
				op.println("END");
				
				//making the return list empty
				returnn.clear();
			}
			
			//Case 5 when to make entry of books
			else 
			{
				all.add(new data(str));
				alld.add(new data(str));
			}
		}
		
		op.close();
	}

}

//Data type to contain the data of all the books and their authors
class data{
	
	String book;
	String author;
	
	public String getbook(){
		return this.book;
	}
	
	public String getauthor(){
		return this.author;
	}
	
	public data(String s){
		
		this.book = s.substring(1,s.indexOf("by")-2);
		this.author = s.substring(s.indexOf("by")+3);
	}
	
}







