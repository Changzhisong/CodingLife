package song.code;

import java.util.HashMap;

public class LongestSubstringNoRepeat {

	public static void main(String[] args) {
		System.out.println(longestSubstring("a"));
	}

	
	
	/*
	 * 要求:最长非重复子串长度
	 * 解答：用滑动窗口[startIndex,i)标定非重复子串。
	 * 
	 */
	
	public static int longestSubstring(String s) {
		if(s.length()==0){
			return 0;
		}
			
		int startIndex = 0;//不重复字符串的开头
		int maxlen = 0;
		HashMap<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (charMap.containsKey(s.charAt(i))) {
				startIndex = Math.max(charMap.get(s.charAt(i)) + 1, startIndex);
			}
			charMap.put(s.charAt(i), i);
			maxlen = Math.max(maxlen, i - startIndex + 1);
		}
		return maxlen;

	}

}
