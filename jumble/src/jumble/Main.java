package jumble;
/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * SUCCESS!!! AT LAST
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.util.*;

public class Main {
	
	static String originalWord;
	static int l;
	static String combinations[];
	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("////////////JUMBLE//////////");
		System.out.println("-----------Created by - Abir Ganguly.");
		System.out.println("Enter the word:");
		originalWord=sc.nextLine();
		l=originalWord.length();
		
		int number_of_times_loop_will_run=factorial(l);
		int loopVariable=0;
		int i;
		combinations=new String[factorial(l)];
		String newWord=originalWord;
		int x=0;
		while(loopVariable<number_of_times_loop_will_run) {
			for(i=(l-1);i>=1;i--) {
				newWord=transferCharacters(newWord,i,(i-1));
				combinations[x]=newWord;
				x=x+1;
			}
			loopVariable=loopVariable+(l-1);
		}
		display();
	}
	
	static void display() {
		int i;
		for(i=0;i<combinations.length;i++) {
			System.out.println(combinations[i]);
		}
	}
	static String transferCharacters(String string_to_do_operations_with,int initial_position,int final_position) {
		String result=string_to_do_operations_with;
		int len=string_to_do_operations_with.length();
		int i;
		char char0=string_to_do_operations_with.charAt(initial_position);
		char char1=string_to_do_operations_with.charAt(final_position);
		String before=string_to_do_operations_with.substring(0,final_position);
		String after=string_to_do_operations_with.substring((initial_position+1));
		result=before+char0+char1+after;
		return result;
	}
	static int factorial(int x) {
		int i;
		int fact=1;
		for(i=1;i<=x;i++) {
			fact=fact*i;
		}
		return fact;
	}
}
