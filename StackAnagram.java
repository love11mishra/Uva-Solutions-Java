import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StackAnagram {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st=new StringTokenizer("");


    static void anagram(String s1, String s2, String stack, String instr) {
        if (s2.isEmpty()) {
            if (s1.isEmpty() && stack.isEmpty()) {
                System.out.println(instr.trim());
            }
            return;
        }
        if (!s1.isEmpty()) {
            anagram(s1.substring(1), s2, s1.charAt(0) + stack, instr + "i ");
        }
        if (!stack.isEmpty() && stack.charAt(0) == s2.charAt(0)) {
            anagram(s1, s2.substring(1), stack.substring(1), instr + "o ");
        }
    }

    static void anagram(String s1, String s2) {
        System.out.println("[");
        anagram(s1, s2, "", "");
        System.out.println("]");
    }

    public static void main(String args[]) throws IOException {
        
    	//st = new StringTokenizer(br.readLine());
    	Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			String s1 = in.next();
			//st = new StringTokenizer(br.readLine());
			String s2 = in.next();
			
			anagram(s1,s2);
		}
    	//anagram("madam", "adamm");
        //anagram("bahama", "bahama");
        //anagram("long", "short");
        //anagram("eric", "rice");
        //anagram("ericc", "rice");
    }
}