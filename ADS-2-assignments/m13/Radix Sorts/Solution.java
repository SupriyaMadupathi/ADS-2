import java.util.Scanner;
import java.util.Arrays;
public final class Solution {
	
	private Solution() {
	}
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