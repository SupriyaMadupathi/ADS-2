import java.util.Scanner;
import java.util.Arrays;
/**
 * { Solution}.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused constructor.
	}
	/**
	 * Client Program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		LSD lsd = new LSD();
		String[] tokens = new String[n];
		for (int i = 0; i < n; i++) {
			tokens[i] = sc.nextLine();
		}lsd.sort(tokens, tokens[0].length());
		System.out.println(Arrays.toString(tokens));
	}
}