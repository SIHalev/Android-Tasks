public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Glob glob = Glob.compile("abc?");
			
		System.out.println(glob.matches("abc")); //false => ? means exactly one character
		System.out.println(glob.matches("abcd")); //true
		System.out.println(glob.matches("abcde"));
		
		System.out.println("-------------------------");
		
		Glob glob2 = Glob.compile("a*d");
		System.out.println(glob2.matches("abcd"));
		System.out.println(glob2.matches("abcujawiohtguahwuthawitthawuithawuthaithawtawutd"));
		System.out.println(glob2.matches("abcdej"));
		System.out.println(glob2.matches("abcujawiohtguahwuthawitthawuithawuthaithawtawutd1"));
	}
}
