/*
ID: minyoun1
LANG: JAVA
TASK: milk3
 */
import java.util.*;
import java.io.*;
public class milk3 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("milk3.in")));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		int a =in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		HashSet<String> done = new HashSet<String>();
		TreeSet<Integer> res = new TreeSet<Integer>();
		Queue<cur> q = new LinkedList<cur>();
		q.add(new cur(0,0,c));
		while(!q.isEmpty())
		{
			cur temp = q.poll();
			int tempa = temp.a;
			int tempb = temp.b;
			int tempc = temp.c;

			String all = tempa+" "+tempb+" "+tempc;
			//System.out.println(all);
			if(done.contains(all))
				continue;
			if(tempa==0)
				res.add(tempc);
			done.add(all);
			if(tempa!=0)
			{
				if(tempb!=b)
				{
					if(tempb+tempa>b)
					{
						q.add(new cur(tempa-(b-tempb),b,tempc));
					}
					else
					{
						q.add(new cur(0,tempb+tempa,tempc));
					}
				}
				if(tempc!=c)
				{
					if(tempc+tempa>c)
					{
						q.add(new cur(tempa-(c-tempc),tempb,c));
					}
					else
					{
						q.add(new cur(0,tempb,tempc+tempa));
					}
				}
			}
			if(tempb!=0)
			{
				if(tempa!=a)
				{
					if(tempb+tempa>a)
					{
						q.add(new cur(a,tempb-(a-tempa),tempc));
					}
					else
					{
						q.add(new cur(tempa+tempb,0,tempc));
					}
				}
				if(tempc!=c)
				{
					if(tempc+tempb>c)
					{
						q.add(new cur(tempa,tempb-(c-tempc),c));
					}
					else
					{
						q.add(new cur(tempa,0,tempc+tempb));
					}
				}
			}
			if(tempc!=0)
			{
				if(tempa!=a)
				{
					if(tempc+tempa>a)
					{
						q.add(new cur(a,tempb,tempc-(a-tempa)));
					}
					else
					{
						q.add(new cur(tempa+tempc,tempb,0));
					}
				}
				if(tempb!=b)
				{
					if(tempc+tempb>b)
					{
						q.add(new cur(tempa,b,tempc-(b-tempb)));
					}
					else
					{
						q.add(new cur(tempa,tempb+tempc,0));
					}
				}
			}

		}
		String ans = "";
		while(!res.isEmpty())
		{
			ans+=res.first()+" ";
			res.remove(res.first());
		}
		out.println(ans.trim());
		out.close();
	}
	static class cur
	{
		int a,b,c;
		public cur(int a,int b,int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

}
