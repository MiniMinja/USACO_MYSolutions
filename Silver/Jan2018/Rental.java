
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class rental {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] output = new int[n];
		for(int i =0;i<n;i++) {
			output[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(output);
		
		int[][] store = new int[m][2];
		for(int i =0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(store, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[1] < arr2[1]) return 1;
				else if(arr1[1] == arr2[1] && arr1[0] < arr2[0]) return 1;
				else return -1;
			}
		});
		
		Integer[] rent = new Integer[r];
		for(int i =0;i<r;i++) {
			rent[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rent,new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
		BigInteger answer = new BigInteger("0");
		for(int i =0;i<n;i++) {
			//gp is gallonsProduced
			int gp = output[i];
			
			//sP is potential store profit
			//ga is gallons acceptable, the remaining gallons best store is willing to accept
			BigInteger sp = BigInteger.ZERO;
			int ga = -1;
			//the change that takes place if store is taken
			int[] change = new int[2];
			for(int j = gp;j>0;j--) {
				//bs is the best store available
				int bs = 0;
				while(store[bs][0] == 0) bs++;
				
				ga = store[bs][0];
				//p is price per gallon of best store
				int p = store[bs][1];
				while(ga > 0 && gp >0) {
					sp = sp.add(new BigInteger(""+p));
					ga--;
					gp--;
				}
				change[0] = ga;
				change[1] = store[bs][1];
			}
			
			//ro is rental that is open for sale
			int ro = 0;
			while(ro != 0) ro++;
			//bR is best rental
			int bR = rent[ro];
			
			if(sp.longValue() < bR) {
				rent[ro] = 0;
				answer = answer.add(new BigInteger(""+bR));
			}
			else {
				answer = answer.add(sp);
				int bs = 0;
				while(store[bs][0] == 0) bs++;
				store[bs] = change;
			}
		}
		System.out.println(answer);
		pw.print(answer);
		pw.close();
	}
}
