

/*
    In order to solve this, I used 2 different durations of the race
        Approach when approaching the max speed
        Fade when approaching x from max
    Abbreviations were used:
        D is distance
        T is time
        S is speed
*/
public class Bronze_3{
    public static void main(String[] args){
        Bronze_3_t teachers_method = new Bronze_3_t();
        //int[] arr = {4, 6, 8, 9, 10};
        for(int i = 400000000;i<=1000000000;i+=1){
            int my_sol = solve(i, 1);
            int teach_sol = teachers_method.solve(i);
            if(my_sol == teach_sol){
                //System.out.println("Match!");
            }
            else{
                System.out.println("For k="+i+", is doesn't match");
                //if(my_sol < teach_sol) System.out.println("   Mine is Better");
                //else System.out.println("   Teach is better");
                System.out.println("   My sol: " + my_sol);
                System.out.println("   Teach sol: " + teach_sol);
            }
            //System.out.println("My solution for k="+i+": "+solve(i, 1));
            //System.out.println("Teach's solution for k="+i+": "+teachers_method.solve(i));
            //System.out.println();
        }
        System.out.println("Done!");
    }

    public static int series(int max){
        return max * (max+1) / 2;
    }

    public static int solve(long k, int x){
        //We need to address this case because we assume we will
        //never reach the 'fastest' (variable below)
        if(series(x) == k) return x;

        //The time and max speed when you can do as fast as possible
        int fastest = (int)Math.ceil((-1+Math.sqrt(1+8*k))/2);
        //System.out.println("Max Speed: " + fastest); // use to debug


        
        //The maximum speed that the cow will travel (which we don't know)
        int maxAppS = fastest-1;
        

        //The time and distances that occur from the maxAppS, respectively
        int appT = maxAppS;
        int appD = series(maxAppS);


        //The maximum speed when the cow will travel when reaching finish line
        int maxFadeS = maxAppS - 1;

        //The time and distances that occur from maxFadeS
        int fadeT = maxFadeS - x + 1;
        int fadeD = series(maxFadeS) - series(x-1);

        while(appD + fadeD > k){
            //we simply change maxAppS by -1 and update the other ones respectively
            maxAppS -= 1;
            appT -= 1;
            appD = series(maxAppS);

            maxFadeS -= 1;
            fadeT = maxFadeS -x + 1;
            fadeD = series(maxFadeS) - series(x-1);
        }

        //By here, disTraveledByMaxApproachSpeed + disTraveledByMaxFadeSpeed <= k
        int total_distance = appD + fadeD;
        int total_time = appT + fadeT;
        while(total_distance < k){
            //Adding the maxAppS to the total_distance should, theoretically, reduce the time
            total_distance += maxAppS;
            total_time ++;
        }

        return total_time;
    }
}