public class Bronze_3_t {
    public int solve(int k){
        int n = 1;
        int i = 1;
        int t = k; // meter

        // Start 1 end 1
        while (true) {
            n = i * (i - 1) + 1;
            if (n >= t)
                break;
            n = i * (i + 1);
            if (n >= t)
                break;
            i++;
        }

        int f = i * (i - 1) + 1;
        int l = i * (i + 1);

        // Max speed
        int max = (int) Math.round(Math.sqrt(t * 2));
        //System.out.println(max);

        // actual second //Start 1 end 1
        if (f + i > t){
            //System.out.println(i * 2 - 1);
            return i * 2 - 1;
        }
        else{
            //System.out.println(i * 2);
            return i * 2;
        }
    }
}