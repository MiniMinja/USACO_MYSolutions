/*
ID: minyoun1
LANG: JAVA
TASK: castle
*/

import java.util.*;
import java.io.*;

public class castle{
  public static int rows, cols;
  public static int[][] data;
  public static boolean[][] visited;
  public static int[][] roomNumber;
  public static ArrayList<Integer> roomSize;

  public static int breakWall(int i, int j, int type){//0 - N, 1- E
    if(type == 0){
      if((data[i][j]&2) != 0){
        if(roomNumber[i][j] != roomNumber[i-1][j]){
          return roomSize.get(roomNumber[i][j]) + roomSize.get(roomNumber[i-1][j]);
        }
      }
    }
    else{
      if((data[i][j]&4) != 0){
        if(roomNumber[i][j] != roomNumber[i][j+1]){
          return roomSize.get(roomNumber[i][j]) + roomSize.get(roomNumber[i][j+1]);
        }
      }
    }
    return -1;
  }

  public static int[] breakWalls(){
    int max = -1;
    int r = -1;
    int c = -1;
    int type = -1;
    for(int j = 0;j<cols;j++){
      for(int i = rows-1;i>=0;i--){
        int total_N = 0;
        if(i > 0) total_N = breakWall(i, j, 0);
        if(total_N > max) {
          max = total_N;
          r = i;
          c = j;
          type = 0;
        }
        int total_E = 0;
        if(j < cols-1) total_E = breakWall(i, j, 1);
        if(total_E > max) {
          max = total_E;
          r = i;
          c = j;
          type = 1;
        }
      }
    }
    int[] arr = {max, r, c, type};
    return arr;
  }

  public static int dfs(int i, int j, int d){
    if(visited[i][j]) return 0;
    else{
      //System.out.println(i + " " + j);
      visited[i][j] = true;
      roomNumber[i][j] = d;
      int size = 1;
      if((data[i][j]&1) == 0) size+= dfs(i, j-1, d);
      if((data[i][j]&2) == 0) size+= dfs(i-1, j, d);
      if((data[i][j]&4) == 0) size+= dfs(i, j+1, d);
      if((data[i][j]&8) == 0) size+= dfs(i+1, j, d);
      return size;
    }
  }

  public static int findNumRooms(){
    int data = 0;
    for(int i = 0;i<rows;i++)
      for(int j = 0;j<cols;j++)
        if(!visited[i][j]){
          //System.out.println("New Vertex!");
          roomSize.add(dfs(i, j, data++));
        }
    return roomSize.size();
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("castle.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("castle.out"));

    StringTokenizer st = new StringTokenizer(br.readLine());
    cols = Integer.parseInt(st.nextToken());
    rows = Integer.parseInt(st.nextToken());
    data = new int[rows][cols];
    visited = new boolean[rows][cols];
    roomNumber = new int[rows][cols];
    roomSize = new ArrayList<Integer>();
    for(int i = 0;i<rows;i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0;j<cols;j++){
        data[i][j] = Integer.parseInt(st.nextToken());
        roomNumber[i][j] = -1;
      }
    }

    pw.println(findNumRooms());
    int[] max_data = breakWalls();
    System.out.println(roomSize);
    Collections.sort(roomSize);
    int max_roomSize = roomSize.get(roomSize.size()-1);
    pw.println(max_roomSize);
    pw.println(max_data[0]);
    pw.println((max_data[1] + 1) + " " + (max_data[2] + 1) + " " + (max_data[3] == 0 ? 'N' : 'E'));

    br.close();
    pw.close();
  }
}
