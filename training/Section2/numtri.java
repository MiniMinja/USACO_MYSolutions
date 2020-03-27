/*
ID: minyoun1
LANG: JAVA
TASK: numtri
*/
import java.io.*;
import java.util.*;

public class numtri {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

		int n = Integer.parseInt(in.readLine());

		int[][] triangle = new int[n][n];
		for (int i = 0; i < n; i++) {
			triangle[i] = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken() );
			}
		}

		//print(triangle);
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
			}
		}

		out.println(triangle[0][0]);
		out.close();
		System.exit(0);
	}
	static void print(int[][] a){
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}


}
