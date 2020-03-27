/*
ID: Minyoung Heo
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

public class milk{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("milk.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("milk.out"));

    String line1[] = in.readLine().split(" ");
    int N = Integer.parseInt(line1[0]);
    int M = Integer.parseInt(line1[1]);
    int[][] ps = new int[M][2];
    for(int i = 0;i<M;i++){
      String line[] = in.readLine().split(" ");
      ps[i][0] = Integer.parseInt(line[0]);
      ps[i][1] = Integer.parseInt(line[1]);
    }
    Arrays.sort(ps, new Comparator<int[]>(){
      public int compare(int[] a, int[] b){
        return a[0] - b[0];
      }
    });
    int total = 0;
    int i = 0;
    while(N > 0){
      while(ps[i][1] == 0) i++;
      int unitsBought = Math.min(ps[i][1], N);
      total += unitsBought * ps[i][0];
      N -= unitsBought;
      ps[i][1] -= unitsBought;
    }
    //System.out.println(Arrays.deepToString(ps));
    pw.println(total);

    in.close();
    pw.close();
  }
}
