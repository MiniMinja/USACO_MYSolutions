/*
ID: minyoun1
LANG: JAVA
TASK: wormhole
*/
import java.util.*;
import java.io.*;
public class wormhole {

	public static int[] X;
	public static int[] Y;
	public static int n;
	public static int[] partner;
	public static int[] nextright;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("wormhole.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		n = in.nextInt();
		X = new int[n+1];
		Y = new int[n+1];
		partner = new int[n+1];
		nextright = new int[n+1];
		for(int i = 1;i<=n;i++)
		{
			X[i] = in.nextInt();
			Y[i] = in.nextInt();
		}
		in.close();
		for(int i = 1;i<=n;i++)
		{
			for(int j = 1;j<=n;j++)
			{
				if(X[j]>X[i]&&Y[j]==Y[i])
				{
					if(nextright[i]==0||
					X[j]-X[i]<X[nextright[i]]-X[i])
						nextright[i] = j;
				}
			}
		}
		out.println(solve());

		out.close();
	}
	public static boolean cycle_exists()
	{
		for(int i = 1;i<=n;i++)
		{
			int pos = i;
			for(int j = 0;j<n;j++)
			{
				pos = nextright[partner[pos]];
			}
			if(pos!=0)
				return true;
		}
		return false;
	}
	public static int solve()
	{
		int i;
		int total = 0;
		for(i = 1;i<=n;i++)
		{
			if(partner[i]==0) break;
		}
		if(i>n)
		{
			if(cycle_exists())
				return 1;
			else
				return 0;
		}
		for(int j =i+1;j<=n;j++)
		{
			if(partner[j]==0)
			{
				partner[i] = j;
				partner[j] = i;
				total += solve();
				partner[i] = 0;
				partner[j] = 0;
			}
		}
		return total;

	}

}
