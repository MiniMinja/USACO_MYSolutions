/*
ID: Minyoung Heo
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

public class transform{
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(new File("transform.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("transform.out"));

    int N = in.nextInt();
    int[][] grid1 = new int[N][N];
    getGrid(in, grid1, N);
    int[][] grid2 = new int[N][N];
    getGrid(in, grid2, N);

    int[][] rotation1 = rotate90(grid1, N);
    int[][] rotation2 = rotate180(grid1, N);
    int[][] rotation3 = rotate270(grid1, N);
    if(matches(rotation1, grid2, N)) pw.println(1);
    else if(matches(rotation2, grid2, N)) pw.println(2);
    else if(matches(rotation3, grid2, N)) pw.println(3);
    else{
      int[][] reflection = reflect(grid1, N);
      if(matches(reflection, grid2, N)) pw.println(4);
      else {
        int[][] rotReflection1 = rotate90(reflection, N);
        int[][] rotReflection2 = rotate180(reflection, N);
        int[][] rotReflection3 = rotate270(reflection, N);
        if(matches(rotReflection1, grid2, N) || matches(rotReflection2, grid2, N) || matches(rotReflection3, grid2, N)) pw.println(5);
        else if(matches(grid1, grid2, N)){
          pw.println(6);
        }
        else{
          pw.println(7);
        }
      }
    }

    in.close();
    pw.close();
  }

  public static int[][] rotate90(int[][] grid, int N){
    return reverseRow(transpose(grid, N), N);
  }
  public static int[][] rotate180(int[][] grid, int N){
    return rotate90(rotate90(grid, N), N);
  }
  public static int[][] rotate270(int[][] grid, int N){
    return rotate180(rotate90(grid, N), N);
  }

  public static int[][] reflect(int[][] grid, int N){
    int[][] copy = clone(grid, N);
    for(int i = 0;i<N;i++){
      for(int j = 0;j<N/2;j++){
        int temp = copy[i][j];
        copy[i][j] = copy[i][N-j-1];
        copy[i][N-j-1] = temp;
      }
    }
    return copy;
  }

  public static boolean matches(int[][] grid1, int[][] grid2, int N){
    for(int i = 0;i<N;i++){
      for(int j = 0;j<N;j++){
        if(grid1[i][j] != grid2[i][j]) return false;
      }
    }
    return true;
  }

  public static int[][] clone(int[][] grid, int N){
    int[][] ret = new int[N][N];
    for(int i =0;i<N;i++)
      for(int j = 0;j<N;j++)
        ret[i][j] = grid[i][j];
    return ret;
  }

  public static int[][] transpose(int[][] grid, int N){
    int[][] clone = new int[N][N];
    for(int i = 0;i<N;i++){
      for(int j = 0;j<N;j++){
        clone[j][i] = grid[i][j];
      }
    }
    return clone;
  }

  public static int[][] reverseRow(int[][] grid, int N){
    int[][] clone = new int[N][N];
    for(int i = 0;i<N;i++){
      for(int j = 0;j<N;j++){
        clone[i][N-j-1] = grid[i][j];
      }
    }
    return clone;
  }

  public static void getGrid(Scanner in, int[][] grid, int N){
    for(int i = 0 ;i<N;i++){
      String line = in.next();
      for(int j = 0;j<N;j++){
        if(line.charAt(j) == '@') grid[i][j] = 1;
        else grid[i][j] = 0;
      }
    }
  }

  public static void printGrid(int[][] grid, int N){
    for(int i = 0;i<N;i++){
      System.out.println(Arrays.toString(grid[i]));
    }
  }
}
