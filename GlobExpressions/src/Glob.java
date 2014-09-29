
public class Glob {
	private String pattern = null;
	
	Glob(String pattern) {
		this.setPattern(pattern);
	}
	
	public static Glob compile(String pattern) {
		// TODO Auto-generated method stub
		
		return new Glob(pattern);
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public boolean matches(String input) {
		
		int globPos = 0;
		int inputPos = 0;
		boolean result = true;
		
		if (pattern.length() > input.length()) { // Optimization
			return false;
		}
		
		
		for (; inputPos < input.length(); inputPos++) {
			
			
			
			if(pattern.length() > globPos) { //check for going outside the pattern length				
				if(pattern.charAt(globPos) == '?' || pattern.charAt(globPos) == input.charAt(inputPos)) {
					globPos++;
					continue;
				} else {
					result = false;
					break;
				}
			} else {
				result = false;
				break;
			}
		}
			
		
				
		return result;
	}
}
