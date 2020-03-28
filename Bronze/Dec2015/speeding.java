import java.io.*;
import java.util.*;

public class speeding{

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter(new File("speeding.out")));

        //input gathering
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] speedLimit = new int[N][2];
        int[][] speed = new int[M][2];
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            speedLimit[i][0] = Integer.parseInt(st.nextToken());
            speedLimit[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            speed[i][0] = Integer.parseInt(st.nextToken());
            speed[i][1] = Integer.parseInt(st.nextToken());
        }

        //keep track of array locs
        //while running simulation
        int a = 0;
        int b = 0;
        int maxDiff = 0;
        for(int i = 1;i<=100;i++){
            //move to next section
            if(i > speedLimit[a][0]){
                a++;
                speedLimit[a][0] += speedLimit[a-1][0];
            }
            if(i > speed[b][0]){
                b++;
                speed[b][0] += speed[b-1][0];
            }
            //makes var for readibility
            int speedLimit_now = speedLimit[a][1];
            int speed_now = speed[b][1];

            //comparison
            maxDiff = Math.max(maxDiff, speed_now - speedLimit_now);
        }


        pw.println(maxDiff);

        br.close(); pw.close();
    }
}