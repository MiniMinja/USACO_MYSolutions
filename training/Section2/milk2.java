/*
ID: Minyoung Heo
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

public class milk2{
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(new File("milk2.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("milk2.out"));

    int[] milk = new int[1_000_000+1];
    int N = in.nextInt();
    int start = milk.length;
    int end = -1;
    for(int i = 0;i<N;i++){
      int s = in.nextInt();
      int e = in.nextInt();
      milk[s]++;
      milk[e]--;
      start = Math.min(s, start);
      end = Math.max(e, end);
    }
    int currentCows = 0;

    int ltCowMilked = 0;
    int ltNoCowMilked = 0;
    int cowMilked = 0;
    int noCowMilked = 0;
    for(int i = start;i<end;i++){
      currentCows+=milk[i];
      if(currentCows > 0){
        noCowMilked = 0;
        cowMilked++;
        ltCowMilked = Math.max(cowMilked, ltCowMilked);
      }
      else{
        cowMilked = 0;
        noCowMilked++;
        ltNoCowMilked = Math.max(noCowMilked, ltNoCowMilked);
      }
    }
    pw.println(ltCowMilked+" "+ltNoCowMilked);
    in.close();
    pw.close();
  }
}
