import java.util.*;
import java.io.*;

public class lifeguards{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		int n = Integer.parseInt(br.readLine());
		int[][] cows = new int[n][2];
		int startTime = Short.MAX_VALUE;
		int endTime = Short.MIN_VALUE;
		for(int i =0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			cows[i][0] = a;
			cows[i][1] = b;
			startTime = Math.min(a,startTime);
			endTime = Math.max(b,endTime);
		}
		short[] time = new short[endTime];
		for(int i = 0;i<n;i++){
			for(int j = cows[i][0];j<cows[i][1];j++){
				time[j]++;
			}
		}
		
		//printTime(time,startTime, endTime);
		
		float maxPercentage = -1f;
		ArrayList<Integer> cowsWithMostOverlap = new ArrayList<Integer>();
		int minSprawl = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++){
			int overlapAmountI = 0;
			float overlapPercentage = 0;
			for(int j = cows[i][0];j<cows[i][1];j++){
				if(time[j]>1) overlapAmountI++;
			}
			int totalTime = cows[i][1] - cows[i][0];
			
			overlapPercentage = ((float)overlapAmountI/totalTime);
			//System.out.println("Overlap for: "+i+" is "+overlapPercentage);
			if(overlapPercentage > maxPercentage){
				maxPercentage = overlapPercentage;
				cowsWithMostOverlap = new ArrayList<Integer>();
			}
			if(overlapPercentage==maxPercentage) cowsWithMostOverlap.add(i);
			minSprawl = Math.min(minSprawl,totalTime);
		}

		//System.out.println("MinSprawl: "+minSprawl);
		if(cowsWithMostOverlap.size() == 1) {
			int[] cowTime = cows[cowsWithMostOverlap.get(0)];
			for(int i = cowTime[0];i<cowTime[1];i++){
				time[i]--;
			}
		}
		else{
			for(int i =0;i<cowsWithMostOverlap.size();i++){
				int[] cowTime = cows[cowsWithMostOverlap.get(i)];
				System.out.println("Sprawl for "+i+" is "+(cowTime[1] - cowTime[0]));
				if(cowTime[1] - cowTime[0] == minSprawl){
					System.out.println("Found Min");
					for(int j = cowTime[0];j<cowTime[1];j++) time[j]--;
					break;
				}
			}
		}
		int count = 0;
		for(int i =startTime;i<endTime;i++){
			if(time[i] != 0) count++;
		}
		//printTime(time,startTime,endTime);
		pw.print(count);
		pw.close();
	}
	public static void printTime(short[] time,int start, int end){
		for(int i =start;i<end;i++){
			System.out.print(time[i]);
		}
		System.out.println();
	}
}
