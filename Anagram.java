/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		// System.out.println(isAnagram("silen","listen"));  // true


		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	 public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);	
		str1 = spaces(str1);
		str2 = spaces(str2);
		int sub = 0;
		if (str1.length() != str2.length()){
			return false;
		}
		for (int i = 0 ; i < str1.length() ; i++){
			boolean isAna = false;
			for(int j = 0; j < str2.length(); j ++){
				if (str1.charAt(i) == str2.charAt(j)){
					isAna = true;
					sub = j;
				}
			}
			if(!isAna){
				return false;
			}
			str2 = str2.substring(0, sub) + str2.substring(sub + 1);
		}
			return true;

		}
	
	

	 
	 public static String spaces (String str){
		String spaces = "";
		for (int i = 0 ; i < str.length() ; i++){
			if(str.charAt(i) != 32){
				spaces += str.charAt(i);
			}
		}
		return spaces;
	 }
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "what no way"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String newStr = "";
		str = str.toLowerCase();
		for (int i = 0 ; i < str.length() ; i++){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) == 32 ){
				newStr += str.charAt(i);
			}
		}

		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String newstr = "";
		int stringToLength = str.length();

		for (int i = 0 ; i < stringToLength ; i ++){
			int randomNum = (int)((str.length()) * Math.random());
			newstr += str.charAt(randomNum);
			str = str.substring(0, randomNum) + str.substring(randomNum + 1);

		}
	
		return newstr;
	}
}
