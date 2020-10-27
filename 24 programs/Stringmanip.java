package implementation;

//24.  Write JUnit tests for given code.
public class Stringmanip {
		String datum; 
		
		public Stringmanip(String datum) {
			this.datum = datum; 
		}
		
		public String upperCase() {
			return datum.toUpperCase();
		}
}
