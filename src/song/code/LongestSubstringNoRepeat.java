package song.code;

import java.util.HashMap;

public class LongestSubstringNoRepeat {

	public static void main(String[] args) {
		System.out.println(longestSubstring("a"));
	}

	
	
	/*
	 * Ҫ��:����ظ��Ӵ�����
	 * ����û�������[startIndex,i)�궨���ظ��Ӵ���
	 * 
	 */
	
	public static int longestSubstring(String s) {
		if(s.length()==0){
			return 0;
		}
			
		int startIndex = 0;//���ظ��ַ����Ŀ�ͷ
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
