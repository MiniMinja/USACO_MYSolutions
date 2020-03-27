import java.util.*;
import java.io.*;

public class leftout{
  //R = 0, L = 1
  public static int[][] cows;
  public static int N;
  public static int numR, numC;

  public static void flip(int i, int j){
    if(cows[i][j] == 0) cows[i][j] = 1;
    else cows[i][j] = 0;
  }

  //willFlipCol = false will flip row, otherwise flip col
  public static int tryFlip(int i, boolean willFlipCol){
    for(int j = 0;j<N;j++){
      if(willFlipCol) flip(j, i);
      else flip(i, j);
    }
    return -1;
  }

  public static int absDiff() { return Math.abs(numR - numC);}

  public static String solve(){
    tryFlip(0, false);
    return "";
  }

  public static void init() throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("leftout.in"));

    N = Integer.parseInt(br.readLine());
    cows = new int[N][N];
    for(int i = 0;i<N;i++){
      String line = br.readLine();
      for(int j = 0;j<N;j++){
        if(line.charAt(j) == 'R'){
          numR++;
          cows[i][j] = 0;
        }
        else{
          numC++;
          cows[i][j] = 1;
        }
      }
    }

    br.close();
  }

  public static void main(String[] args) throws IOException{
    PrintWriter pw = new PrintWriter(new FileWriter("leftout.out"));
    init();
    
    pw.println(solve());
    pw.close();
  }
}
