
/*
ID: minyoun1
LANG: JAVA
PROG: sprime
 */

import java.io.*;
import java.util.*;


public class sprime {

	static int[] ribs = new int[1000];

	static boolean isPrime(int p)
	{
		if ( p ==1)	return false;
		for (int i = 2; i <= Math.sqrt(p); i++)
			if(p%i == 0) return false;

		return true;
	}

	static void primeRib()
	{
		int start = 0;
		int end = 1;
		int index = 0;

		for (int i = start; i < end; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				int num = ribs[i]*10 + j;
				if (num > 100000000) return;
				if(isPrime(num)) ribs[index++] = num;
			}
			start = end;
			end = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"sprime.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());

		primeRib();

		for(int i = 0; i < ribs.length; i++)
		{
			if (ribs[i] > Math.pow(10, n-1) && ribs[i] < Math.pow(10,n))
				out.println(ribs[i]);
		}
		in.close();
		out.close();
		System.exit(0);
	}
}
