public class Palindrome
{
	public static void main(String[] args)
	{
		testPalindrome(null);
		testPalindrome("");
		testPalindrome("testing");
		testPalindrome("race car$#%^");
		testPalindrome("A car, a man, a maraca.");
		testPalindrome("Slap a ham on Omaha, pals.");
		testPalindrome("Space cats");
	}

	// We'll separate this from the display method for modularity
	public static boolean isPalindrome(String input)
	{
		// Wasn't specified how to handle these cases, but we'll consider them
		// non-palindromes here
		if (input == null || input.length() == 0)
		{
			return false;
		}

		// We're ignoring any characters that are not alphanumeric
		input = input.replaceAll("[^A-Za-z0-9]", "");
		// Just reverse the string and compare it to the original
		return input.equalsIgnoreCase(new StringBuffer(input).reverse()
		        .toString());
	}

	public static void testPalindrome(String input)
	{
		System.out.print("\"" + input + "\" IS ");
		System.out.println(isPalindrome(input) ? "a palindrome."
		        : "NOT a palindrome");
	}
}