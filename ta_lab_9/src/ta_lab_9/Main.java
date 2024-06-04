package ta_lab_9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static int[][] readFile(String filename) throws IOException {

		int ch;

		FileReader fr = null;
		try {
			fr = new FileReader(filename);
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}
		StringBuffer sb = new StringBuffer();
		while ((ch = fr.read()) != -1)
			sb.append((char) ch);
		fr.close();

		String[] s = sb.toString().split("\n");
		int[][] ints = new int[Integer.parseInt(s[0].split(" ").clone()[1] + 1)][2];
		for( int i = 0; i < s.length; ++i) {
			String[] t = s[i].split(" ");
			ints[i][0] = Integer.parseInt(t[0]);
			ints[i][1] = Integer.parseInt(t[1]);
		}
		return ints;
	}


	public static void main(String[] args) {
		int[][] ints = null;
		String filename = "D:\\Programing\\My_Java_Programs\\eclipse-workspace\\ta_lab_9\\src\\ta_lab_9";
		try {
			ints = readFile(filename + "\\input_5.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = ints[0][1];
		int W = ints[0][0];
		
		int profit[] = new int[n];
		for( int i = 1; i < n; ++i) {
			profit[i] = ints[i][0];
		}
		
		int weight[] = new int[n];
		for( int i = 1; i < n; ++i) {
			weight[i] = ints[i][1];
		}
		System.out.println("For file input_5.txt");
		System.out.println(Knapsack.knapSack(W, weight, profit, n));
	}
}
