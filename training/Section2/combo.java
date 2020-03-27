/*
ID: minyoun1
LANG: JAVA
TASK: combo
*/
import java.util.*;
import java.io.*;
public class combo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("combo.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		int n = in.nextInt();
		int[] john = new int[3];
		int[] master = new int[3];
		for(int i = 0;i<3;i++)
		{
			john[i] = in.nextInt();
		}
		for(int i = 0;i<3;i++)
		{
			master[i] = in.nextInt();
		}
		int count = 0;
		for(int a = 1;a<=n;a++)
		{
			for(int b=1;b<=n;b++)
			{
				for(int c = 1;c<=n;c++)
				{
					int ja = Math.abs(john[0]-a);
					if(john[0]<a)
						ja = Math.min(ja, john[0]+(n-a));
					else
						ja = Math.min(ja, a+(n-john[0]));
					int jb = Math.abs(john[1]-b);
					if(john[1]<b)
						jb = Math.min(jb, john[1]+(n-b));
					else
						jb = Math.min(jb, b+(n-john[1]));
					int jc = Math.abs(john[2]-c);
					if(john[2]<c)
						jc = Math.min(jc, john[2]+(n-c));
					else
						jc = Math.min(jc, c+(n-john[2]));
					int ma = Math.abs(master[0]-a);
					if(master[0]<a)
						ma = Math.min(ma, master[0]+(n-a));
					else
						ma = Math.min(ma, a+(n-master[0]));
					int mb = Math.abs(master[1]-b);
					if(master[1]<b)
						mb = Math.min(mb, master[1]+(n-b));
					else
						mb = Math.min(mb, b+(n-master[1]));
					int mc = Math.abs(master[2]-c);
					if(master[2]<c)
						mc = Math.min(mc, master[2]+(n-c));
					else
						mc = Math.min(mc, c+(n-master[2]));
					//System.out.println(ja + " " + jb + " " + jc + " : " + ma+" "+mb+" "+ mc );
					if((ja<=2&&jb<=2&&jc<=2)|| (ma<=2&&mb<=2&&mc<=2))
					{
						//System.out.println(a + " " + b + " " +c);
						count++;
					}

				}
			}
		}
		out.println(count);
		out.close();

	}

}
