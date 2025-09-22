package com.abhishek.journalApp;

public class Test {

//	public static void main(String[] args) {
//		String str = "Hello";
//		String rev = "";
//		for(int i=str.length() -1; i>=0;i--) {
//			rev = rev + str.charAt(i);
//		}
//		System.out.println(rev);
//	}
	
    public static void main(String[] args) {
        String original = "hello";
        char[] chars = original.toCharArray(); // Convert string to character array
        for (char c : chars) {
			System.out.println(c);
		}
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Swap characters using a temporary variable
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(chars);
        System.out.println("Reversed string: " + reversed); // Output: olleh
    }
}
