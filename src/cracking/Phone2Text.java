package cracking;

public class Phone2Text {
	private static String[] mapping = {"", "ABC", "DEF", "GHI", "JKL", "MNO",
			"PQR", "STU", "VW", "XY", "Z*#" };

	public static void combinations(int[] number, char[] buf, int numIndex) {

		for (int i = 0; i < mapping[number[numIndex]].length(); i++) {
			buf[numIndex] = mapping[number[numIndex]].charAt(i);
			if (numIndex < number.length - 1) {
				combinations(number, buf, numIndex + 1);
			} else
				System.out.println(buf);
		}
	}

	public static void main(String[] args) {
		int num[] = { 1, 5, 1, 10, 5, 5 };
		Phone2Text.combinations(num, new char[num.length], 0);
	}
}