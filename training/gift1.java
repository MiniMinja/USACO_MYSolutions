/*
ID: Minyoung Heo
LANG: JAVA
TASK: gift1
*/	
import java.io.*;
import java.util.*;
public class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		Map<String, Integer> g = new LinkedHashMap<String, Integer>();
		
		int n = Integer.parseInt(f.readLine());
		for(int i= 0; i<n; i++){
			g.put(f.readLine(), 0);
		}
		
		for(int k = 0; k < n; k++){
			String name = f.readLine();
			String temp = f.readLine();
			
			StringTokenizer st = new StringTokenizer(temp);
			
			int m = Integer.valueOf(st.nextToken());
			int d = Integer.valueOf(st.nextToken());
			
			g.put(name, g.get(name)-m);
			
			int r = 0;
			int gift = 0;
			
			if(d>0){
				r = m % d;
				gift = m / d;
			}		
			
			for(int i = 0; i < d; i++){
				String gifted = f.readLine();
				g.put(gifted, g.get(gifted)+gift);
			}
			
			g.put(name, g.get(name)+r);			
		}
		
		Iterator<String> key = g.keySet().iterator();
		
		while(key.hasNext()){
			String name = (String)key.next();
			out.println(name + " " + g.get(name));
		}
		
		out.close();
		f.close();
	}

}
