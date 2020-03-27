/*
ID: minyoun1
LANG: JAVA
TASK: skidesign
*/
import java.util.*;
import java.io.*;
public class skidesign {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("skidesign.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		int n = in.nextInt();
		int[] sizes = new int[n];
		for(int i = 0;i<n;i++)
		{
			sizes[i] = in.nextInt();
		}
		int mincost=Integer.MAX_VALUE;
		for (int i=0; i<=83; i++)
		{
			int cost=0;
			int x;
			for (int j=0; j<n; j++)
			{
				if (sizes[j]<i)
					x=i-sizes[j];
				else if (sizes[j]>i+17)
					x=sizes[j]-(i+17);
				else
					x=0;
				cost+=Math.pow(x, 2);
			}
			mincost=Math.min(mincost,cost);
		}
		out.println(mincost);
		out.close();
	}
}
